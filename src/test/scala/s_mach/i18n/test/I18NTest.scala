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

class I18NTest extends FlatSpec with Matchers {
  import s_mach.i18n.default.Implicits.StringContextPML_hHQiIbEzQp

  // equivalent
//  val m_hello = Message0("hello.message")
  val m_hello = m0"hello.message"

  // equivalent
//  val m_hello_$name_$qty = Message2[I18NString,Double]("hello_$name_$qty")
  val m_hello_$name_$qty = m"hello_name_qty"[I18NString,Double]

  implicit def message(implicit l:Locale) : Messages = {
    import s_mach.i18n.default.Implicits._

    l match {
      case l if l == Locale.US =>
        Messages(
          m_hello -> "hello",
          m_hello_$name_$qty -> { (a,b) => sc"hello $a test $b" }
        )
      case l if l == Locale.FRENCH =>
        Messages(
          m_hello -> "bonjour",
          m_hello_$name_$qty -> { (a,b) => sc"bonjour $a test $b" }
        )
    }
  }

  val name = "Lance"
  val qty = 10000.1

  "i(String) for EN US" should "internationalize arguments correctly using JVM default locale (EN_US)" in {
    import s_mach.i18n.default._

    m_hello() should equal("hello")
    m_hello_$name_$qty(name.i18n,qty) should equal("hello Lance test 10,000.1")
  }

  "i(String) for FR" should "internationalize arguments correctly for custom locale" in {
    import s_mach.i18n.default.Implicits._
    implicit val locale = Locale.FRENCH

    m_hello() should equal("bonjour")
    // Note: not a space between '10' and '000' below
    m_hello_$name_$qty(name.i18n,qty) should equal("bonjour Lance test 10 000,1")
  }

}
