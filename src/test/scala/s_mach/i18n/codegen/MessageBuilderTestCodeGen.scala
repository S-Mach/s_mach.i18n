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
object MessageBuilderTestCodeGen {

  def gen(n: Int) = {
    val ucs = ('A' to 'Z').map(_.toString).take(n)
    val ints = Seq.fill(n)("Int").mkString(",")
s"""
  "MessageBuilder.apply[$ucs]" should "properly create a Message$n" in {
    MessageBuilder('test).apply[$ints] should equal(Message$n[$ints]('test))
  }
"""
  }

  def genToFile(path: String) : Unit = {

    val contents =
s"""$header
package s_mach.i18n.test

import org.scalatest.{FlatSpec, Matchers}
import s_mach.i18n.messages._

/* WARNING: Generated code. To modify see s_mach.i18n.codegen.MessageBuilderCodeGen */
class MessageBuilderTest extends FlatSpec with Matchers {
${(1 to 22).map(i => gen(i)).mkString("\n")}
}
"""

    import java.io._
    val out = new PrintWriter(new BufferedWriter(new FileWriter(path)))
    out.println(contents)
    out.close()
  }
}
