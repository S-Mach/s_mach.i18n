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
package s_mach

import scala.language.implicitConversions
import s_mach.codetools.IsDistinctTypeAlias

package object i18n extends I18N.Implicits {
  /* gQdBkrozvt suffix added to prevent shadowing issues */

  type I18NString = String with I18NStringTag with IsDistinctTypeAlias[String]
  def I18NString(value: String) : I18NString = value.asInstanceOf[I18NString]
  implicit def toI18NString[A](value: A)(implicit i18n:I18N[A],cfg: I18NConfig) : I18NString =
    i18n.apply(value)(cfg)

  implicit class StringContextPML_gQdBkrozvt(val self: StringContext) extends AnyVal {
    def i18n(args: I18NString*) : I18NString =
      self.raw(args:_*).asI18N
  }

  implicit class EverythingPML_gQdBkrozvt[A](val self: A) extends AnyVal {
    def i18n(implicit i18n: I18N[A],cfg: I18NConfig) : I18NString =
      i18n(self)
  }

  implicit class CharPML_gQdBkrozvt(val self: Char) extends AnyVal {
    def toI18N : I18NString = I18NString(self.toString)
  }

  implicit class StringPML_gQdBkrozvt(val self: String) extends AnyVal {
    def asI18N : I18NString = I18NString(self)
    def m : MessageBuilder = MessageBuilder(self)
    def m0 : Literal = Literal(self)
    def literal : Literal = Literal(self)
    def choice : Choice = Choice(self)
  }
}
