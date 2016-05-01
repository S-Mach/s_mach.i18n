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

import MessageFormat.Interpolation
import s_mach.i18n._
import s_mach.i18n.impl.{LaxInterpolator, StrictInterpolator}

/**
  * A trait for interpolating arguments into a message format interpolation
  */
trait Interpolator {
  /**
    * Interpolate the supplied arguments into the interpolation parts
    * @param parts interpolation parts to substitute arguments for
    * @param args arguments to substitute into the interpolation
    * @return I18NString
    */
  def interpolate(
    parts: Seq[Interpolation.Part],
    args: I18NString*
  ) : I18NString
}

object Interpolator {
  def apply(f: (Seq[Interpolation.Part],Seq[I18NString]) => I18NString) : Interpolator =
    new Interpolator {
      def interpolate(parts: Seq[Interpolation.Part], args: I18NString*) =
        f(parts,args)
    }
  /** An interpolator that throws an exception on error */
  val strict = new StrictInterpolator
  /** An interpolation that never throws an exception on error but instead
    * returns an error I18NString */
  val lax = new LaxInterpolator(missingArg => s"{$missingArg:missing}")
  val default = strict
}