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
import s_mach.i18n.messages.MessageResolver

class StrictMessageResolver extends MessageResolver {
  def resolveLiteral(key: Symbol)(implicit cfg: I18NConfig): I18NString =
    cfg.messages(key) match {
      case I18NFormat.Literal(value) => value.asI18N
      case otherFormat => throw new IllegalArgumentException(s"Expected Format.Literal but found $otherFormat")
    }

  def resolveChoice(key: Symbol, value: BigDecimal)(implicit cfg: I18NConfig): I18NString =
    cfg.messages(key) match {
      case I18NFormat.Choice(choice) => choice(value).asI18N
      case otherFormat => throw new IllegalArgumentException(s"Expected Format.Choice but found $otherFormat")
    }

  def resolveInterpolation(key: Symbol, args: I18NString*)(implicit cfg: I18NConfig): I18NString =
    cfg.messages(key) match {
      case I18NFormat.Interpolation(parts) => cfg.interpolator.interpolate(parts,args:_*)
      case otherFormat => throw new IllegalArgumentException(s"Expected Format.Interpolation but found $otherFormat")
    }
}
