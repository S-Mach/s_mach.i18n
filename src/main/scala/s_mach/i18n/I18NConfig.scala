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

import s_mach.i18n.messages._

/**
  * The configuration used for formatting and internationalization
  * @param messages retrieves message formats for messages
  * @param interpolator interpolates arguments into message formats
  * @param resolver resolves message formats from key
  * @param stdI18N formats built-in types
  */
case class I18NConfig(
  messages: Messages,
  interpolator: Interpolator,
  resolver: MessageResolver,
  stdI18N: StdI18N
) {
  def locale = messages.locale
}

object I18NConfig {
  def apply(
    locale: Locale
  ) : I18NConfig =
    apply(UTF8Messages(locale))

  def apply(
    messages: Messages
  ) : I18NConfig = I18NConfig(
    messages = messages,
    interpolator = Interpolator.default,
    resolver = MessageResolver.default,
    stdI18N = StdI18N.default
  )

  def apply(
    messages: Messages,
    interpolator: Interpolator,
    resolver: MessageResolver
  ) : I18NConfig = I18NConfig(
    messages = messages,
    interpolator = interpolator,
    resolver = resolver,
    stdI18N = StdI18N.default
  )

  def apply(
    messages: Messages,
    stdI18N : StdI18N
  ) : I18NConfig = I18NConfig(
    messages = messages,
    interpolator = Interpolator.default,
    resolver = MessageResolver.default,
    stdI18N = stdI18N
  )

  def apply(
    messages: Messages,
    strict: Boolean,
    stdI18N: StdI18N = StdI18N.default
  ) : I18NConfig =
    if(strict) {
      I18NConfig(
        messages = messages,
        interpolator = Interpolator.strict,
        resolver = MessageResolver.strict,
        stdI18N = stdI18N
      )
    } else {
      I18NConfig(
        messages = messages,
        interpolator = Interpolator.lax,
        resolver = MessageResolver.lax,
        stdI18N = stdI18N
      )
    }
}