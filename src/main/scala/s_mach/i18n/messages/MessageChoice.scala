package s_mach.i18n.messages

import s_mach.i18n._

case class MessageChoice(
  key: Symbol
  ) extends Message {
  def apply[N](
    n: N
    )(implicit
    numeri18nC:Numeric[N],
    cfg: I18NConfig
    ) : I18NString = {
    cfg.resolver.resolveChoice(key, BigDecimal(n.toString))
  }
}
