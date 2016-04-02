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

import java.util.Locale

import s_mach.i18n.impl.I18NOps

import scala.language.implicitConversions
import s_mach.codetools.IsDistinctTypeAlias

package object i18n extends I18N.BuiltInImplicits {
  /* gQdBkrozvt suffix added to prevent shadowing issues */

  type I18NString = String with I18NStringTag with IsDistinctTypeAlias[String]
  def I18NString(value: String) : I18NString = value.asInstanceOf[I18NString]
  implicit def toI18NString[A](value: A)(implicit i18n:I18N[A],cfg: I18NConfig) : I18NString =
    i18n.i18n(value)(cfg)

  implicit class StringContextPML_gQdBkrozvt(val self: StringContext) extends AnyVal {
    def p(args: Any*) : Seq[String] = self.parts
    def m(args: Any*) : MessageBuilder = MessageBuilder(self.raw(args:_*))
    def m0(args: Any*) : Message0 = Message0(self.raw(args:_*))
    def mq(args: Any*) : MessageQuantity = MessageQuantity(self.raw(args:_*))

    def i18n(args: I18NString*) : I18NString = I18NOps.i(self)(args:_*)
  }

  implicit class EverythingPML_gQdBkrozvt[A](val self: A) extends AnyVal {
    def i18n(implicit i18n: I18N[A],cfg: I18NConfig) : I18NString =
      I18NOps.i18n(self)(i18n,cfg)
  }

  implicit class StringPML_gQdBkrozvt(val self: String) extends AnyVal {
    def i18n : I18NString = I18NString(self)
  }

  implicit def mkI18NConfig(implicit l: Locale,m:Messages,c:Choices) : I18NConfig =
    I18NConfig(l,m,c)

}
