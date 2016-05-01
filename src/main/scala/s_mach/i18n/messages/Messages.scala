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
package s_mach.i18n.messages

import java.util.Locale
import s_mach.i18n.impl._

/**
  * A trait for retrieving message formats from a message key
  */
trait Messages {
  /** @return locale for message formats returned by this messages */
  def locale: Locale

  def keys: Iterable[Symbol]
  def contains(key: Symbol): Boolean
  def get(key: Symbol) : Option[MessageFormat]
  def apply(key: Symbol) : MessageFormat
  def applyOrElse(key: Symbol, default: Symbol => MessageFormat) : MessageFormat
}

object Messages {
  /** @return Create an in-memory messages */
  def apply(
    locale: Locale,
    formats: (Symbol,MessageFormat)*
  ) : Messages =
    new MessagesMap(locale,formats.toMap)

  /** @return a messages that tries m1 and fallsback to m2 if a key is missing */
  def orElse(
    m1: Messages,
    m2: Messages
  ) : Messages =
    OrElseMessages(m1,m2)
}
