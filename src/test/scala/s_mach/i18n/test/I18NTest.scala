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
//  val m_hello_name_qty = Message2[I18NString,Double]("hello_name_qty")
  val m_hello_name_qty = m"hello_name_qty"[I18NString,Double]

  val m_there_are_qty_apples = Quantity("there_are_qty_apples")

  implicit def message(implicit l:Locale) : Messages = {
    import s_mach.i18n.default.Implicits._

    l match {
      case l if l == Locale.US =>
        Messages(
          m_hello -> "hello",
          m_hello_name_qty -> { (a,b) => sc"hello $a test $b" }
        )
      case l if l == Locale.FRENCH =>
        Messages(
          m_hello -> "bonjour",
          m_hello_name_qty -> { (a,b) => sc"bonjour $a test $b" }
        )
    }
  }

  implicit def choices(implicit l:Locale) : Choices = {
    l match {
      case l if l == Locale.US =>
        Choices(
          m_there_are_qty_apples.key -> { n: BigDecimal => I18NString(
            s"There ${
              n match {
                case v if v == BigDecimal(0) =>
                  "are no apples"
                case v if v == BigDecimal(1) =>
                  "is one apple"
                case v =>
                  s"are $v apples"
              }
            }"
          )
          }
        )
      case l if l == Locale.FRENCH =>
        Choices(
          m_there_are_qty_apples.key -> { n: BigDecimal => I18NString(
            s"Il ${
              n match {
                case v if v == BigDecimal(0) =>
                  "n'y a pas de pommes"
                case v if v == BigDecimal(1) =>
                  "y a une pomme"
                case v =>
                  s"y a $v pommes"
              }
            }"
          )
          }
        )
    }
  }
  
  val name = "Lance"
  val qty = 10000.1

  "i(String) for EN US" should "internationalize arguments correctly using JVM default locale (EN_US)" in {
    import s_mach.i18n.default._

    m_hello() should equal("hello")
    m_hello_name_qty(name.toI18N,qty) should equal("hello Lance test 10,000.1")

    m_there_are_qty_apples(0) should equal("There are no apples")
    m_there_are_qty_apples(1) should equal("There is one apple")
    m_there_are_qty_apples(2) should equal("There are 2 apples")

    m_hello_name_qty(m_there_are_qty_apples(2),qty) should equal("hello There are 2 apples test 10,000.1")
  }

  "i(String) for FR" should "internationalize arguments correctly for custom locale" in {
    import s_mach.i18n.default.Implicits._
    implicit val locale = Locale.FRENCH

    m_hello() should equal("bonjour")
    // Note: not a space between '10' and '000' below
    m_hello_name_qty(name.toI18N,qty) should equal("bonjour Lance test 10 000,1")

    m_there_are_qty_apples(0) should equal("Il n'y a pas de pommes")
    m_there_are_qty_apples(1) should equal("Il y a une pomme")
    m_there_are_qty_apples(2) should equal("Il y a 2 pommes")

    m_hello_name_qty(m_there_are_qty_apples(2),qty) should equal("bonjour Il y a 2 pommes test 10 000,1")
  }

}
