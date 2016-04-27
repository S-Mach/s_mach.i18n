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
import I18NFormat._
import s_mach.i18n.messages.{I18NFormat, _}

class UTF8MessagesTest extends FlatSpec with Matchers {
  "UTF8Messages" should "read messages from default resource files when no locale specific file is present" in {
    val messages = UTF8Messages(Locale.US)
    messages('m_true) should equal(Literal("true"))
    messages('m_false) should equal(Literal("false"))
    // extra key found in extra messages.txt (UTF8Messages should concat same named files)
    messages('test_key) should equal(Literal("testvalue"))
  }

  "UTF8Messages" should "concat same named message files located in different jars" in {
    val messages = UTF8Messages(Locale.US)
    messages('m_true) should equal(Literal("true"))
    // extra key found in test messages.txt (UTF8Messages should concat same named files)
    messages('test_key) should equal(Literal("testvalue"))
  }

  "UTF8Messages" should "replace messages in base messages file with locale specific file" in {
    // should replace messages read from messages.txt with those in messages_fr.txt
    val messages = UTF8Messages(Locale.FRENCH)
    messages('m_true) should equal(Literal("vrai"))
    messages('m_false) should equal(Literal("faux"))
  }

  "UTF8Messages" should "still concat same named message files located in different jars when using a specific locale" in {
    val messages = UTF8Messages(Locale.FRENCH)
    // extra key found in extra messages.txt (UTF8Messages should concat same named files)
    messages('test_key) should equal(Literal("testvalue"))
  }

  "UTF8Messages" should "parse message value into parts based on MessageFormat format" in {
    val messages = UTF8Messages(Locale.US)

    messages('fmt_test1_key) should equal {
      import Interpolation.Part._
      Interpolation(List(
        Literal("hello "),
        StringArg(0),
        Literal(" test "),
        StringArg(1),
        Literal(" {2}")
      ))
    }
  }

  "UTF8Messages" should "ignore any kind of specialized formatting in message value MessageFormat and just return parts" in {
    val messages = UTF8Messages(Locale.US)
    messages('fmt_test2_key) should equal {
      import Interpolation.Part._
      Interpolation(List(
        Literal("When "),
        StringArg(1),
        Literal(" on "),
        StringArg(1),
        Literal(", there will be "),
        StringArg(2),
        Literal(" on moon "),
        StringArg(0)
      ))
    }
  }

  "UTF8Messages" should "parse choices and format them correctly for default" in {
    val messages = UTF8Messages(Locale.US)
    messages('fmt_choice_key).asInstanceOf[Choice].value(0) should equal("There are no apples.")
    messages('fmt_choice_key).asInstanceOf[Choice].value(1) should equal("There is one apple.")
    messages('fmt_choice_key).asInstanceOf[Choice].value(2) should equal("There are 2 apples.")
  }

  "UTF8Messages" should "parse choices and format them correctly for FR" in {
    val messages = UTF8Messages(Locale.FRENCH)
    messages('fmt_choice_key).asInstanceOf[Choice].value(0) should equal("Il n'y a pas de pommes.")
    messages('fmt_choice_key).asInstanceOf[Choice].value(1) should equal("Il y a une pomme.")
    messages('fmt_choice_key).asInstanceOf[Choice].value(2) should equal("Il y a 2 pommes.")
  }

}
