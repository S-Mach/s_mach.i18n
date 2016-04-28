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

import java.text.NumberFormat

import s_mach.i18n._
import s_mach.i18n.messages.MessageLiteral

class DefaultStdI18N extends StdI18N {

  // Note: NumberFormat is not thread-safe so can't save instance
  // without synchronization

  val m_true = MessageLiteral('m_true)
  val m_false = MessageLiteral('m_false)

  def i18n(value: Boolean)(implicit cfg: I18NConfig) = {
    if(value) {
      m_true()
    } else {
      m_false()
    }
  }
  def i18n(value: Byte)(implicit cfg: I18NConfig) = {
    val fmt = NumberFormat.getIntegerInstance(cfg.locale)
    I18NString(fmt.format(value))
  }
  def i18n(value: Short)(implicit cfg: I18NConfig) = {
    val fmt = NumberFormat.getIntegerInstance(cfg.locale)
    I18NString(fmt.format(value))
  }
  def i18n(value: Int)(implicit cfg: I18NConfig) = {
    val fmt = NumberFormat.getIntegerInstance(cfg.locale)
    I18NString(fmt.format(value))
  }
  def i18n(value: Long)(implicit cfg: I18NConfig) = {
    val fmt = NumberFormat.getIntegerInstance(cfg.locale)
    I18NString(fmt.format(value))
  }
  def i18n(value: Float)(implicit cfg: I18NConfig) = {
    val fmt = NumberFormat.getNumberInstance(cfg.locale)
    I18NString(fmt.format(value))
  }
  def i18n(value: Double)(implicit cfg: I18NConfig) = {
    val fmt = NumberFormat.getNumberInstance(cfg.locale)
    I18NString(fmt.format(value))
  }
  def i18n(value: BigInt)(implicit cfg: I18NConfig) = {
    val fmt = NumberFormat.getNumberInstance(cfg.locale)
    I18NString(fmt.format(value.underlying()))
  }
  def i18n(value: BigDecimal)(implicit cfg: I18NConfig) = {
    val fmt = NumberFormat.getNumberInstance(cfg.locale)
    I18NString(fmt.format(value.underlying()))
  }
}
