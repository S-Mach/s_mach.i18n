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

class TolerantInterpolator extends Interpolator {
  def interpolate(parts: Seq[StringPart], args: I18NString*)(implicit cfg: I18NConfig) =
    InterpolatorOps.tolerantInterpolate(parts,args:_*)
  def interpolate(key: String, args: I18NString*)(implicit cfg: I18NConfig) = {
    if(args.nonEmpty) {
      cfg.messages.interpolations.get(key) match {
        case Some(parts) => interpolate(parts,args:_*)
        case None => s"{$key}(${args.mkString(",")})".asI18N
      }
    } else {
      cfg.messages.literals.get(key) match {
        case Some(s) => s.asI18N
        case None => s"{$key}".asI18N
      }
    }
  }
}

