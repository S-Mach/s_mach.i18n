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

import java.util.{Locale, ResourceBundle}
import s_mach.i18n.messages._
import s_mach.string._
import MessageFormat.Interpolation._

object DefaultUTF8Messages {
  private val fakeFormat = new java.text.Format {
    // Never called
    def parseObject(source: String, pos: java.text.ParsePosition) = ???
    def format(obj: scala.Any, toAppendTo: StringBuffer, pos: java.text.FieldPosition) =
      toAppendTo.append(obj.toString)
  }

  private val uniqueKey = "<>" * 12
  private val parseRegex = s"$uniqueKey([0-9]+)".r

  def apply(
    locale: Locale,
    fileBaseDir: String = "conf",
    fileBaseName: String = "messages",
    fileExt: String = "txt"
  ) : Messages = {
    // Note: can't load multiple resources with same name without a base dir
    // See https://stackoverflow.com/questions/6730580/how-to-read-several-resource-files-with-the-same-name-from-different-jars
    require(fileBaseDir.length > 0,"Base directory must not be empty")

    val control = new UTF8ResourceBundleControl(
      fileExt = fileExt
    )
    val bundle = ResourceBundle.getBundle(s"${fileBaseDir.ensureSuffix("/")}$fileBaseName", locale, control)

    val keyToFormats =
      bundle.getKeys.toStream.map { k =>
        val raw = bundle.getString(k)
        val fmt = new java.text.MessageFormat(raw)
        val parts =
          fmt.getFormats.length match {
            case 0 => MessageFormat.Literal(raw)
            case 1 if fmt.getFormats.head.isInstanceOf[java.text.ChoiceFormat] =>
              MessageFormat.Choice({ n =>
                fmt.format(
                  Array(n.underlying().doubleValue()).map(_.asInstanceOf[java.lang.Object])
                )
              })
            case argsCount =>
              // Force all formats to simple string replacement
              val formats = Array.fill[java.text.Format](argsCount)(fakeFormat)
              fmt.setFormats(formats)
              // Inject unique key and arg number as fake args to allow
              // standardized parsing below
              val parseable = fmt.format(
                (0 until argsCount).map(i => s"$uniqueKey$i").toArray
              )
              case class M(
                start: Int,
                end: Int,
                argIdx: Int
              )
              // Parse simplified interpolation format
              val ms = parseRegex.findAllMatchIn(parseable)
                .map(m => M(m.start,m.end,m.group(1).toInt))
              // Note: impossible for ms not to match at least once since there at
              // least one arg at this point
              val builder = Seq.newBuilder[Part]
              val _lastIdx =
                ms.foldLeft(0) { case (lastIdx,m) =>
                  if(lastIdx < m.start) {
                    builder += Part.Literal(parseable.substring(lastIdx, m.start))
                  }
                  builder += Part.StringArg(m.argIdx)
                  m.end
                }
              if(_lastIdx != parseable.length) {
                builder += Part.Literal(parseable.substring(_lastIdx))
              }
              MessageFormat.Interpolation(builder.result())
          }
        Symbol(k) -> parts
      }
    Messages(
      locale = locale,
      keyToFormats:_*
    )
  }

}