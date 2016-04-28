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

import s_mach.i18n.messages.{I18NFormat, Messages}

case class OrElseMessages(
  m1: Messages,
  m2: Messages
) extends Messages {
  require(m1.locale == m2.locale)

  val locale = m1.locale

  def get(key: Symbol): Option[I18NFormat] =
    m1.get(key) orElse m2.get(key)

  def keys: Iterable[Symbol] =
    m1.keys.toSet ++ m2.keys

  def contains(key: Symbol): Boolean =
    m1.contains(key) || m2.contains(key)

  def apply(key: Symbol) : I18NFormat =
    m1.applyOrElse(key,m2.apply)

  def applyOrElse(key: Symbol, default: Symbol => I18NFormat): I18NFormat =
    m1.applyOrElse(key,m2.applyOrElse(_, default))

}
