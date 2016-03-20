package s_mach.i8n.impl

import java.util.Locale

import s_mach.i8n._

import scala.util.control.NonFatal
import scala.util.matching.Regex

class NoopMessageFor(val locale: Locale) extends MessageFor {
  type MessageKey = String

  def mkKey(parts: Seq[String]) = {
    if(parts.nonEmpty) {
      val sb = new StringBuffer(parts.head)
      val xp = parts.tail.iterator
      var i = 1
      while(xp.hasNext) {
        sb.append(s"$i")
        sb.append(xp.next())
        i = i + 1
      }
      sb.toString()
    } else {
      ""
    }
  }

  def mkKey(value: String) = value

  val paramRegex = "[^$]\\$([0-9]+)".r
  def findByKey(key: MessageKey, args: I8NString*) = {
    val matches = paramRegex.findAllMatchIn(key)
    if(matches.isEmpty) {
      I8NString(key)
    } else {
      val first = matches.next()
      val sb = new StringBuilder(key.substring(0,first.start))
      def getParam(m: Regex.Match) : String = {
        try {
          Option(m.group(1)) match {
            case Some(n) =>
              args(n.toInt)
            case None => "null"
          }
        } catch {
          case NonFatal(x) =>
            "null"
        }
      }
      sb.append(getParam(first))
      var last = first
      while(matches.hasNext) {
        val m = matches.next()
        sb.append(key.substring(last.end,m.start))
        sb.append(getParam(m))
        last = m
      }
      I8NString(sb.toString())
    }
  }

  def translate(parts: Seq[String], args: I8NString*) : I8NString = {
    val xs = parts.iterator
    val exprs = args.iterator
    if(parts.nonEmpty) {
      val sb = new StringBuffer(xs.next())
      while (xs.hasNext) {
        sb.append(exprs.next())
        sb.append(xs.next())
      }
      I8NString(sb.toString)
    } else {
      I8NString("")
    }
  }

  def translate(s: String) = I8NString(s)

}
