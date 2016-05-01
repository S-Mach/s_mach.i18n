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
import s_mach.i18n.messages._
import MessageFormat._

class OrElseMessagesTest extends FlatSpec with Matchers {
  "Messages.orElse" should "fall back to second Messages if not present in first" in {
    val m1 = Messages(
      Locale.US,
      'key1 -> Literal("test1")
    )
    val m2 = Messages(
      Locale.US,
      'key2 -> Literal("test2")
    )
    val m3 = m1 orElse m2

    m3.get('key1) should equal(Some(Literal("test1")))
    m3.get('key2) should equal(Some(Literal("test2")))
    m3.get('key3) should equal(None)
  }
  "Messages.orElse" should "should contain keys from both messages" in {
    val m1 = Messages(
      Locale.US,
      'key1 -> Literal("test1")
    )
    val m2 = Messages(
      Locale.US,
      'key2 -> Literal("test2")
    )
    val m3 = m1 orElse m2

    m3.keys should contain theSameElementsAs Iterable('key1,'key2)
  }

  "Messages.orElse" should "throw an exception if locales do not match" in {
    val m1 = Messages(
      Locale.US,
      'key1 -> Literal("test1")
    )
    val m2 = Messages(
      Locale.FRANCE,
      'key2 -> Literal("test2")
    )
    an[IllegalArgumentException] should be thrownBy (m1 orElse m2)
  }
}
