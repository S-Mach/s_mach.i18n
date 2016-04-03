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

object I18NOps {
  @inline def interpolate(
    self: Seq[Interpolation]
  )(
    args: I18NString*
  )(implicit
    cfg:I18NConfig
  ) : I18NString = {
    import cfg._
    val _args = args.asInstanceOf[Seq[String]]
    if(self.nonEmpty) {
      def handle(i: Interpolation) : String = {
        import Interpolation._
        i match {
          case Literal(value) => value
          case Arg(arg) => _args.applyOrElse(arg,handleMissingArg)
        }
      }
      val sb = new StringBuilder(handle(self.head))
      self.tail.foreach(i => sb.append(handle(i)))
      sb.toString().i18n
    } else {
      "".i18n
    }
  }

  @inline def i18n[A](self: A)(implicit i18n: I18N[A],cfg: I18NConfig) : I18NString =
    i18n.i18n(self)

  @inline def i(self: StringContext)(args: I18NString*) : I18NString =
    I18NString(self.standardInterpolator(identity,args))
}
