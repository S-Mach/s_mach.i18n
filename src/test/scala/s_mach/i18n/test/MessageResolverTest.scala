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

  "MessageResolver.strict.resolveInterpolation" should "throw if key is missing" in {
    an[NoSuchElementException] should be thrownBy MessageResolver.strict.resolveInterpolation(
      'test,
      "1".asI18N
    )
  }

  "MessageResolver.strict.resolveLiteral" should "throw if key is missing" in {
    an[NoSuchElementException] should be thrownBy MessageResolver.strict.resolveLiteral(
      'test
    )
  }

  "MessageResolver.strict.resolveChoice" should "throw if key is missing" in {
    an[NoSuchElementException] should be thrownBy MessageResolver.strict.resolveChoice(
      'test,
      BigDecimal("1")
    )
  }

  "MessageResolver.strict.toString" should "return StrictMessageResolver" in {
    MessageResolver.strict.toString should equal("StrictMessageResolver")
  }

  "MessageResolver.lax.resolveInterpolation" should "show key and args for missing keys" in {
    MessageResolver.lax.resolveInterpolation(
      'test,
       "1".asI18N,
      "2".asI18N
    ) should equal("{test:missing}(1,2)")
  }

  "MessageResolver.lax.resolveLiteral" should "show key and args for missing keys" in {
    MessageResolver.lax.resolveLiteral(
      'test
    ) should equal("{test:missing}")
  }

  "MessageResolver.lax.resolveChoice" should "show key and args for missing keys" in {
    MessageResolver.lax.resolveChoice(
      'test,
      BigDecimal("1")
    ) should equal("{test:missing}(1)")
  }

  "MessageResolver.lax.toString" should "return LaxMessageResolver" in {
    MessageResolver.lax.toString should equal("LaxMessageResolver")
  }

}
