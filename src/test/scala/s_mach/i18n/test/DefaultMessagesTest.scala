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

import java.util.{NoSuchElementException, Locale}

import org.scalatest.{Matchers, FlatSpec}
import CommonTest._

class DefaultMessagesTest extends FlatSpec with Matchers {
  
  "DefaultMessages.keys" should "return all keys" in {
    val m = mkTestMessages(Locale.US)
    m.keys should equal(Set(
      m_hello.key,
      m_hello_name_qty.key,
      m_there_are_qty_apples.key
    ))
  }

  "DefaultMessages.contains" should "return true if a key is present false otherwise" in {
    val m = mkTestMessages(Locale.US)
    m.contains(m_hello.key) should equal(true)
    m.contains(m_hello_name_qty.key) should equal(true)
    m.contains(m_there_are_qty_apples.key) should equal(true)
    m.contains("missing") should equal(false)
  }

  "DefaultMessages.literals.get" should "return Some(value) for a key and None for a missing key" in {
    val m = mkTestMessages(Locale.US)
    m.literals.get(m_hello.key) should equal(Some("hello"))
    m.literals.get("missing") should equal(None)
  }

  "DefaultMessages.literals.apply" should "return the value associated with a key and throw an exception if key is missing" in {
    val m = mkTestMessages(Locale.US)
    m.literals(m_hello.key) should equal(m_hello_us_value)
    an[NoSuchElementException] should be thrownBy m.literals("missing")
  }

  "DefaultMessages.interpolations.get" should "return Some(value) for a key and None for a missing key" in {
    val m = mkTestMessages(Locale.US)
    m.interpolations.get(m_hello_name_qty.key) should equal(Some(m_hello_name_qty_us_value))
    m.interpolations.get("missing") should equal(None)
  }

  "DefaultMessages.interpolations.apply" should "return the value associated with a key and throw an exception if key is missing" in {
    val m = mkTestMessages(Locale.US)
    m.interpolations(m_hello_name_qty.key) should equal(m_hello_name_qty_us_value)
    an[NoSuchElementException] should be thrownBy m.interpolations("missing")
  }

  "DefaultMessages.choices.get" should "return Some(value) for a key and None for a missing key" in {
    val m = mkTestMessages(Locale.US)
    m.choices.get(m_there_are_qty_apples.key) should equal(Some(m_there_are_qty_apples_us_value))
    m.choices.get("missing") should equal(None)
  }

  "DefaultMessages.choices.apply" should "return the value associated with a key and throw an exception if key is missing" in {
    val m = mkTestMessages(Locale.US)
    m.choices(m_there_are_qty_apples.key) should equal(m_there_are_qty_apples_us_value)
    an[NoSuchElementException] should be thrownBy m.choices("missing")
  }
}
