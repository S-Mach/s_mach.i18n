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
import s_mach.i18n.messages.{MessageFormat, MessageResolver}

import scala.util.control.NonFatal

class LaxMessageResolver(
  missingKey: (Symbol,Seq[String]) => String,
  invalidFormat: (Symbol,Seq[String]) => String
) extends MessageResolver {

  def resolveLiteral(key: Symbol)(implicit cfg: I18NConfig) = {
    import cfg._
    messages.get(key) match {
      case Some(MessageFormat.Literal(value)) => value
      case Some(MessageFormat.Interpolation(parts)) =>
        interpolator.interpolate(parts)
      case Some(MessageFormat.Choice(_)) => invalidFormat(key,Nil)
      case None => missingKey(key,Nil)
    }
  }.asI18N

  def resolveInterpolation(key: Symbol, args: I18NString*)(implicit cfg: I18NConfig) = {
    import cfg._
      messages.get(key) match {
        case Some(MessageFormat.Interpolation(parts)) =>
          interpolator.interpolate(parts,args:_*)
        case Some(MessageFormat.Literal(value)) => value
        case Some(MessageFormat.Choice(choice)) =>
          try {
            choice(BigDecimal(args.head))
          } catch {
            case NonFatal(_) =>
              invalidFormat(key,args)
          }
        case None =>
          missingKey(key,args)
      }
  }.asI18N

  def resolveChoice(key: Symbol, value: BigDecimal)(implicit cfg: I18NConfig) = {
    import cfg._
    messages.get(key) match {
      case Some(MessageFormat.Choice(choice)) => choice(value)
      case Some(MessageFormat.Interpolation(parts)) =>
        interpolator.interpolate(parts,value.toString.asI18N)
      case Some(MessageFormat.Literal(literal)) => literal
      case None => missingKey(key,Seq(value.toString()))
    }
  }.asI18N

  override def toString = "LaxMessageResolver"

}

