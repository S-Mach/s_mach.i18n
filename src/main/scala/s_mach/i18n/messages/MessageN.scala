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

/* WARNING: Generated code. To modify see s_mach.i18n.codegen.MessageNCodeGen */


case class BoundMessage1[A](
  key: Symbol,
  a: A
)(implicit
  i18nA: I18N[A]
) extends BoundMessage {
  override def apply()(implicit cfg:I18NConfig) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a)
    )
}

case class Message1[A](key: Symbol) extends Message {
  def apply(a:A)(implicit
    cfg: I18NConfig,
    i18nA: I18N[A]
  ) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a)
    )
  def bind(a:A)(implicit
    i18nA: I18N[A]
  ) : BoundMessage1[A] = BoundMessage1(key,a)
}


case class BoundMessage2[A,B](
  key: Symbol,
  a: A,
  b: B
)(implicit
  i18nA: I18N[A],
    i18nB: I18N[B]
) extends BoundMessage {
  override def apply()(implicit cfg:I18NConfig) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b)
    )
}

case class Message2[A,B](key: Symbol) extends Message {
  def apply(a:A,b:B)(implicit
    cfg: I18NConfig,
    i18nA: I18N[A],
    i18nB: I18N[B]
  ) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b)
    )
  def bind(a:A,b:B)(implicit
    i18nA: I18N[A],
    i18nB: I18N[B]
  ) : BoundMessage2[A,B] = BoundMessage2(key,a,b)
}


case class BoundMessage3[A,B,C](
  key: Symbol,
  a: A,
  b: B,
  c: C
)(implicit
  i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C]
) extends BoundMessage {
  override def apply()(implicit cfg:I18NConfig) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c)
    )
}

case class Message3[A,B,C](key: Symbol) extends Message {
  def apply(a:A,b:B,c:C)(implicit
    cfg: I18NConfig,
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C]
  ) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c)
    )
  def bind(a:A,b:B,c:C)(implicit
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C]
  ) : BoundMessage3[A,B,C] = BoundMessage3(key,a,b,c)
}


case class BoundMessage4[A,B,C,D](
  key: Symbol,
  a: A,
  b: B,
  c: C,
  d: D
)(implicit
  i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D]
) extends BoundMessage {
  override def apply()(implicit cfg:I18NConfig) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d)
    )
}

case class Message4[A,B,C,D](key: Symbol) extends Message {
  def apply(a:A,b:B,c:C,d:D)(implicit
    cfg: I18NConfig,
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D]
  ) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d)
    )
  def bind(a:A,b:B,c:C,d:D)(implicit
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D]
  ) : BoundMessage4[A,B,C,D] = BoundMessage4(key,a,b,c,d)
}


case class BoundMessage5[A,B,C,D,E](
  key: Symbol,
  a: A,
  b: B,
  c: C,
  d: D,
  e: E
)(implicit
  i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E]
) extends BoundMessage {
  override def apply()(implicit cfg:I18NConfig) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e)
    )
}

case class Message5[A,B,C,D,E](key: Symbol) extends Message {
  def apply(a:A,b:B,c:C,d:D,e:E)(implicit
    cfg: I18NConfig,
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E]
  ) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e)
    )
  def bind(a:A,b:B,c:C,d:D,e:E)(implicit
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E]
  ) : BoundMessage5[A,B,C,D,E] = BoundMessage5(key,a,b,c,d,e)
}


case class BoundMessage6[A,B,C,D,E,F](
  key: Symbol,
  a: A,
  b: B,
  c: C,
  d: D,
  e: E,
  f: F
)(implicit
  i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F]
) extends BoundMessage {
  override def apply()(implicit cfg:I18NConfig) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f)
    )
}

case class Message6[A,B,C,D,E,F](key: Symbol) extends Message {
  def apply(a:A,b:B,c:C,d:D,e:E,f:F)(implicit
    cfg: I18NConfig,
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F]
  ) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f)
    )
  def bind(a:A,b:B,c:C,d:D,e:E,f:F)(implicit
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F]
  ) : BoundMessage6[A,B,C,D,E,F] = BoundMessage6(key,a,b,c,d,e,f)
}


case class BoundMessage7[A,B,C,D,E,F,G](
  key: Symbol,
  a: A,
  b: B,
  c: C,
  d: D,
  e: E,
  f: F,
  g: G
)(implicit
  i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G]
) extends BoundMessage {
  override def apply()(implicit cfg:I18NConfig) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g)
    )
}

case class Message7[A,B,C,D,E,F,G](key: Symbol) extends Message {
  def apply(a:A,b:B,c:C,d:D,e:E,f:F,g:G)(implicit
    cfg: I18NConfig,
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G]
  ) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g)
    )
  def bind(a:A,b:B,c:C,d:D,e:E,f:F,g:G)(implicit
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G]
  ) : BoundMessage7[A,B,C,D,E,F,G] = BoundMessage7(key,a,b,c,d,e,f,g)
}


case class BoundMessage8[A,B,C,D,E,F,G,H](
  key: Symbol,
  a: A,
  b: B,
  c: C,
  d: D,
  e: E,
  f: F,
  g: G,
  h: H
)(implicit
  i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H]
) extends BoundMessage {
  override def apply()(implicit cfg:I18NConfig) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h)
    )
}

case class Message8[A,B,C,D,E,F,G,H](key: Symbol) extends Message {
  def apply(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H)(implicit
    cfg: I18NConfig,
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H]
  ) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h)
    )
  def bind(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H)(implicit
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H]
  ) : BoundMessage8[A,B,C,D,E,F,G,H] = BoundMessage8(key,a,b,c,d,e,f,g,h)
}


case class BoundMessage9[A,B,C,D,E,F,G,H,I](
  key: Symbol,
  a: A,
  b: B,
  c: C,
  d: D,
  e: E,
  f: F,
  g: G,
  h: H,
  i: I
)(implicit
  i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I]
) extends BoundMessage {
  override def apply()(implicit cfg:I18NConfig) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h),
      i18nI(i)
    )
}

case class Message9[A,B,C,D,E,F,G,H,I](key: Symbol) extends Message {
  def apply(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H,i:I)(implicit
    cfg: I18NConfig,
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I]
  ) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h),
      i18nI(i)
    )
  def bind(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H,i:I)(implicit
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I]
  ) : BoundMessage9[A,B,C,D,E,F,G,H,I] = BoundMessage9(key,a,b,c,d,e,f,g,h,i)
}


case class BoundMessage10[A,B,C,D,E,F,G,H,I,J](
  key: Symbol,
  a: A,
  b: B,
  c: C,
  d: D,
  e: E,
  f: F,
  g: G,
  h: H,
  i: I,
  j: J
)(implicit
  i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J]
) extends BoundMessage {
  override def apply()(implicit cfg:I18NConfig) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h),
      i18nI(i),
      i18nJ(j)
    )
}

case class Message10[A,B,C,D,E,F,G,H,I,J](key: Symbol) extends Message {
  def apply(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H,i:I,j:J)(implicit
    cfg: I18NConfig,
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J]
  ) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h),
      i18nI(i),
      i18nJ(j)
    )
  def bind(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H,i:I,j:J)(implicit
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J]
  ) : BoundMessage10[A,B,C,D,E,F,G,H,I,J] = BoundMessage10(key,a,b,c,d,e,f,g,h,i,j)
}


case class BoundMessage11[A,B,C,D,E,F,G,H,I,J,K](
  key: Symbol,
  a: A,
  b: B,
  c: C,
  d: D,
  e: E,
  f: F,
  g: G,
  h: H,
  i: I,
  j: J,
  k: K
)(implicit
  i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K]
) extends BoundMessage {
  override def apply()(implicit cfg:I18NConfig) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h),
      i18nI(i),
      i18nJ(j),
      i18nK(k)
    )
}

case class Message11[A,B,C,D,E,F,G,H,I,J,K](key: Symbol) extends Message {
  def apply(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H,i:I,j:J,k:K)(implicit
    cfg: I18NConfig,
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K]
  ) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h),
      i18nI(i),
      i18nJ(j),
      i18nK(k)
    )
  def bind(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H,i:I,j:J,k:K)(implicit
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K]
  ) : BoundMessage11[A,B,C,D,E,F,G,H,I,J,K] = BoundMessage11(key,a,b,c,d,e,f,g,h,i,j,k)
}


case class BoundMessage12[A,B,C,D,E,F,G,H,I,J,K,L](
  key: Symbol,
  a: A,
  b: B,
  c: C,
  d: D,
  e: E,
  f: F,
  g: G,
  h: H,
  i: I,
  j: J,
  k: K,
  l: L
)(implicit
  i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L]
) extends BoundMessage {
  override def apply()(implicit cfg:I18NConfig) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h),
      i18nI(i),
      i18nJ(j),
      i18nK(k),
      i18nL(l)
    )
}

case class Message12[A,B,C,D,E,F,G,H,I,J,K,L](key: Symbol) extends Message {
  def apply(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H,i:I,j:J,k:K,l:L)(implicit
    cfg: I18NConfig,
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L]
  ) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h),
      i18nI(i),
      i18nJ(j),
      i18nK(k),
      i18nL(l)
    )
  def bind(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H,i:I,j:J,k:K,l:L)(implicit
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L]
  ) : BoundMessage12[A,B,C,D,E,F,G,H,I,J,K,L] = BoundMessage12(key,a,b,c,d,e,f,g,h,i,j,k,l)
}


case class BoundMessage13[A,B,C,D,E,F,G,H,I,J,K,L,M](
  key: Symbol,
  a: A,
  b: B,
  c: C,
  d: D,
  e: E,
  f: F,
  g: G,
  h: H,
  i: I,
  j: J,
  k: K,
  l: L,
  m: M
)(implicit
  i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M]
) extends BoundMessage {
  override def apply()(implicit cfg:I18NConfig) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h),
      i18nI(i),
      i18nJ(j),
      i18nK(k),
      i18nL(l),
      i18nM(m)
    )
}

case class Message13[A,B,C,D,E,F,G,H,I,J,K,L,M](key: Symbol) extends Message {
  def apply(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H,i:I,j:J,k:K,l:L,m:M)(implicit
    cfg: I18NConfig,
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M]
  ) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h),
      i18nI(i),
      i18nJ(j),
      i18nK(k),
      i18nL(l),
      i18nM(m)
    )
  def bind(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H,i:I,j:J,k:K,l:L,m:M)(implicit
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M]
  ) : BoundMessage13[A,B,C,D,E,F,G,H,I,J,K,L,M] = BoundMessage13(key,a,b,c,d,e,f,g,h,i,j,k,l,m)
}


case class BoundMessage14[A,B,C,D,E,F,G,H,I,J,K,L,M,N](
  key: Symbol,
  a: A,
  b: B,
  c: C,
  d: D,
  e: E,
  f: F,
  g: G,
  h: H,
  i: I,
  j: J,
  k: K,
  l: L,
  m: M,
  n: N
)(implicit
  i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M],
    i18nN: I18N[N]
) extends BoundMessage {
  override def apply()(implicit cfg:I18NConfig) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h),
      i18nI(i),
      i18nJ(j),
      i18nK(k),
      i18nL(l),
      i18nM(m),
      i18nN(n)
    )
}

case class Message14[A,B,C,D,E,F,G,H,I,J,K,L,M,N](key: Symbol) extends Message {
  def apply(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H,i:I,j:J,k:K,l:L,m:M,n:N)(implicit
    cfg: I18NConfig,
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M],
    i18nN: I18N[N]
  ) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h),
      i18nI(i),
      i18nJ(j),
      i18nK(k),
      i18nL(l),
      i18nM(m),
      i18nN(n)
    )
  def bind(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H,i:I,j:J,k:K,l:L,m:M,n:N)(implicit
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M],
    i18nN: I18N[N]
  ) : BoundMessage14[A,B,C,D,E,F,G,H,I,J,K,L,M,N] = BoundMessage14(key,a,b,c,d,e,f,g,h,i,j,k,l,m,n)
}


case class BoundMessage15[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O](
  key: Symbol,
  a: A,
  b: B,
  c: C,
  d: D,
  e: E,
  f: F,
  g: G,
  h: H,
  i: I,
  j: J,
  k: K,
  l: L,
  m: M,
  n: N,
  o: O
)(implicit
  i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M],
    i18nN: I18N[N],
    i18nO: I18N[O]
) extends BoundMessage {
  override def apply()(implicit cfg:I18NConfig) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h),
      i18nI(i),
      i18nJ(j),
      i18nK(k),
      i18nL(l),
      i18nM(m),
      i18nN(n),
      i18nO(o)
    )
}

case class Message15[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O](key: Symbol) extends Message {
  def apply(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H,i:I,j:J,k:K,l:L,m:M,n:N,o:O)(implicit
    cfg: I18NConfig,
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M],
    i18nN: I18N[N],
    i18nO: I18N[O]
  ) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h),
      i18nI(i),
      i18nJ(j),
      i18nK(k),
      i18nL(l),
      i18nM(m),
      i18nN(n),
      i18nO(o)
    )
  def bind(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H,i:I,j:J,k:K,l:L,m:M,n:N,o:O)(implicit
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M],
    i18nN: I18N[N],
    i18nO: I18N[O]
  ) : BoundMessage15[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O] = BoundMessage15(key,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o)
}


case class BoundMessage16[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P](
  key: Symbol,
  a: A,
  b: B,
  c: C,
  d: D,
  e: E,
  f: F,
  g: G,
  h: H,
  i: I,
  j: J,
  k: K,
  l: L,
  m: M,
  n: N,
  o: O,
  p: P
)(implicit
  i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M],
    i18nN: I18N[N],
    i18nO: I18N[O],
    i18nP: I18N[P]
) extends BoundMessage {
  override def apply()(implicit cfg:I18NConfig) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h),
      i18nI(i),
      i18nJ(j),
      i18nK(k),
      i18nL(l),
      i18nM(m),
      i18nN(n),
      i18nO(o),
      i18nP(p)
    )
}

case class Message16[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P](key: Symbol) extends Message {
  def apply(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H,i:I,j:J,k:K,l:L,m:M,n:N,o:O,p:P)(implicit
    cfg: I18NConfig,
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M],
    i18nN: I18N[N],
    i18nO: I18N[O],
    i18nP: I18N[P]
  ) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h),
      i18nI(i),
      i18nJ(j),
      i18nK(k),
      i18nL(l),
      i18nM(m),
      i18nN(n),
      i18nO(o),
      i18nP(p)
    )
  def bind(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H,i:I,j:J,k:K,l:L,m:M,n:N,o:O,p:P)(implicit
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M],
    i18nN: I18N[N],
    i18nO: I18N[O],
    i18nP: I18N[P]
  ) : BoundMessage16[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P] = BoundMessage16(key,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p)
}


case class BoundMessage17[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q](
  key: Symbol,
  a: A,
  b: B,
  c: C,
  d: D,
  e: E,
  f: F,
  g: G,
  h: H,
  i: I,
  j: J,
  k: K,
  l: L,
  m: M,
  n: N,
  o: O,
  p: P,
  q: Q
)(implicit
  i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M],
    i18nN: I18N[N],
    i18nO: I18N[O],
    i18nP: I18N[P],
    i18nQ: I18N[Q]
) extends BoundMessage {
  override def apply()(implicit cfg:I18NConfig) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h),
      i18nI(i),
      i18nJ(j),
      i18nK(k),
      i18nL(l),
      i18nM(m),
      i18nN(n),
      i18nO(o),
      i18nP(p),
      i18nQ(q)
    )
}

case class Message17[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q](key: Symbol) extends Message {
  def apply(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H,i:I,j:J,k:K,l:L,m:M,n:N,o:O,p:P,q:Q)(implicit
    cfg: I18NConfig,
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M],
    i18nN: I18N[N],
    i18nO: I18N[O],
    i18nP: I18N[P],
    i18nQ: I18N[Q]
  ) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h),
      i18nI(i),
      i18nJ(j),
      i18nK(k),
      i18nL(l),
      i18nM(m),
      i18nN(n),
      i18nO(o),
      i18nP(p),
      i18nQ(q)
    )
  def bind(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H,i:I,j:J,k:K,l:L,m:M,n:N,o:O,p:P,q:Q)(implicit
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M],
    i18nN: I18N[N],
    i18nO: I18N[O],
    i18nP: I18N[P],
    i18nQ: I18N[Q]
  ) : BoundMessage17[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q] = BoundMessage17(key,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q)
}


case class BoundMessage18[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R](
  key: Symbol,
  a: A,
  b: B,
  c: C,
  d: D,
  e: E,
  f: F,
  g: G,
  h: H,
  i: I,
  j: J,
  k: K,
  l: L,
  m: M,
  n: N,
  o: O,
  p: P,
  q: Q,
  r: R
)(implicit
  i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M],
    i18nN: I18N[N],
    i18nO: I18N[O],
    i18nP: I18N[P],
    i18nQ: I18N[Q],
    i18nR: I18N[R]
) extends BoundMessage {
  override def apply()(implicit cfg:I18NConfig) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h),
      i18nI(i),
      i18nJ(j),
      i18nK(k),
      i18nL(l),
      i18nM(m),
      i18nN(n),
      i18nO(o),
      i18nP(p),
      i18nQ(q),
      i18nR(r)
    )
}

case class Message18[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R](key: Symbol) extends Message {
  def apply(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H,i:I,j:J,k:K,l:L,m:M,n:N,o:O,p:P,q:Q,r:R)(implicit
    cfg: I18NConfig,
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M],
    i18nN: I18N[N],
    i18nO: I18N[O],
    i18nP: I18N[P],
    i18nQ: I18N[Q],
    i18nR: I18N[R]
  ) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h),
      i18nI(i),
      i18nJ(j),
      i18nK(k),
      i18nL(l),
      i18nM(m),
      i18nN(n),
      i18nO(o),
      i18nP(p),
      i18nQ(q),
      i18nR(r)
    )
  def bind(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H,i:I,j:J,k:K,l:L,m:M,n:N,o:O,p:P,q:Q,r:R)(implicit
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M],
    i18nN: I18N[N],
    i18nO: I18N[O],
    i18nP: I18N[P],
    i18nQ: I18N[Q],
    i18nR: I18N[R]
  ) : BoundMessage18[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R] = BoundMessage18(key,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r)
}


case class BoundMessage19[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S](
  key: Symbol,
  a: A,
  b: B,
  c: C,
  d: D,
  e: E,
  f: F,
  g: G,
  h: H,
  i: I,
  j: J,
  k: K,
  l: L,
  m: M,
  n: N,
  o: O,
  p: P,
  q: Q,
  r: R,
  s: S
)(implicit
  i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M],
    i18nN: I18N[N],
    i18nO: I18N[O],
    i18nP: I18N[P],
    i18nQ: I18N[Q],
    i18nR: I18N[R],
    i18nS: I18N[S]
) extends BoundMessage {
  override def apply()(implicit cfg:I18NConfig) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h),
      i18nI(i),
      i18nJ(j),
      i18nK(k),
      i18nL(l),
      i18nM(m),
      i18nN(n),
      i18nO(o),
      i18nP(p),
      i18nQ(q),
      i18nR(r),
      i18nS(s)
    )
}

case class Message19[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S](key: Symbol) extends Message {
  def apply(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H,i:I,j:J,k:K,l:L,m:M,n:N,o:O,p:P,q:Q,r:R,s:S)(implicit
    cfg: I18NConfig,
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M],
    i18nN: I18N[N],
    i18nO: I18N[O],
    i18nP: I18N[P],
    i18nQ: I18N[Q],
    i18nR: I18N[R],
    i18nS: I18N[S]
  ) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h),
      i18nI(i),
      i18nJ(j),
      i18nK(k),
      i18nL(l),
      i18nM(m),
      i18nN(n),
      i18nO(o),
      i18nP(p),
      i18nQ(q),
      i18nR(r),
      i18nS(s)
    )
  def bind(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H,i:I,j:J,k:K,l:L,m:M,n:N,o:O,p:P,q:Q,r:R,s:S)(implicit
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M],
    i18nN: I18N[N],
    i18nO: I18N[O],
    i18nP: I18N[P],
    i18nQ: I18N[Q],
    i18nR: I18N[R],
    i18nS: I18N[S]
  ) : BoundMessage19[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S] = BoundMessage19(key,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s)
}


case class BoundMessage20[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T](
  key: Symbol,
  a: A,
  b: B,
  c: C,
  d: D,
  e: E,
  f: F,
  g: G,
  h: H,
  i: I,
  j: J,
  k: K,
  l: L,
  m: M,
  n: N,
  o: O,
  p: P,
  q: Q,
  r: R,
  s: S,
  t: T
)(implicit
  i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M],
    i18nN: I18N[N],
    i18nO: I18N[O],
    i18nP: I18N[P],
    i18nQ: I18N[Q],
    i18nR: I18N[R],
    i18nS: I18N[S],
    i18nT: I18N[T]
) extends BoundMessage {
  override def apply()(implicit cfg:I18NConfig) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h),
      i18nI(i),
      i18nJ(j),
      i18nK(k),
      i18nL(l),
      i18nM(m),
      i18nN(n),
      i18nO(o),
      i18nP(p),
      i18nQ(q),
      i18nR(r),
      i18nS(s),
      i18nT(t)
    )
}

case class Message20[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T](key: Symbol) extends Message {
  def apply(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H,i:I,j:J,k:K,l:L,m:M,n:N,o:O,p:P,q:Q,r:R,s:S,t:T)(implicit
    cfg: I18NConfig,
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M],
    i18nN: I18N[N],
    i18nO: I18N[O],
    i18nP: I18N[P],
    i18nQ: I18N[Q],
    i18nR: I18N[R],
    i18nS: I18N[S],
    i18nT: I18N[T]
  ) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h),
      i18nI(i),
      i18nJ(j),
      i18nK(k),
      i18nL(l),
      i18nM(m),
      i18nN(n),
      i18nO(o),
      i18nP(p),
      i18nQ(q),
      i18nR(r),
      i18nS(s),
      i18nT(t)
    )
  def bind(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H,i:I,j:J,k:K,l:L,m:M,n:N,o:O,p:P,q:Q,r:R,s:S,t:T)(implicit
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M],
    i18nN: I18N[N],
    i18nO: I18N[O],
    i18nP: I18N[P],
    i18nQ: I18N[Q],
    i18nR: I18N[R],
    i18nS: I18N[S],
    i18nT: I18N[T]
  ) : BoundMessage20[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T] = BoundMessage20(key,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t)
}


case class BoundMessage21[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U](
  key: Symbol,
  a: A,
  b: B,
  c: C,
  d: D,
  e: E,
  f: F,
  g: G,
  h: H,
  i: I,
  j: J,
  k: K,
  l: L,
  m: M,
  n: N,
  o: O,
  p: P,
  q: Q,
  r: R,
  s: S,
  t: T,
  u: U
)(implicit
  i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M],
    i18nN: I18N[N],
    i18nO: I18N[O],
    i18nP: I18N[P],
    i18nQ: I18N[Q],
    i18nR: I18N[R],
    i18nS: I18N[S],
    i18nT: I18N[T],
    i18nU: I18N[U]
) extends BoundMessage {
  override def apply()(implicit cfg:I18NConfig) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h),
      i18nI(i),
      i18nJ(j),
      i18nK(k),
      i18nL(l),
      i18nM(m),
      i18nN(n),
      i18nO(o),
      i18nP(p),
      i18nQ(q),
      i18nR(r),
      i18nS(s),
      i18nT(t),
      i18nU(u)
    )
}

case class Message21[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U](key: Symbol) extends Message {
  def apply(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H,i:I,j:J,k:K,l:L,m:M,n:N,o:O,p:P,q:Q,r:R,s:S,t:T,u:U)(implicit
    cfg: I18NConfig,
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M],
    i18nN: I18N[N],
    i18nO: I18N[O],
    i18nP: I18N[P],
    i18nQ: I18N[Q],
    i18nR: I18N[R],
    i18nS: I18N[S],
    i18nT: I18N[T],
    i18nU: I18N[U]
  ) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h),
      i18nI(i),
      i18nJ(j),
      i18nK(k),
      i18nL(l),
      i18nM(m),
      i18nN(n),
      i18nO(o),
      i18nP(p),
      i18nQ(q),
      i18nR(r),
      i18nS(s),
      i18nT(t),
      i18nU(u)
    )
  def bind(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H,i:I,j:J,k:K,l:L,m:M,n:N,o:O,p:P,q:Q,r:R,s:S,t:T,u:U)(implicit
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M],
    i18nN: I18N[N],
    i18nO: I18N[O],
    i18nP: I18N[P],
    i18nQ: I18N[Q],
    i18nR: I18N[R],
    i18nS: I18N[S],
    i18nT: I18N[T],
    i18nU: I18N[U]
  ) : BoundMessage21[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U] = BoundMessage21(key,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u)
}


case class BoundMessage22[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V](
  key: Symbol,
  a: A,
  b: B,
  c: C,
  d: D,
  e: E,
  f: F,
  g: G,
  h: H,
  i: I,
  j: J,
  k: K,
  l: L,
  m: M,
  n: N,
  o: O,
  p: P,
  q: Q,
  r: R,
  s: S,
  t: T,
  u: U,
  v: V
)(implicit
  i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M],
    i18nN: I18N[N],
    i18nO: I18N[O],
    i18nP: I18N[P],
    i18nQ: I18N[Q],
    i18nR: I18N[R],
    i18nS: I18N[S],
    i18nT: I18N[T],
    i18nU: I18N[U],
    i18nV: I18N[V]
) extends BoundMessage {
  override def apply()(implicit cfg:I18NConfig) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h),
      i18nI(i),
      i18nJ(j),
      i18nK(k),
      i18nL(l),
      i18nM(m),
      i18nN(n),
      i18nO(o),
      i18nP(p),
      i18nQ(q),
      i18nR(r),
      i18nS(s),
      i18nT(t),
      i18nU(u),
      i18nV(v)
    )
}

case class Message22[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V](key: Symbol) extends Message {
  def apply(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H,i:I,j:J,k:K,l:L,m:M,n:N,o:O,p:P,q:Q,r:R,s:S,t:T,u:U,v:V)(implicit
    cfg: I18NConfig,
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M],
    i18nN: I18N[N],
    i18nO: I18N[O],
    i18nP: I18N[P],
    i18nQ: I18N[Q],
    i18nR: I18N[R],
    i18nS: I18N[S],
    i18nT: I18N[T],
    i18nU: I18N[U],
    i18nV: I18N[V]
  ) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a),
      i18nB(b),
      i18nC(c),
      i18nD(d),
      i18nE(e),
      i18nF(f),
      i18nG(g),
      i18nH(h),
      i18nI(i),
      i18nJ(j),
      i18nK(k),
      i18nL(l),
      i18nM(m),
      i18nN(n),
      i18nO(o),
      i18nP(p),
      i18nQ(q),
      i18nR(r),
      i18nS(s),
      i18nT(t),
      i18nU(u),
      i18nV(v)
    )
  def bind(a:A,b:B,c:C,d:D,e:E,f:F,g:G,h:H,i:I,j:J,k:K,l:L,m:M,n:N,o:O,p:P,q:Q,r:R,s:S,t:T,u:U,v:V)(implicit
    i18nA: I18N[A],
    i18nB: I18N[B],
    i18nC: I18N[C],
    i18nD: I18N[D],
    i18nE: I18N[E],
    i18nF: I18N[F],
    i18nG: I18N[G],
    i18nH: I18N[H],
    i18nI: I18N[I],
    i18nJ: I18N[J],
    i18nK: I18N[K],
    i18nL: I18N[L],
    i18nM: I18N[M],
    i18nN: I18N[N],
    i18nO: I18N[O],
    i18nP: I18N[P],
    i18nQ: I18N[Q],
    i18nR: I18N[R],
    i18nS: I18N[S],
    i18nT: I18N[T],
    i18nU: I18N[U],
    i18nV: I18N[V]
  ) : BoundMessage22[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V] = BoundMessage22(key,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v)
}


