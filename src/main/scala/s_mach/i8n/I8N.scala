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

/**
 * A type-class for converting an instance of a type to an internationalized string
 * (generally based on locale)
 */
trait i18n[A] {
  def i18n(a: A)(implicit t: i18nTranslator) : i18nString
}

object i18n {
  def apply[A](f: (A,i18nTranslator) => String) : i18n[A] =
    new i18n[A] {
      def i18n(a: A)(implicit t: i18nTranslator) = i18nString(f(a,t))
    }
}

// how to print currency, date and quantities varies by language
