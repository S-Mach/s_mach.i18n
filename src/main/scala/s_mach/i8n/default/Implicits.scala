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
package s_mach.i18n.default

import scala.language.implicitConversions
import java.text.NumberFormat
import s_mach.codetools.IsDistinctTypeAlias
import s_mach.i18n.{i18nTag,i18nTranslator,i18n}
import s_mach.i18n.impl.i18nOps

object Implicits extends Implicits {
  /* hHQiIbEzQp suffix added to prevent shadowing issues */

  type i18nString = String with i18nTag with IsDistinctTypeAlias[String]
  def i18nString(value: String) : i18nString = value.asInstanceOf[i18nString]
  implicit def toi18nString[A](value: A)(implicit i18n: i18n[A],t: i18nTranslator) : i18nString =
    i18n.i18n(value)(t)

  implicit class EverythingPML_hHQiIbEzQp[A](val self: A) extends AnyVal {
    def i18n(implicit i18n: i18n[A],t: i18nTranslator) : i18nString =
      i18nOps.i18n(self)(i18n,t)
  }

  implicit class StringContextPML_hHQiIbEzQp(val self: StringContext) extends AnyVal {
    def i(args: i18nString*)(implicit t: i18nTranslator) : i18nString =
      i18nOps.i(self)(args:_*)(t)
  }
}

trait Implicits {
  // Note: NumberFormat is not threadsafe so can't save fmt between calls

  implicit val i18n_Boolean =
    i18n[Boolean] { (a,t) =>
      if(a) {
        t.translate("true")
      } else {
        t.translate("false")
      }
    }
  implicit val i18n_Byte =
    i18n[Byte] { (a,t) =>
      val fmt = NumberFormat.getIntegerInstance(t.locale)
      fmt.format(a)
    }

  implicit val i18n_Short =
    i18n[Short] { (a,t) =>
      val fmt = NumberFormat.getIntegerInstance(t.locale)
      fmt.format(a)
    }

  implicit val i18n_Int =
    i18n[Int] { (a,t) =>
      val fmt = NumberFormat.getIntegerInstance(t.locale)
      fmt.format(a)
    }

  implicit val i18n_Long =
    i18n[Long] { (a,t) =>
      val fmt = NumberFormat.getIntegerInstance(t.locale)
      fmt.format(a)
    }

  implicit val i18n_Float =
    i18n[Float] { (a,t) =>
      val fmt = NumberFormat.getNumberInstance(t.locale)
      fmt.format(a)
    }

  implicit val i18n_Double =
    i18n[Double] { (a,t) =>
      val fmt = NumberFormat.getNumberInstance(t.locale)
      fmt.format(a)
    }

  implicit val i18n_Char =
    i18n[Char] { (a,t) =>
      a.toString
    }

  implicit val i18n_String =
    i18n[String] { (a,t) => a }

  implicit val i18n_BigInt =
    i18n[BigInt] { (a,t) =>
      val fmt = NumberFormat.getNumberInstance(t.locale)
      fmt.format(a.underlying())
    }

  implicit val i18n_BigDecimal =
    i18n[BigDecimal] { (a,t) =>
      val fmt = NumberFormat.getNumberInstance(t.locale)
      fmt.format(a.underlying())
    }
}
