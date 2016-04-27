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

import java.util.Locale

import s_mach.i18n._
import s_mach.i18n.messages.Messages

case class MessagesMap(
  locale: Locale,
  formats: Map[Symbol,I18NFormat]
) extends Messages {
  def keys = formats.keys
  def contains(key: Symbol) = formats.contains(key)
  def get(key: Symbol) = formats.get(key)
  def apply(key: Symbol) = formats(key)
  def applyOrElse(key: Symbol, default: Symbol => I18NFormat): I18NFormat =
    formats.applyOrElse(key,default)
  override def toString = s"Messages(keys=${keys.mkString(",")})"
}

