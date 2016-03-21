package s_mach.i8n.impl

import s_mach.i8n._

object I8NOps {
  @inline def i8n[A](self: A)(implicit i8n: I8N[A],t: I8NTranslator) : I8NString =
    i8n.i8n(self)

  @inline def i(self: StringContext)(args: I8NString*)(implicit t: I8NTranslator) : I8NString =
    t.translate(self.parts,args:_*)
}
