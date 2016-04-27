package s_mach.i18n.messages

object Implicits {
  /* UOhrCDet suffix added to prevent shadowing issues */

  implicit class StringPML_UOhrCDet(val self: String) extends AnyVal {
    def m : MessageBuilder = MessageBuilder(Symbol(self))
    def m0 : MessageLiteral = MessageLiteral(Symbol(self))
    def literal : MessageLiteral = MessageLiteral(Symbol(self))
    def choice : MessageChoice = MessageChoice(Symbol(self))
  }

  implicit class SymbolPML_UOhrCDet(val self: Symbol) extends AnyVal {
    def m : MessageBuilder = MessageBuilder(self)
    def m0 : MessageLiteral = MessageLiteral(self)
    def literal : MessageLiteral = MessageLiteral(self)
    def choice : MessageChoice = MessageChoice(self)
  }

  implicit class MessagesPML_UOhrCDet(val self: Messages) extends AnyVal {
    def orElse(other: Messages) : Messages =
      Messages.orElse(self,other)
  }
}
