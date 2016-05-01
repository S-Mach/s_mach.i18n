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
package s_mach.i18n.example

object ExampleUsageFR {

  import java.util.Locale
  import s_mach.i18n._
  import s_mach.i18n.messages._

  // Uses UTF8Messages by default
  implicit val i18ncfg = I18NConfig(Locale.FRENCH)

  // Create a message with the key m_test that accepts 2 arguments, an Int and an I18NString
  val m_test : Message2[Int,I18NString] = 'm_test.m[Int,I18NString]

  // Using i18ncfg, resolve the message key to a message format and interpolate the arguments
  // Note: the Int argument is automatically converted to I18NString by invoking the
  // I18N[Int] type-class
  val test_message_lookup : I18NString = m_test(100000,"test".asI18N)

  // Note: the Double argument is automatically converted to I18NString by invoking the
  // I18N[Double] type-class
  val test_i18n_str : I18NString = i18n"nous allons interpoler certains arguments $test_message_lookup ${10000.999}"

}
