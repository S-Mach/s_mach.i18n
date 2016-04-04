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

import org.scalatest.{Matchers, FlatSpec}
import s_mach.i18n._
import s_mach.i18n.Interpolation.{Arg, Literal}

class InterpolatorTest extends FlatSpec with Matchers {
  implicit val m = Messages()

  val parts1 = List(
    Literal("hello "),
    Arg(0),
    Literal(" test "),
    Arg(1),
    Literal(" {2}")
  )

  val parts2 = List(
    Literal("When "),
    Arg(1),
    Literal(" on "),
    Arg(1),
    Literal(", there will be "),
    Arg(2),
    Literal(" on moon "),
    Arg(0)
  )

  "Interpolator.strict.interpolate" should "assemble literals and replace in order arguments correctly" in {
    Interpolator.strict.interpolate(parts1,"1".i18n,"2".i18n) should equal("hello 1 test 2 {2}")
  }

  "Interpolator.strict.interpolate" should "assemble literals and replace repeated or out of order arguments correctly" in {
    Interpolator.strict.interpolate(parts2,"1".i18n,"2".i18n,"3".i18n) should equal("When 2 on 2, there will be 3 on moon 1")
  }

  "Interpolator.strict.interpolate" should "throw if too many arguments are passed" in {
    an[IllegalArgumentException] should be thrownBy Interpolator.strict.interpolate(parts1,"1".i18n,"2".i18n,"3".i18n)
  }

  "Interpolator.strict.interpolate" should "throw if an argument is missing" in {
    an[IllegalArgumentException] should be thrownBy Interpolator.strict.interpolate(parts1,"1".i18n)
  }

  "Interpolator.strict.interpolate" should "throw if key is missing" in {
    an[NoSuchElementException] should be thrownBy Interpolator.strict.interpolate("test","1".i18n)
  }

  "Interpolator.tolerant.interpolate" should "ignore extra arguments" in {
    Interpolator.tolerant.interpolate(parts1,"1".i18n,"2".i18n,"3".i18n) should equal("hello 1 test 2 {2}")
  }

  "Interpolator.tolerant.interpolate" should "replace missing arguments with '(null)'" in {
    Interpolator.tolerant.interpolate(parts1,"1".i18n) should equal("hello 1 test (null) {2}")
  }

  "Interpolator.tolerant.interpolate" should "show key and args for missing keys" in {
    Interpolator.tolerant.interpolate("test","1".i18n,"2".i18n) should equal("{test}(1,2)")
  }
}
