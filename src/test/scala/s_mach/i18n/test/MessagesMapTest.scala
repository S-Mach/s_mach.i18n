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

import java.util.{Locale, NoSuchElementException}

import org.scalatest.{FlatSpec, Matchers}
import s_mach.i18n._
import CommonTest._
import s_mach.i18n.messages.MessageFormat

class MessagesMapTest extends FlatSpec with Matchers {
  
  "MessagesMap.keys" should "return all keys" in {
    val m = mkTestMessages(Locale.ENGLISH)
    m.keys should equal(Set(
      m_hello.key,
      m_hello_name_qty.key,
      m_there_are_qty_apples.key
    ))
  }

  "MessagesMap.contains" should "return true if a key is present false otherwise" in {
    val m = mkTestMessages(Locale.ENGLISH)
    m.contains(m_hello.key) should equal(true)
    m.contains(m_hello_name_qty.key) should equal(true)
    m.contains(m_there_are_qty_apples.key) should equal(true)
    m.contains('missing) should equal(false)
  }

  "MessagesMap.literals.get" should "return Some(value) for a key and None for a missing key" in {
    val m = mkTestMessages(Locale.ENGLISH)
    m.get(m_hello.key) should equal(Some(MessageFormat.Literal("hello")))
    m.get('missing) should equal(None)
  }

  "MessagesMap.literals.apply" should "return the value associated with a key and throw an exception if key is missing" in {
    val m = mkTestMessages(Locale.ENGLISH)
    m(m_hello.key) should equal(m_hello_us_value)
    an[NoSuchElementException] should be thrownBy m('missing)
  }

  "MessagesMap.interpolations.get" should "return Some(value) for a key and None for a missing key" in {
    val m = mkTestMessages(Locale.ENGLISH)
    m.get(m_hello_name_qty.key) should equal(Some(m_hello_name_qty_us_value))
    m.get('missing) should equal(None)
  }

  "MessagesMap.interpolations.apply" should "return the value associated with a key and throw an exception if key is missing" in {
    val m = mkTestMessages(Locale.ENGLISH)
    m(m_hello_name_qty.key) should equal(m_hello_name_qty_us_value)
    an[NoSuchElementException] should be thrownBy m('missing)
  }

  "MessagesMap.choices.get" should "return Some(value) for a key and None for a missing key" in {
    val m = mkTestMessages(Locale.ENGLISH)
    m.get(m_there_are_qty_apples.key) should equal(Some(m_there_are_qty_apples_us_value))
    m.get('missing) should equal(None)
  }

  "MessagesMap.choices.apply" should "return the value associated with a key and throw an exception if key is missing" in {
    val m = mkTestMessages(Locale.ENGLISH)
    m(m_there_are_qty_apples.key) should equal(m_there_are_qty_apples_us_value)
    an[NoSuchElementException] should be thrownBy m('missing)
  }

  "MessagesMap.choices.applyOrElse" should "return the value associated with a key or call default if key is missing" in {
    val m = mkTestMessages(Locale.ENGLISH)
    val defaultFmt = MessageFormat.Literal("default")
    m.applyOrElse(m_there_are_qty_apples.key,_ => defaultFmt) should equal(m_there_are_qty_apples_us_value)
    m.applyOrElse('missing,_ => defaultFmt) should equal(defaultFmt)
  }

  "MessagesMap.toString" should "return number of keys" in {
    val m = mkTestMessages(Locale.ENGLISH)
    m.toString should equal(s"Messages(keys.size=3)")
  }
}
