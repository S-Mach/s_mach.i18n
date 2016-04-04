package s_mach.i18n.impl

import java.text.NumberFormat

import s_mach.i18n._

class DefaultI18NNumberFormat extends I18NNumberFormat {

  // Note: NumberFormat is not thread-safe so can't save instance
  // without synchronization

  val m_true = Message("m_true")
  val m_false = Message("m_false")

  def i18n(value: Boolean)(implicit cfg: I18NConfig) = {
    if(value) {
      m_true()(cfg)
    } else {
      m_false()(cfg)
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
