package s_mach

package object i8n extends BuiltInTypeImplicits {
//  implicit class SymbolPML(val self: Symbol) extends AnyVal {
//    def msg(params: String*)(implicit m:Messages) : String =
//      m.messageFor(self,params:_*)
//
//    def <<(params: String*)(implicit m:Messages) : String =
//      msg(params:_*)
//  }

  trait I8NTag
  type I8NString = String with I8NTag
  def I8NString(value: String) : I8NString = value.asInstanceOf[I8NString]

//  case class I8NString(value: String)

  implicit class EverythingPML[A](val self: A) extends AnyVal {
    def i8n(implicit i8n: I8N[A],m: MessageFor) : I8NString =
      i8n.print(self)
  }

  implicit class StringContextPML(val self: StringContext) extends AnyVal {
    def m(args: I8NString*)(implicit m:MessageFor) : String = {
      m.translate(self.parts,args:_*)
    }
  }
}
