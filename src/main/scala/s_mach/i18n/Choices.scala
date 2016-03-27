package s_mach.i18n

trait Choices {
  def contains(key: String) : Boolean
  def get(key: String) : Option[BigDecimal => I18NString]
  def apply(key: String) : BigDecimal => I18NString
}

object Choices {
  def apply(choices: (String,BigDecimal => I18NString)*) : Choices = {
    val _choices = choices.toMap
    new Choices {
      val choices = _choices.toMap
      def contains(key: String) = choices.contains(key)
      def apply(key: String) = choices(key)
      def get(key: String) = choices.get(key)
    }
  }
}