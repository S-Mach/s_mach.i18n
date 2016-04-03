package s_mach.i18n

trait MissingArgHandler extends (Int => String)

object MissingArgHandler {
  val default = new MissingArgHandler {
    def apply(v1: Int) = "null"
  }
  def apply(f: Int => String) = new MissingArgHandler {
    def apply(v1: Int) = f(v1)
  }
}
