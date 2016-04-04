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
import s_mach.i18n._
import Interpolation._

object CommonTest {
  val m_hello = {
    import s_mach.i18n._

    // equivalent
    // Message0("hello.message")
    "hello.message".m0
  }

  // equivalent
  val m_hello_name_qty = {
    import s_mach.i18n._

    // equivalent
    // Message2[I18NString,Double]("hello_name_qty")
    "hello_name_qty".m[I18NString,Double]
  }

  val m_there_are_qty_apples = {
    import s_mach.i18n._

    // equivalent
    // Quantity("there_are_qty_apples")
    "there_are_qty_apples".choice
  }

  val m_hello_us_value = "hello"
  val m_hello_name_qty_us_value = Literal("hello ") :: Arg(0) :: Literal(" test ") :: Arg(1) :: Nil
  val m_there_are_qty_apples_us_value = { n: BigDecimal => I18NString(
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
  )}
  
  def mkTestMessages()(implicit l:Locale) = {
    import s_mach.i18n._
    import Interpolation._

    l match {
      case l if l == Locale.US =>
        Messages(
          literals = Map(
            m_hello.key -> m_hello_us_value
          ),
          interpolations = Map(
            m_hello_name_qty.key -> m_hello_name_qty_us_value
          ),
          choices = Map(
            m_there_are_qty_apples.key -> m_there_are_qty_apples_us_value
          )
        )
      case l if l == Locale.FRENCH =>
        Messages(
          literals = Map(
            m_hello.key -> "bonjour"
          ),
          interpolations = Map(
            m_hello_name_qty.key -> (Literal("bonjour ") :: Arg(0) :: Literal(" test ") :: Arg(1) :: Nil)
          ),
          choices = Map(
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
        )
    }
  }
}
