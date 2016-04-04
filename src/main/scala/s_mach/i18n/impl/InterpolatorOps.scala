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

import s_mach.i18n.Interpolation.Arg
import s_mach.i18n._

object InterpolatorOps {
  @inline def strictInterpolate(
    parts: Seq[Interpolation],
    args: I18NString*
  )(implicit
    cfg:I18NConfig
  ) : I18NString =
    interpolate(
      strict = true,
      parts = parts,
      args:_*
    )

  @inline def tolerantInterpolate(
    parts: Seq[Interpolation],
    args: I18NString*
    )(implicit
    cfg:I18NConfig
    ) : I18NString =
    interpolate(
      strict = false,
      parts = parts,
      args:_*
    )

  @inline def interpolate(
    strict: Boolean,
    parts: Seq[Interpolation],
    args: I18NString*
  )(implicit
    cfg:I18NConfig
  ) : I18NString = {
    val _args = args.asInstanceOf[Seq[String]]
    if(strict) {
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
    }

    if(parts.nonEmpty) {
      val f = if(strict) {
        _args(_:Int)
      } else {
        _args.applyOrElse(_:Int,(_:Int) => "(null)")
      }
      def handle(i: Interpolation) : String = {
        import Interpolation._
        i match {
          case Literal(value) => value
          case Arg(arg) => f(arg)
        }
      }
      val sb = new StringBuilder(handle(parts.head))
      parts.tail.foreach(i => sb.append(handle(i)))
      sb.toString().i18n
    } else {
      "".i18n
    }
  }

}