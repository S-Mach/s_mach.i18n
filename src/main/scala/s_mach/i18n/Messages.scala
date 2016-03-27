package s_mach.i18n

trait Messages {
  def contains(key: String) : Boolean
  def get(key: String, args: I18NString*) : Option[I18NString]
  def apply(key: String, args: I18NString*) : I18NString
}

object Messages {
  def apply(
    messages: (String,Seq[String])*
  ) : Messages = {
    val _messages = messages
    new Messages {
      val messages = _messages.toMap

      def contains(key: String) = messages.contains(key)
      def get(key: String, args: I18NString*) =
        messages.get(key).map(parts => mkI18NString(parts,args:_*))

      def apply(key: String, args: I18NString*) =
        mkI18NString(messages(key),args:_*)

      def mkI18NString(parts: Seq[String], args: I18NString*) = {
        I18NString(
          StringContext(parts:_*).raw(args:_*)
        )
      }
    }
  }
}
