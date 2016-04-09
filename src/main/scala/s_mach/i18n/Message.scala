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
package s_mach.i18n

import scala.language.implicitConversions

trait Message {

  def key: Symbol

  def throwIfMissing()(implicit m:Messages) : this.type = {
    if(m.contains(key) == false) {
      throw new IllegalArgumentException(s"Messages missing key $key")
    } else {
      this
    }
  }

}

case class MessageBuilder(
  key: Symbol
) {
  def apply[A] = Message1[A](key)
  def apply[A,B] = Message2[A,B](key)
}

case class Literal(
  key: Symbol
) extends Message {
  def apply()(implicit
    cfg: I18NConfig
  ) : I18NString = {
    import cfg._
    resolver.resolveLiteral(messages, key)
  }
}

case class Choice(
  key: Symbol
  ) extends Message {
  def apply[N](
    n: N
    )(implicit
    numeri18nC:Numeric[N],
    cfg: I18NConfig
    ) : I18NString = {
    import cfg._
    resolver.resolveChoice(messages, key)(BigDecimal(n.toString))
  }
}

case class Message1[A](key: Symbol) extends Message {
  def apply(a: A)(implicit
    cfg: I18NConfig,
    i18nA: I18N[A]
    ) : I18NString = {
    import cfg._
    resolver.resolveInterpolation(messages, key, interpolator)(Seq(i18nA(a)))
  }
}

case class Message2[A,B](key: Symbol) extends Message {
  def apply(a: A, b: B)(implicit
    cfg: I18NConfig,
    i18nA: I18N[A],
    i18nB: I18N[B]
  ) : I18NString = {
    import cfg._
    resolver.resolveInterpolation(messages, key, interpolator)(Seq(i18nA(a),i18nB(b)))
  }
}

case class Message3[A,B,C](key: Symbol) extends Message {
  def apply(a: A, b: B, c: C)(implicit
    cfg: I18NConfig,
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C]
  ) : I18NString = {
    import cfg._
    resolver.resolveInterpolation(messages, key, interpolator)(Seq(i18nA(a),i18nB(b),i18nC(c)))
  }
}

case class Message4[A,B,C,D](key: Symbol) extends Message {
  def apply(a: A, b: B, c: C, d: D)(implicit
    cfg: I18NConfig,
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D]
  ) : I18NString = {
    import cfg._
    resolver.resolveInterpolation(messages, key, interpolator)(Seq(i18nA(a),i18nB(b),i18nC(c),i18nD(d)))
  }
}

case class Message5[A,B,C,D,E](key: Symbol) extends Message {
  def apply(a: A, b: B, c: C, d: D, e: E)(implicit
    cfg: I18NConfig,
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E]
  ) : I18NString = {
    import cfg._
    resolver.resolveInterpolation(messages, key, interpolator)(Seq(i18nA(a),i18nB(b),i18nC(c),i18nD(d),i18nE(e)))
  }
}

case class Message6[A,B,C,D,E,F](key: Symbol) extends Message {
  def apply(a: A, b: B, c: C, d: D, e: E, f: F)(implicit
    cfg: I18NConfig,
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F]
  ) : I18NString = {
    import cfg._
    resolver.resolveInterpolation(messages, key, interpolator)(Seq(i18nA(a),i18nB(b),i18nC(c),i18nD(d),i18nE(e),i18nF(f)))
  }
}

