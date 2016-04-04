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

import org.scalatest.{Matchers, FlatSpec}
import s_mach.i18n.Messages
import CommonTest._
class DefaultMessagesTest extends FlatSpec with Matchers {
  "Messages.empty" should "be empty" in {
    Messages.empty.keys.isEmpty should be(true)
  }

  "DefaultMessages.keys" should "return all keys" in {
    val m = mkMessages(Locale.US)
    m.keys should equal(Set(
      m_hello.key,
      m_hello_name_qty.key,
      m_there_are_qty_apples.key
    ))
  }

  "DefaultMessages.contains" should "return true if a key is present false otherwise" in {
    val m = mkMessages(Locale.US)
    m.contains(m_hello.key) should equal(true)
    m.contains(m_hello_name_qty.key) should equal(true)
    m.contains(m_there_are_qty_apples.key) should equal(true)
    m.contains("missing") should equal(false)
  }
}
