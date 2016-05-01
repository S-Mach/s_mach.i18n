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
object MessageNCodeGen {
  def gen(n: Int) = {
    val lcs = ('a' to 'z').map(_.toString).take(n)
    val ucs = ('A' to 'Z').map(_.toString).take(n)
    val allUcs = ucs.mkString(",")
    val applyParams = lcs.map { lc => s"$lc:${lc.toUpperCase}"}.mkString(",")
s"""
case class Message$n[$allUcs](key: Symbol) extends Message {
  def apply($applyParams)(implicit
    cfg: I18NConfig,
    ${
      ucs.map { uc =>
        s"i18n$uc: I18N[$uc]"
      }.mkString(",\n    ")
    }
  ) : I18NString =
    cfg.resolver.resolveInterpolation(
      key,
      ${lcs.map(lc => s"i18n${lc.toUpperCase}($lc)").mkString(",\n      ")}
    )
}
"""
  }
  
  def genToFile(path: String) : Unit = {

    val contents =
s"""$header
package s_mach.i18n.messages

import s_mach.i18n._

/* WARNING: Generated code. To modify see s_mach.i18n.codegen.MessageNCodeGen */

${(2 to 22).map(i => gen(i)).mkString("\n")}
"""
    
    import java.io._
    val out = new PrintWriter(new BufferedWriter(new FileWriter(path)))
    out.println(contents)
    out.close()
  }

}