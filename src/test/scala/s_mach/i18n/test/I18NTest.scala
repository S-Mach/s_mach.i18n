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
import CommonTest._

class I18NTest extends FlatSpec with Matchers {

  val name = "Lance"
  val qty = 10000.1

  "Messages for EN US" should "internationalize arguments correctly using JVM default locale (EN_US)" in {
    // import this unused import to ensure no implicit shadow conflicts
    import s_mach.i18n._
    implicit val locale = Locale.US

    m_hello() should equal("hello")
    m_hello_name_qty(name.i18n,qty) should equal("hello Lance test 10,000.1")

    m_there_are_qty_apples(0) should equal("There are no apples")
    m_there_are_qty_apples(1) should equal("There is one apple")
    m_there_are_qty_apples(2) should equal("There are 2 apples")

    m_hello_name_qty(m_there_are_qty_apples(2),qty) should equal("hello There are 2 apples test 10,000.1")

    i18n"${m_there_are_qty_apples(0)} test $qty ${name.i18n}" should equal("There are no apples test 10,000.1 Lance")
  }

  "Messages for FR" should "internationalize arguments correctly for custom locale" in {
    // import this unused import to ensure no implicit shadow conflicts
    import s_mach.i18n._
    implicit val locale = Locale.FRENCH

    m_hello() should equal("bonjour")
    // Note: not a space between '10' and '000' below
    m_hello_name_qty(name.i18n,qty) should equal("bonjour Lance test 10 000,1")

    m_there_are_qty_apples(0) should equal("Il n'y a pas de pommes")
    m_there_are_qty_apples(1) should equal("Il y a une pomme")
    m_there_are_qty_apples(2) should equal("Il y a 2 pommes")

    m_hello_name_qty(m_there_are_qty_apples(2),qty) should equal("bonjour Il y a 2 pommes test 10 000,1")

    i18n"${m_there_are_qty_apples(0)} test $qty ${name.i18n}" should equal("Il n'y a pas de pommes test 10 000,1 Lance")
  }

}
