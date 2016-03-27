package s_mach.i18n

case class Quantity(
  key: String
) {

  def apply[N](n: N)(implicit numeric:Numeric[N],cfg: I18NConfig) : I18NString = {
    import cfg._
    I18NString(
      choices(key)(BigDecimal(n.toString))
    )
  }
}