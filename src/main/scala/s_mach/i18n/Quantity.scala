//package s_mach.i18n
//
//case class Quantity(
//  value: Int,
//  m: Message
//) {
//  require(value >= 0, "value must be positive")
//}
//
//object Quantity {
//  implicit val i18n_Quantity = I18N[Quantity] { cfg => a =>
//    import cfg._
//    import a._
//
//    I18NString(
//      messages.quantity(value,m.key)
//    )
//  }
//}
