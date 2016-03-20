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
       ;it1i ,,,:::;;;::1tti      s_mach.i8n
         .t1i .,::;;; ;1tt        Copyright (c) 2016 S-Mach, Inc.
         Lft11ii;::;ii1tfL:       Author: lance.gatlin@gmail.com
          .L1 1tt1ttt,,Li
            ...1LLLL...
*/
package s_mach.i8n

import java.util.Locale

import s_mach.i8n.impl.NoopMessageFor

trait MessageFor {
  def locale: Locale
  def translate(parts: Seq[String], args: I8NString*) : I8NString
  def translate(value: String) : I8NString

  type MessageKey
  def mkKey(parts: Seq[String]) : MessageKey
  def mkKey(value: String) : MessageKey
  def findByKey(key: MessageKey, args: I8NString*) : I8NString

  final def findByParts(parts: Seq[String], args: I8NString*) : String =
    findByKey(mkKey(parts),args:_*)

  final def findByValue(value: String, args: I8NString*) : String =
    findByKey(mkKey(value),args:_*)
}

object MessageFor {
  def noop(locale: Locale) : MessageFor = new NoopMessageFor(locale)
  val defaultMessageFor = MessageFor.noop(Locale.getDefault)
 object Implicits {
    implicit val defaultMessageFor = MessageFor.defaultMessageFor
  }
}