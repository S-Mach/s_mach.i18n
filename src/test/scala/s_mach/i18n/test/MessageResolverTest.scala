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
package s_mach.i18n.test

import java.util.Locale

import org.scalatest.{FlatSpec, Matchers}
import s_mach.i18n._
import s_mach.i18n.messages._

class MessageResolverTest extends FlatSpec with Matchers {
  implicit val cfg = I18NConfig(Messages(Locale.ENGLISH))

  "MessageResolver.strict.interpolate" should "throw if key is missing" in {
    an[NoSuchElementException] should be thrownBy MessageResolver.strict.resolveInterpolation(
      'test,
      "1".asI18N
    )
  }

  "MessageResolver.lax.interpolate" should "show key and args for missing keys" in {
    MessageResolver.lax.resolveInterpolation(
      'test,
       "1".asI18N,
      "2".asI18N
    ) should equal("{test:null}(1,2)")
  }
}
