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
package s_mach.i18n.codegen

import Header.header
object MessageNTestCodeGen {
  def gen(n: Int) = {
s"""
  "Message$n.apply" should "resolve interpolation" in {
    val m_test$n = 'm_test$n.m[${Seq.fill(n)("Int").mkString(",")}]
    m_test$n(${(1 to n).mkString(",")}) should equal ("test ${(1 to n).mkString(" ")}")
  }
"""
  }


  def genMessage(n: Int) = {
    s"m_test$n=test ${(0 until n).map(i => s"{$i}").mkString(" ")}"
  }

  def genToFile(path: String) : Unit = {

    val contents =
s"""$header
package s_mach.i18n.test

import java.util.Locale
import org.scalatest.{FlatSpec, Matchers}
import s_mach.i18n._
import s_mach.i18n.messages._

/* WARNING: Generated code. To modify see s_mach.i18n.codegen.MessageNTestCodeGen */

class MessageNTest extends FlatSpec with Matchers {
  implicit val i18ncfg = I18NConfig(Locale.ENGLISH)

${(1 to 22).map(i => gen(i)).mkString("\n")}
}
"""

    import java.io._
    val out = new PrintWriter(new BufferedWriter(new FileWriter(path)))
    out.println(contents)
    out.close()
  }
}
