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

object MessageBuilderCodeGen {
  def gen(n: Int) : String = {
    val ucs = ('A' to 'Z').map(_.toString).take(n)
    val ucsLists = ucs.zipWithIndex.map { case (_,i) =>
      val n = i +1
      (ucs.take(n).mkString(","),n)
    }
s"""
case class MessageBuilder(key: Symbol) {
  ${
    ucsLists.map { case (ucs,n) =>
      s"def apply[$ucs] = Message$n[$ucs](key)"
    }.mkString("\n  ")
  }
}
"""

  }

  def genToFile(path: String) : Unit = {

    val contents =
s"""$header
package s_mach.i18n.messages

/* WARNING: Generated code. To modify see s_mach.i18n.codegen.MessageBuilderCodeGen */

${gen(22)}
"""

    import java.io._
    val out = new PrintWriter(new BufferedWriter(new FileWriter(path)))
    out.println(contents)
    out.close()
  }
}
