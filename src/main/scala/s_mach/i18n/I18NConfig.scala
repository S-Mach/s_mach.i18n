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

import java.util.Locale

case class I18NConfig(
  messages: Messages,
  locale: Locale,
  interpolator: Interpolator,
  numberFormat: I18NNumberFormat
)

object I18NConfig {
  def apply(
    messages: Messages,
    interpolator: Interpolator = Interpolator.default,
    numberFormat: I18NNumberFormat = I18NNumberFormat.default
  )(implicit
    locale: Locale = Locale.getDefault
  ) : I18NConfig = I18NConfig(
    messages = messages,
    locale = locale,
    interpolator = interpolator,
    numberFormat = numberFormat
  )
//  implicit def mkI18NConfig(implicit
//    l: Locale = Locale.getDefault,
//    m:Messages,
//    i:Interpolator = Interpolator.default
//    ) : I18NConfig =
//    I18NConfig(m,l,i)
}