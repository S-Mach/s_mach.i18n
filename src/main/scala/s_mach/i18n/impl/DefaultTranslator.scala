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
package s_mach.i18n.impl

import java.util.Locale
import s_mach.i18n._

/**
 * Default translator that does nothing.
 * @param locale local to associate with this translator
 */
class DefaultTranslator(val locale: Locale) extends I18NTranslator {
  def translate(parts: Seq[String], args: I18NString*) : I18NString = {
    val xs = parts.iterator
    val exprs = args.iterator
    if(parts.nonEmpty) {
      val sb = new StringBuffer(xs.next())
      while (xs.hasNext) {
        sb.append(exprs.next())
        sb.append(xs.next())
      }
      I18NString(sb.toString)
    } else {
      I18NString("")
    }
  }

  def translate(key: String, args: I18NString*) = I18NString(key)

}

//  type MessageKey = String
//
//  def mkKey(parts: Seq[String]) = {
//    if(parts.nonEmpty) {
//      val sb = new StringBuffer(parts.head)
//      val xp = parts.tail.iterator
//      var i = 1
//      while(xp.hasNext) {
//        sb.append(s"$i")
//        sb.append(xp.next())
//        i = i + 1
//      }
//      sb.toString()
//    } else {
//      ""
//    }
//  }
//
//  def mkKey(value: String) = value
//
//  val paramRegex = "[^$]\\$([0-9]+)".r
//  def findByKey(key: MessageKey, args: I18NString*) = {
//    val matches = paramRegex.findAllMatchIn(key)
//    if(matches.isEmpty) {
//      I18NString(key)
//    } else {
//      val first = matches.next()
//      val sb = new StringBuilder(key.substring(0,first.start))
//      def getParam(m: Regex.Match) : String = {
//        try {
//          Option(m.group(1)) match {
//            case Some(n) =>
//              args(n.toInt)
//            case None => "null"
//          }
//        } catch {
//          case NonFatal(x) =>
//            "null"
//        }
//      }
//      sb.append(getParam(first))
//      var last = first
//      while(matches.hasNext) {
//        val m = matches.next()
//        sb.append(key.substring(last.end,m.start))
//        sb.append(getParam(m))
//        last = m
//      }
//      I18NString(sb.toString())
//    }
//  }


