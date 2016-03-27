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

import java.util.Locale

import scala.language.implicitConversions
import java.text.NumberFormat
import s_mach.codetools.IsDistinctTypeAlias
import s_mach.i18n._
import s_mach.i18n.impl.I18NOps

object Implicits extends Implicits {
  /* hHQiIbEzQp suffix added to prevent shadowing issues */

  type I18NString = String with I18NStringTag with IsDistinctTypeAlias[String]
  def I18NString(value: String) : I18NString = value.asInstanceOf[I18NString]
  implicit def toI18NString[A](value: A)(implicit i18n: I18N[A], cfg: I18NConfig) : I18NString =
    i18n.i18n(value)(cfg)

  implicit class EverythingPML_hHQiIbEzQp[A](val self: A) extends AnyVal {
    def i18n(implicit i18n: I18N[A],cfg: I18NConfig) : I18NString =
      I18NOps.i18n(self)(i18n,cfg)
  }

  implicit class StringContextPML_hHQiIbEzQp(val self: StringContext) extends AnyVal {
    def i(args: I18NString*)(implicit cfg: I18NConfig) : I18NString =
      I18NOps.i(self)(args:_*)(cfg)
    def sc(args: Any*) : StringContext = self
  }

  implicit def mkI18NConfig(implicit l: Locale, m:Messages) : I18NConfig =
    I18NConfig(l,m)
}

trait Implicits {
  // Note: NumberFormat is not threadsafe so can't save fmt between calls without synchronize

  val m_true = Message("true").withDefault(I18NString("true"))
  val m_false = Message("false").withDefault(I18NString("false"))
  
  implicit val i18n_Boolean =
    I18N[Boolean] { cfg => a =>
      if(a) {
        m_true()(cfg)
      } else {
        m_false()(cfg)
      }
    }

  implicit val i18n_Byte =
    I18N[Byte] { cfg => a =>
      val fmt = NumberFormat.getIntegerInstance(cfg.locale)
      I18NString(fmt.format(a))
    }

  implicit val i18n_Short =
    I18N[Short] { cfg => a =>
      val fmt = NumberFormat.getIntegerInstance(cfg.locale)
      I18NString(fmt.format(a))
    }

  implicit val i18n_Int =
    I18N[Int] { cfg => a =>
      val fmt = NumberFormat.getIntegerInstance(cfg.locale)
      I18NString(fmt.format(a))
    }

  implicit val i18n_Long =
    I18N[Long] { cfg => a =>
      val fmt = NumberFormat.getIntegerInstance(cfg.locale)
      I18NString(fmt.format(a))
    }

  implicit val i18n_Float =
    I18N[Float] { cfg => a =>
      val fmt = NumberFormat.getNumberInstance(cfg.locale)
      I18NString(fmt.format(a))
    }

  implicit val i18n_Double =
    I18N[Double] { cfg => a =>
      val fmt = NumberFormat.getNumberInstance(cfg.locale)
      I18NString(fmt.format(a))
    }

  implicit val i18n_Char =
    I18N[Char] { cfg => a =>
      I18NString(a.toString)
    }

  implicit val i18n_String =
    I18N[String] { cfg => a =>
      I18NString(a)
    }

  implicit val i18n_BigInt =
    I18N[BigInt] { cfg => a =>
      val fmt = NumberFormat.getNumberInstance(cfg.locale)
      I18NString(fmt.format(a.underlying()))
    }

  implicit val i18n_BigDecimal =
    I18N[BigDecimal] { cfg => a =>
      val fmt = NumberFormat.getNumberInstance(cfg.locale)
      I18NString(fmt.format(a.underlying()))
    }
}
