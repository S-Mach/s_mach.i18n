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

import s_mach.i18n._
import s_mach.i18n.impl._

/**
  * A trait that resolves message keys using the I18N configuration and handling errors
  */
trait MessageResolver {
  /** @return the literal for the key */
  def resolveLiteral(key: Symbol)(implicit cfg: I18NConfig) : I18NString
  /** @return the I18NString created from supplying value to the choice associated with the key */
  def resolveChoice(key: Symbol, value: BigDecimal)(implicit cfg: I18NConfig) : I18NString
  /** @return the I18NString created from supplying args to the interpolation associated with the key */
  def resolveInterpolation(key: Symbol, args: I18NString*)(implicit cfg: I18NConfig) : I18NString
}

object MessageResolver {
  /** A message resolver that throws an error if a problem is encountered */
  val strict = new StrictMessageResolver
  /** A message resolver that never throws an error if a problem is encountered and instead
    * returns an error I18NString */
  val lax = new LaxMessageResolver(
    missingKey = (missingKey,args) => s"{${missingKey.name}:missing}${
      if(args.nonEmpty) {
        s"(${args.mkString(",")})"
      } else {
        ""
      }
    }",
    invalidFormat = (key,args) => s"{${key.name}:invalid}(${args.mkString(",")})"
  )
  val default = strict
}
