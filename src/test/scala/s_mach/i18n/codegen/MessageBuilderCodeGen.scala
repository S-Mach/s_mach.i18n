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
