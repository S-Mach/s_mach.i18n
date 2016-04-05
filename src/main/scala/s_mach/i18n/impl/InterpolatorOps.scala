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

import s_mach.i18n.StringPart.Arg
import s_mach.i18n._

object InterpolatorOps {
  @inline def strictInterpolate(
    parts: Seq[StringPart],
    args: I18NString*
  ) : I18NString = {
    val argCount = {
      var idx = -1
      parts.foreach {
        case Arg(n) =>
          require(n >= 0,"Argument index must be positive")
          if(n > idx) {
            idx = n
          }
        case _ =>
      }
      idx + 1
    }
    require(args.size == argCount,s"Expected $argCount args, found ${args.size} args")
    interpolate(
      parts,
      args.apply
    )
  }

  @inline def laxInterpolate(
    missingArg: Int => String
  )(
    parts: Seq[StringPart],
    args: I18NString*
  ) : I18NString =
    interpolate(
      parts,
      args.applyOrElse(_:Int,missingArg)
    )

  @inline def interpolate(
    parts: Seq[StringPart],
    args: Int => String
  ) : I18NString = {
    if(parts.nonEmpty) {
      def handle(i: StringPart) : String = {
        import StringPart._
        i match {
          case Literal(value) => value
          case Arg(arg) => args(arg)
        }
      }
      val sb = new StringBuilder(handle(parts.head))
      parts.tail.foreach(i => sb.append(handle(i)))
      sb.toString().asI18N
    } else {
      "".asI18N
    }
  }

}
