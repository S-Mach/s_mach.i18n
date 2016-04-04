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
package s_mach.i18n

import java.text.NumberFormat

/**
 * A type-class for converting an instance of a type to an internationalized string
 * (generally based on locale)
 */
trait I18N[A] {
  def apply(a: A)(implicit cfg: I18NConfig) : I18NString
}

object I18N {
  def apply[A](f: I18NConfig => A => I18NString) : I18N[A] =
    new I18N[A] {
      def apply(a: A)(implicit cfg:I18NConfig) = I18NString(f(cfg)(a))
    }

  object BuiltInImplicits extends BuiltInImplicits
  trait BuiltInImplicits {
    // Note: NumberFormat is not threadsafe so can't save fmt between calls without synchronize

    val m_true = Message("m_true")
    val m_false = Message("m_false")

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

    // Note: implicit val i18n_String is intentionally not declared
    // to prevent accidentally converting a String to I18NString without
    // internationalization. To cast a String to I18NString use String.i18n

    implicit val i18n_I18NString =
      I18N[I18NString] { cfg => a => a }

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
}
