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
       ;it1i ,,,:::;;;::1tti      s_mach.i8n
         .t1i .,::;;; ;1tt        Copyright (c) 2016 S-Mach, Inc.
         Lft11ii;::;ii1tfL:       Author: lance.gatlin@gmail.com
          .L1 1tt1ttt,,Li
            ...1LLLL...
*/
package s_mach.i8n.default

import scala.language.implicitConversions
import java.text.NumberFormat
import s_mach.codetools.IsDistinctTypeAlias
import s_mach.i8n.{I8NTag,I8NTranslator,I8N}
import s_mach.i8n.impl.I8NOps

object Implicits extends Implicits {
  /* hHQiIbEzQp suffix added to prevent shadowing issues */

  type I8NString = String with I8NTag with IsDistinctTypeAlias[String]
  def I8NString(value: String) : I8NString = value.asInstanceOf[I8NString]
  implicit def toI8NString[A](value: A)(implicit i8n: I8N[A],t: I8NTranslator) : I8NString =
    i8n.i8n(value)(t)

  implicit class EverythingPML_hHQiIbEzQp[A](val self: A) extends AnyVal {
    def i8n(implicit i8n: I8N[A],t: I8NTranslator) : I8NString =
      I8NOps.i8n(self)(i8n,t)
  }

  implicit class StringContextPML_hHQiIbEzQp(val self: StringContext) extends AnyVal {
    def i(args: I8NString*)(implicit t: I8NTranslator) : I8NString =
      I8NOps.i(self)(args:_*)(t)
  }
}

trait Implicits {
  // Note: NumberFormat is not threadsafe so can't save fmt between calls

  implicit val i8n_Boolean =
    I8N[Boolean] { (a,t) =>
      if(a) {
        t.translate("true")
      } else {
        t.translate("false")
      }
    }
  implicit val i8n_Byte =
    I8N[Byte] { (a,t) =>
      val fmt = NumberFormat.getIntegerInstance(t.locale)
      fmt.format(a)
    }

  implicit val i8n_Short =
    I8N[Short] { (a,t) =>
      val fmt = NumberFormat.getIntegerInstance(t.locale)
      fmt.format(a)
    }

  implicit val i8n_Int =
    I8N[Int] { (a,t) =>
      val fmt = NumberFormat.getIntegerInstance(t.locale)
      fmt.format(a)
    }

  implicit val i8n_Long =
    I8N[Long] { (a,t) =>
      val fmt = NumberFormat.getIntegerInstance(t.locale)
      fmt.format(a)
    }

  implicit val i8n_Float =
    I8N[Float] { (a,t) =>
      val fmt = NumberFormat.getNumberInstance(t.locale)
      fmt.format(a)
    }

  implicit val i8n_Double =
    I8N[Double] { (a,t) =>
      val fmt = NumberFormat.getNumberInstance(t.locale)
      fmt.format(a)
    }

  implicit val i8n_Char =
    I8N[Char] { (a,t) =>
      a.toString
    }

  implicit val i8n_String =
    I8N[String] { (a,t) => a }

  implicit val i8n_BigInt =
    I8N[BigInt] { (a,t) =>
      val fmt = NumberFormat.getNumberInstance(t.locale)
      fmt.format(a.underlying())
    }

  implicit val i8n_BigDecimal =
    I8N[BigDecimal] { (a,t) =>
      val fmt = NumberFormat.getNumberInstance(t.locale)
      fmt.format(a.underlying())
    }
}
