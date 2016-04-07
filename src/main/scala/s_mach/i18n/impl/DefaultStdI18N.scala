package s_mach.i18n.impl

import java.text.NumberFormat

import s_mach.i18n._

class DefaultStdI18N extends StdI18N {

  // Note: NumberFormat is not thread-safe so can't save instance
  // without synchronization

  val m_true = Literal("m_true")
  val m_false = Literal("m_false")

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
