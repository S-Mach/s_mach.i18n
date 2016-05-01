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
import s_mach.i18n.messages._

/* WARNING: Generated code. To modify see s_mach.i18n.codegen.MessageNTestCodeGen */

class MessageNTest extends FlatSpec with Matchers {
  implicit val i18ncfg = I18NConfig(Locale.ENGLISH)


  "Message1.apply" should "resolve interpolation" in {
    val m_test1 = 'm_test1.m[Int]
    m_test1(1) should equal ("test 1")
  }


  "Message2.apply" should "resolve interpolation" in {
    val m_test2 = 'm_test2.m[Int,Int]
    m_test2(1,2) should equal ("test 1 2")
  }


  "Message3.apply" should "resolve interpolation" in {
    val m_test3 = 'm_test3.m[Int,Int,Int]
    m_test3(1,2,3) should equal ("test 1 2 3")
  }


  "Message4.apply" should "resolve interpolation" in {
    val m_test4 = 'm_test4.m[Int,Int,Int,Int]
    m_test4(1,2,3,4) should equal ("test 1 2 3 4")
  }


  "Message5.apply" should "resolve interpolation" in {
    val m_test5 = 'm_test5.m[Int,Int,Int,Int,Int]
    m_test5(1,2,3,4,5) should equal ("test 1 2 3 4 5")
  }


  "Message6.apply" should "resolve interpolation" in {
    val m_test6 = 'm_test6.m[Int,Int,Int,Int,Int,Int]
    m_test6(1,2,3,4,5,6) should equal ("test 1 2 3 4 5 6")
  }


  "Message7.apply" should "resolve interpolation" in {
    val m_test7 = 'm_test7.m[Int,Int,Int,Int,Int,Int,Int]
    m_test7(1,2,3,4,5,6,7) should equal ("test 1 2 3 4 5 6 7")
  }


  "Message8.apply" should "resolve interpolation" in {
    val m_test8 = 'm_test8.m[Int,Int,Int,Int,Int,Int,Int,Int]
    m_test8(1,2,3,4,5,6,7,8) should equal ("test 1 2 3 4 5 6 7 8")
  }


  "Message9.apply" should "resolve interpolation" in {
    val m_test9 = 'm_test9.m[Int,Int,Int,Int,Int,Int,Int,Int,Int]
    m_test9(1,2,3,4,5,6,7,8,9) should equal ("test 1 2 3 4 5 6 7 8 9")
  }


  "Message10.apply" should "resolve interpolation" in {
    val m_test10 = 'm_test10.m[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int]
    m_test10(1,2,3,4,5,6,7,8,9,10) should equal ("test 1 2 3 4 5 6 7 8 9 10")
  }


  "Message11.apply" should "resolve interpolation" in {
    val m_test11 = 'm_test11.m[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int]
    m_test11(1,2,3,4,5,6,7,8,9,10,11) should equal ("test 1 2 3 4 5 6 7 8 9 10 11")
  }


  "Message12.apply" should "resolve interpolation" in {
    val m_test12 = 'm_test12.m[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int]
    m_test12(1,2,3,4,5,6,7,8,9,10,11,12) should equal ("test 1 2 3 4 5 6 7 8 9 10 11 12")
  }


  "Message13.apply" should "resolve interpolation" in {
    val m_test13 = 'm_test13.m[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int]
    m_test13(1,2,3,4,5,6,7,8,9,10,11,12,13) should equal ("test 1 2 3 4 5 6 7 8 9 10 11 12 13")
  }


  "Message14.apply" should "resolve interpolation" in {
    val m_test14 = 'm_test14.m[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int]
    m_test14(1,2,3,4,5,6,7,8,9,10,11,12,13,14) should equal ("test 1 2 3 4 5 6 7 8 9 10 11 12 13 14")
  }


  "Message15.apply" should "resolve interpolation" in {
    val m_test15 = 'm_test15.m[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int]
    m_test15(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15) should equal ("test 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15")
  }


  "Message16.apply" should "resolve interpolation" in {
    val m_test16 = 'm_test16.m[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int]
    m_test16(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16) should equal ("test 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16")
  }


  "Message17.apply" should "resolve interpolation" in {
    val m_test17 = 'm_test17.m[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int]
    m_test17(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17) should equal ("test 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17")
  }


  "Message18.apply" should "resolve interpolation" in {
    val m_test18 = 'm_test18.m[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int]
    m_test18(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18) should equal ("test 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18")
  }


  "Message19.apply" should "resolve interpolation" in {
    val m_test19 = 'm_test19.m[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int]
    m_test19(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19) should equal ("test 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19")
  }


  "Message20.apply" should "resolve interpolation" in {
    val m_test20 = 'm_test20.m[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int]
    m_test20(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20) should equal ("test 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20")
  }


  "Message21.apply" should "resolve interpolation" in {
    val m_test21 = 'm_test21.m[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int]
    m_test21(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21) should equal ("test 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21")
  }


  "Message22.apply" should "resolve interpolation" in {
    val m_test22 = 'm_test22.m[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int]
    m_test22(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22) should equal ("test 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22")
  }

}

