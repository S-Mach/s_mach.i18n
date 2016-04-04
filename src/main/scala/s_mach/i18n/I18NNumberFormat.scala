package s_mach.i18n

import s_mach.i18n.impl.DefaultI18NNumberFormat

trait I18NNumberFormat {
  def i18n(value: Boolean)(implicit cfg: I18NConfig) : I18NString
  def i18n(value: Byte)(implicit cfg: I18NConfig) : I18NString
  def i18n(value: Short)(implicit cfg: I18NConfig) : I18NString
  def i18n(value: Int)(implicit cfg: I18NConfig) : I18NString
  def i18n(value: Long)(implicit cfg: I18NConfig) : I18NString
  def i18n(value: Float)(implicit cfg: I18NConfig) : I18NString
  def i18n(value: Double)(implicit cfg: I18NConfig) : I18NString
  def i18n(value: BigInt)(implicit cfg: I18NConfig) : I18NString
  def i18n(value: BigDecimal)(implicit cfg: I18NConfig) : I18NString
}

object I18NNumberFormat {
  val default = new DefaultI18NNumberFormat
}