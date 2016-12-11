/*
                    ,i::,
               :;;;;;;;
              ;:,,::;.
            1ft1;::;1tL
              t1;::;1,
               :;::;               _____       __  ___              __
          fCLff ;:: tfLLC         / ___/      /  |/  /____ _ _____ / /_
         CLft11 :,, i1tffLi       \__ \ ____ / /|_/ // __ `// ___// __ \
         1t1i   .;;   .1tf       ___/ //___// /  / // /_/ // /__ / / / /
       CLt1i    :,:    .1tfL.   /____/     /_/  /_/ \__,_/ \___//_/ /_/
       Lft1,:;:       , 1tfL:
       ;it1i ,,,:::;;;::1tti      s_mach.i18n
         .t1i .,::;;; ;1tt        Copyright (c) 2016 S-Mach, Inc.
         Lft11ii;::;ii1tfL:       Author: lance.gatlin@gmail.com
          .L1 1tt1ttt,,Li
            ...1LLLL...
*/
package s_mach.i18n.impl

import java.io.{ByteArrayInputStream, InputStream}
import java.util.{Locale, ResourceBundle}
import scala.collection.JavaConverters._

class UTF8ResourceBundleControl(
  fileExt: String = "txt"
) extends ResourceBundle.Control {
  val utf8format = "properties.utf8"
  val formats = Seq(utf8format).asJava
  val fallbackLocale = new Locale("")

  override def getFormats(baseName: String) = formats

  override def getFallbackLocale(baseName: String, locale: Locale) = fallbackLocale

  override def newBundle(
    baseName: String,
    locale: Locale,
    fmt: String,
    loader: ClassLoader,
    reload: Boolean
  ): ResourceBundle = {
    // todo: what is reload supposed to do?

    val resourceName = toResourceName(toBundleName(baseName, locale), fileExt)

    {
      for {
        format <- Option(fmt) if format == utf8format
        is <- loadConcatAllResources(resourceName,loader)
      } yield new java.util.PropertyResourceBundle(new java.io.InputStreamReader(is, "UTF-8"))
    } match {
      case Some(rb) => rb
      case None =>
        // Note: returning null for all calls causes something in ResourceBundle.getBundle to hang
        // This ensures at least one empty PropertyResourceBundle is returned to prevent hang
        if(resourceName == s"$baseName.$fileExt") {
          new java.util.PropertyResourceBundle(new ByteArrayInputStream(Array.empty))
        } else {
          None.orNull
        }
    }
  }

  def mkNewLineStream = new ByteArrayInputStream(System.getProperty("line.separator").getBytes("UTF-8"))

  def loadConcatAllResources(
    resourceName: String,
    loader: ClassLoader
  ) : Option[InputStream] = {
    loader.getResources(resourceName).toStream
      // open input streams
      .map(_.openStream())
      // concat
      .reduceOption((i1,i2) =>
        // Ensure there is always a new line between input files
        i1 ++ mkNewLineStream ++ i2
      )
  }

}