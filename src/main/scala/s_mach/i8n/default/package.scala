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

import s_mach.codetools.IsDistinctTypeAlias
import s_mach.i8n.impl.I8NOps

import scala.language.implicitConversions

package object default extends Implicits {
  /* ysZWWnNgeq suffix added to prevent shadowing issues */

  // Note: default translator uses default Locale
  implicit val defaultI8NTranslator = I8NTranslator.defaultI8NTranslator

  type I8NString = String with I8NTag with IsDistinctTypeAlias[String]
  def I8NString(value: String) : I8NString = value.asInstanceOf[I8NString]
  implicit def toI8NString[A](value: A)(implicit i8n:I8N[A],t: I8NTranslator) : I8NString =
    i8n.i8n(value)(t)

  implicit class EverythingPML_ysZWWnNgeq[A](val self: A) extends AnyVal {
    def i8n(implicit i8n: I8N[A],t: I8NTranslator) : I8NString =
      I8NOps.i8n(self)(i8n,t)
  }

  implicit class StringContextPML_ysZWWnNgeq(val self: StringContext) extends AnyVal {
    def i(args: I8NString*)(implicit t: I8NTranslator) : I8NString =
      I8NOps.i(self)(args:_*)(t)
  }
}
