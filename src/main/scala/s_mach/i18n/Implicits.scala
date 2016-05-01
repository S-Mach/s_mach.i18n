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
package s_mach.i18n


import scala.language.implicitConversions
import s_mach.codetools.IsDistinctTypeAlias

object Implicits  {
  // Note: this is a duplicate of package without I18N.Implicits

  /* gQdBkrozvt suffix added to prevent shadowing issues */

  /** Distinct type alias I18NString */
  type I18NString = String with I18NStringTag with IsDistinctTypeAlias[String]
  // Note: important that this not be implicit
  def I18NString(value: String) : I18NString = value.asInstanceOf[I18NString]
  /** Implicitly convert any value to an I18NString if an I18N type-class for that type exists */
  implicit def toI18NString[A](value: A)(implicit i18n:I18N[A],cfg: I18NConfig) : I18NString =
    i18n.apply(value)(cfg)

  implicit class StringContextPML_gQdBkrozvt(val self: StringContext) extends AnyVal {
    /** Create and interpolate a I18NString */
    def i18n(args: I18NString*) : I18NString =
      self.raw(args:_*).asI18N
    /** Alias for i18n */
    def i(args: I18NString*) : I18NString = i18n(args:_*)
  }

  implicit class EverythingPML_gQdBkrozvt[A](val self: A) extends AnyVal {
    /** Explicitly convert any value to an I18NString if an I18N type-class for that type exists */
    def i18n(implicit i18n: I18N[A],cfg: I18NConfig) : I18NString =
      i18n(self)
  }

  implicit class CharPML_gQdBkrozvt(val self: Char) extends AnyVal {
    /** Explicitly convert a Char to an I18NString */
    def toI18N : I18NString = I18NString(self.toString)
  }

  implicit class StringPML_gQdBkrozvt(val self: String) extends AnyVal {
    /** Explicitly convert a String to an I18NString */
    def asI18N : I18NString = I18NString(self)
  }
}