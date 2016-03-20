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
package s_mach.i8n

import java.text.NumberFormat

class BuiltInTypeImplicits {
  // Note: NumberFormat is not threadsafe

  implicit val i8n_Boolean =
    I8N[Boolean] { (a,m) =>
      if(a) {
        m.translate("true")
      } else {
        m.translate("false")
      }
    }
  implicit val i8n_Byte =
    I8N[Byte] { (a,m) =>
      val fmt = NumberFormat.getIntegerInstance(m.locale)
      fmt.format(a)
    }

  implicit val i8n_Short =
    I8N[Short] { (a,m) =>
      val fmt = NumberFormat.getIntegerInstance(m.locale)
      fmt.format(a)
    }

  implicit val i8n_Int =
    I8N[Int] { (a,m) =>
      val fmt = NumberFormat.getIntegerInstance(m.locale)
      fmt.format(a)
    }

  implicit val i8n_Long =
    I8N[Long] { (a,m) =>
      val fmt = NumberFormat.getIntegerInstance(m.locale)
      fmt.format(a)
    }

  implicit val i8n_Float =
    I8N[Float] { (a,m) =>
      val fmt = NumberFormat.getNumberInstance(m.locale)
      fmt.format(a)
    }

  implicit val i8n_Double =
    I8N[Double] { (a,m) =>
      val fmt = NumberFormat.getNumberInstance(m.locale)
      fmt.format(a)
    }

  implicit val i8n_Char =
    I8N[Char] { (a,m) =>
      a.toString
    }

  implicit val i8n_String =
    I8N[String] { (a,m) => a }

  implicit val i8n_BigInt =
    I8N[BigInt] { (a,m) =>
      val fmt = NumberFormat.getNumberInstance(m.locale)
      fmt.format(a.underlying())
    }

  implicit val i8n_BigDecimal =
    I8N[BigDecimal] { (a,m) =>
      val fmt = NumberFormat.getNumberInstance(m.locale)
      fmt.format(a.underlying())
    }
}
