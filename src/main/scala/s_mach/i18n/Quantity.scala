package s_mach.i18n

case class Quantity[N:Numeric](
  value: N,
  key: String
)

object Quantity {
  implicit def i18n_Quantity[N](implicit n:Numeric[N]) = I18N[Quantity[N]] { cfg => a =>
    import cfg._
    import a._

    I18NString(
      value match {
        case v if v == n.zero => messages.words.zero(key)
        case v if v == n.one => messages.words.singular(key)
        case v => messages.words.plural(key)
      }
    )
  }
}
