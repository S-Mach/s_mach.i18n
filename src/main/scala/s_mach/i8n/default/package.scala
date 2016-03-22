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

import s_mach.codetools.IsDistinctTypeAlias
import s_mach.i18n.impl.i18nOps

import scala.language.implicitConversions

package object default extends Implicits {
  /* ysZWWnNgeq suffix added to prevent shadowing issues */

  // Note: default translator uses default Locale
  implicit val defaulti18nTranslator = i18nTranslator.defaulti18nTranslator

  type i18nString = String with i18nTag with IsDistinctTypeAlias[String]
  def i18nString(value: String) : i18nString = value.asInstanceOf[i18nString]
  implicit def toi18nString[A](value: A)(implicit i18n:i18n[A],t: i18nTranslator) : i18nString =
    i18n.i18n(value)(t)

  implicit class EverythingPML_ysZWWnNgeq[A](val self: A) extends AnyVal {
    def i18n(implicit i18n: i18n[A],t: i18nTranslator) : i18nString =
      i18nOps.i18n(self)(i18n,t)
  }

  implicit class StringContextPML_ysZWWnNgeq(val self: StringContext) extends AnyVal {
    def i(args: i18nString*)(implicit t: i18nTranslator) : i18nString =
      i18nOps.i(self)(args:_*)(t)
  }
}
