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
import CommonTest._
import s_mach.i18n.messages.MessageLiteral

class MessageTest extends FlatSpec with Matchers {
  val name = "Gary"
  val qty = 10000.1


  "MessageLiteral.apply" should "retrieve the message from Messages for the current locale" in {
    {
      implicit val cfg = I18NConfig(mkTestMessages(Locale.ENGLISH))
      m_hello() should equal("hello")
    }
    {
      implicit val cfg = I18NConfig(mkTestMessages(Locale.FRENCH))
      m_hello() should equal("bonjour")
    }
  }

  "Message1.apply" should "retrieve the message from I18NConfig and interpolate arguments" in {
    {
      implicit val cfg = I18NConfig(mkTestMessages(Locale.ENGLISH))
      m_hello_name_qty(name.asI18N,qty) should equal("hello Gary test 10,000.1")
    }
    {
      implicit val cfg = I18NConfig(mkTestMessages(Locale.FRENCH))
      m_hello_name_qty(name.asI18N,qty) should equal("bonjour Gary test 10 000,1")
    }
  }

  "Message2.apply" should "retrieve the message from I18NConfig and interpolate arguments" in {
    {
      implicit val cfg = I18NConfig(mkTestMessages(Locale.ENGLISH))
      m_hello_name_qty("There are 2 apples".asI18N,qty) should equal("hello There are 2 apples test 10,000.1")
    }
    {
      implicit val cfg = I18NConfig(mkTestMessages(Locale.FRENCH))
      m_hello_name_qty("Il y a 2 pommes".asI18N,qty) should equal("bonjour Il y a 2 pommes test 10 000,1")
    }
  }

  "Choice.apply" should "retrieve the message from I18NConfig and choose the correct message" in {
    {
      implicit val cfg = I18NConfig(mkTestMessages(Locale.ENGLISH))
      m_there_are_qty_apples(0) should equal("There are no apples")
      m_there_are_qty_apples(1) should equal("There is one apple")
      m_there_are_qty_apples(2) should equal("There are 2 apples")
    }
    {
      implicit val cfg = I18NConfig(mkTestMessages(Locale.FRENCH))
      m_there_are_qty_apples(0) should equal("Il n'y a pas de pommes")
      m_there_are_qty_apples(1) should equal("Il y a une pomme")
      m_there_are_qty_apples(2) should equal("Il y a 2 pommes")
    }
  }

  "Message.throwIfMissing" should "throw an exception if key is missing other do nothing if key exists" in {
    implicit val cfg = I18NConfig(mkTestMessages(Locale.ENGLISH))
    an [NoSuchElementException] should be thrownBy MessageLiteral('m_missing_key).throwIfMissing()
    m_hello.throwIfMissing()
  }

  "Message sugar" should "create messages as expected" in {
    import s_mach.i18n.messages._
    "abc".literal should equal(MessageLiteral('abc))
    "abc".m0 should equal(MessageLiteral('abc))
    "abc".choice should equal(MessageChoice('abc))
    'abc.literal should equal(MessageLiteral('abc))
    'abc.m0 should equal(MessageLiteral('abc))
    'abc.choice should equal(MessageChoice('abc))
  }
}
