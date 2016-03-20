package s_mach

import scala.language.implicitConversions
import s_mach.codetools.IsDistinctTypeAlias

package object i8n extends BuiltInTypeImplicits {
  trait I8NTag
  type I8NString = String with I8NTag with IsDistinctTypeAlias[String]
  def I8NString(value: String) : I8NString = value.asInstanceOf[I8NString]

//  case class I8NString(value: String)

  implicit def toI8NString[A](value: A)(implicit i8n:I8N[A],m: MessageFor) : I8NString =
    i8n.print(value)

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
