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


case class Message1[A](key: Symbol) extends Message {
  def apply(a:A)(implicit
    cfg: I18NConfig,
    i18nA: I18N[A]
  ) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      i18nA(a)
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
}


