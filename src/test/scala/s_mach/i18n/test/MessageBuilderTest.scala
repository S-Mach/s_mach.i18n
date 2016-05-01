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

import org.scalatest.{FlatSpec, Matchers}
import s_mach.i18n.messages._

/* WARNING: Generated code. To modify see s_mach.i18n.codegen.MessageBuilderCodeGen */
class MessageBuilderTest extends FlatSpec with Matchers {

  "MessageBuilder.apply[Vector(A)]" should "properly create a Message1" in {
    MessageBuilder('test).apply[Int] should equal(Message1[Int]('test))
  }


  "MessageBuilder.apply[Vector(A, B)]" should "properly create a Message2" in {
    MessageBuilder('test).apply[Int,Int] should equal(Message2[Int,Int]('test))
  }


  "MessageBuilder.apply[Vector(A, B, C)]" should "properly create a Message3" in {
    MessageBuilder('test).apply[Int,Int,Int] should equal(Message3[Int,Int,Int]('test))
  }


  "MessageBuilder.apply[Vector(A, B, C, D)]" should "properly create a Message4" in {
    MessageBuilder('test).apply[Int,Int,Int,Int] should equal(Message4[Int,Int,Int,Int]('test))
  }


  "MessageBuilder.apply[Vector(A, B, C, D, E)]" should "properly create a Message5" in {
    MessageBuilder('test).apply[Int,Int,Int,Int,Int] should equal(Message5[Int,Int,Int,Int,Int]('test))
  }


  "MessageBuilder.apply[Vector(A, B, C, D, E, F)]" should "properly create a Message6" in {
    MessageBuilder('test).apply[Int,Int,Int,Int,Int,Int] should equal(Message6[Int,Int,Int,Int,Int,Int]('test))
  }


  "MessageBuilder.apply[Vector(A, B, C, D, E, F, G)]" should "properly create a Message7" in {
    MessageBuilder('test).apply[Int,Int,Int,Int,Int,Int,Int] should equal(Message7[Int,Int,Int,Int,Int,Int,Int]('test))
  }


  "MessageBuilder.apply[Vector(A, B, C, D, E, F, G, H)]" should "properly create a Message8" in {
    MessageBuilder('test).apply[Int,Int,Int,Int,Int,Int,Int,Int] should equal(Message8[Int,Int,Int,Int,Int,Int,Int,Int]('test))
  }


  "MessageBuilder.apply[Vector(A, B, C, D, E, F, G, H, I)]" should "properly create a Message9" in {
    MessageBuilder('test).apply[Int,Int,Int,Int,Int,Int,Int,Int,Int] should equal(Message9[Int,Int,Int,Int,Int,Int,Int,Int,Int]('test))
  }


  "MessageBuilder.apply[Vector(A, B, C, D, E, F, G, H, I, J)]" should "properly create a Message10" in {
    MessageBuilder('test).apply[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int] should equal(Message10[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int]('test))
  }


  "MessageBuilder.apply[Vector(A, B, C, D, E, F, G, H, I, J, K)]" should "properly create a Message11" in {
    MessageBuilder('test).apply[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int] should equal(Message11[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int]('test))
  }


  "MessageBuilder.apply[Vector(A, B, C, D, E, F, G, H, I, J, K, L)]" should "properly create a Message12" in {
    MessageBuilder('test).apply[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int] should equal(Message12[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int]('test))
  }


  "MessageBuilder.apply[Vector(A, B, C, D, E, F, G, H, I, J, K, L, M)]" should "properly create a Message13" in {
    MessageBuilder('test).apply[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int] should equal(Message13[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int]('test))
  }


  "MessageBuilder.apply[Vector(A, B, C, D, E, F, G, H, I, J, K, L, M, N)]" should "properly create a Message14" in {
    MessageBuilder('test).apply[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int] should equal(Message14[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int]('test))
  }


  "MessageBuilder.apply[Vector(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O)]" should "properly create a Message15" in {
    MessageBuilder('test).apply[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int] should equal(Message15[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int]('test))
  }


  "MessageBuilder.apply[Vector(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P)]" should "properly create a Message16" in {
    MessageBuilder('test).apply[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int] should equal(Message16[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int]('test))
  }


  "MessageBuilder.apply[Vector(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q)]" should "properly create a Message17" in {
    MessageBuilder('test).apply[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int] should equal(Message17[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int]('test))
  }


  "MessageBuilder.apply[Vector(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R)]" should "properly create a Message18" in {
    MessageBuilder('test).apply[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int] should equal(Message18[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int]('test))
  }


  "MessageBuilder.apply[Vector(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S)]" should "properly create a Message19" in {
    MessageBuilder('test).apply[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int] should equal(Message19[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int]('test))
  }


  "MessageBuilder.apply[Vector(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T)]" should "properly create a Message20" in {
    MessageBuilder('test).apply[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int] should equal(Message20[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int]('test))
  }


  "MessageBuilder.apply[Vector(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U)]" should "properly create a Message21" in {
    MessageBuilder('test).apply[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int] should equal(Message21[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int]('test))
  }


  "MessageBuilder.apply[Vector(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V)]" should "properly create a Message22" in {
    MessageBuilder('test).apply[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int] should equal(Message22[Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int,Int]('test))
  }

}

