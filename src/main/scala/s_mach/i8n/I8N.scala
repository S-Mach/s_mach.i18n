package s_mach.i8n

trait I8N[A] {
  def print(a: A)(implicit m: MessageFor) : I8NString
}

object I8N {
  def apply[A](f: (A,MessageFor) => String) : I8N[A] = new I8N[A] {
    def print(a: A)(implicit m: MessageFor) = I8NString(f(a,m))
  }
}

// how to print currency, date and quantities varies by language
