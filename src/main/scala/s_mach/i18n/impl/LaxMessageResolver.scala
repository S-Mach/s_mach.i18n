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

import s_mach.i18n._

class LaxMessageResolver(
  missingKey: (String,Seq[String]) => String
) extends MessageResolver {

  def resolveLiteral(m: Messages, key: String) =
    m.literals.get(key) match {
      case Some(s) => s.asI18N
      case None => missingKey(key,Nil).asI18N
    }

  def resolveInterpolation(m: Messages, key: String, i: Interpolator) = {
    m.interpolations.get(key) match {
      case Some(parts) =>
        { args:Seq[I18NString] =>
          i.interpolate(parts,args:_*)
        }
      case None =>
        { args: Seq[I18NString] =>
          missingKey(key,args).asI18N
        }
    }
  }

  def resolveChoice(m: Messages, key: String) =
    m.choices.get(key) match {
      case Some(f) => { value => f(value).asI18N }
      case None => { value => missingKey(key,Seq(value.toString())).asI18N }
    }
}

