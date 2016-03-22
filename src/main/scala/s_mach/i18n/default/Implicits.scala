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
import s_mach.i18n.{I18NTag,I18NTranslator,I18N}
import s_mach.i18n.impl.I18NOps

object Implicits extends Implicits {
  /* hHQiIbEzQp suffix added to prevent shadowing issues */

  type I18NString = String with I18NTag with IsDistinctTypeAlias[String]
  def I18NString(value: String) : I18NString = value.asInstanceOf[I18NString]
  implicit def toI18NString[A](value: A)(implicit i18n: I18N[A],t: I18NTranslator) : I18NString =
    i18n.i18n(value)(t)

  implicit class EverythingPML_hHQiIbEzQp[A](val self: A) extends AnyVal {
    def i18n(implicit i18n: I18N[A],t: I18NTranslator) : I18NString =
      I18NOps.i18n(self)(i18n,t)
  }

  implicit class StringContextPML_hHQiIbEzQp(val self: StringContext) extends AnyVal {
    def i(args: I18NString*)(implicit t: I18NTranslator) : I18NString =
      I18NOps.i(self)(args:_*)(t)
  }
}

trait Implicits {
  // Note: NumberFormat is not threadsafe so can't save fmt between calls

  implicit val i18n_Boolean =
    I18N[Boolean] { (a,t) =>
      if(a) {
        t.translate("true")
      } else {
        t.translate("false")
      }
    }
  implicit val i18n_Byte =
    I18N[Byte] { (a,t) =>
      val fmt = NumberFormat.getIntegerInstance(t.locale)
      fmt.format(a)
    }

  implicit val i18n_Short =
    I18N[Short] { (a,t) =>
      val fmt = NumberFormat.getIntegerInstance(t.locale)
      fmt.format(a)
    }

  implicit val i18n_Int =
    I18N[Int] { (a,t) =>
      val fmt = NumberFormat.getIntegerInstance(t.locale)
      fmt.format(a)
    }

  implicit val i18n_Long =
    I18N[Long] { (a,t) =>
      val fmt = NumberFormat.getIntegerInstance(t.locale)
      fmt.format(a)
    }

  implicit val i18n_Float =
    I18N[Float] { (a,t) =>
      val fmt = NumberFormat.getNumberInstance(t.locale)
      fmt.format(a)
    }

  implicit val i18n_Double =
    I18N[Double] { (a,t) =>
      val fmt = NumberFormat.getNumberInstance(t.locale)
      fmt.format(a)
    }

  implicit val i18n_Char =
    I18N[Char] { (a,t) =>
      a.toString
    }

  implicit val i18n_String =
    I18N[String] { (a,t) => a }

  implicit val i18n_BigInt =
    I18N[BigInt] { (a,t) =>
      val fmt = NumberFormat.getNumberInstance(t.locale)
      fmt.format(a.underlying())
    }

  implicit val i18n_BigDecimal =
    I18N[BigDecimal] { (a,t) =>
      val fmt = NumberFormat.getNumberInstance(t.locale)
      fmt.format(a.underlying())
    }
}
