package s_mach.i18n

trait Messages {
  def contains(key: String) : Boolean
  def get(key: String, args: I18NString*) : Option[I18NString]
  def apply(key: String, args: I18NString*) : I18NString

  trait Words {
    def zero(key: String) : I18NString
    def singular(key: String) : I18NString
    def plural(key: String) : I18NString
  }
  def words: Words

  def context(key: String) : Messages
}

object Messages {
  val empty = new Messages {
    def contains(key: String) = false
    def get(key: String, args: I18NString*) = None
    def throwMissingKey(key: String) =
      throw new NoSuchElementException(s"No such message key $key")
    val words = new Words {
      def zero(key: String) = throwMissingKey(key)
      def singular(key: String) = throwMissingKey(key)
      def plural(key: String) = throwMissingKey(key)
    }
    def apply(key: String, args: I18NString*) = throwMissingKey(key)

    def context(key: String) = this
  }

  def apply(args: (String,Seq[String])*) : Messages = new Messages {
    val keys = args.toMap

    def contains(key: String) = keys.contains(key)
    def get(key: String, args: I18NString*) =
      keys.get(key).map(parts => I18NString(
        parts.iterator.zip(args.iterator).map(t => t._1 + t._2).reduce(_ + _)
      ))

    def throwMissingKey(key: String) =
      throw new NoSuchElementException(s"No such message key $key")

    val words = new Words {
      def zero(key: String) = throwMissingKey(key)
      def singular(key: String) = throwMissingKey(key)
      def plural(key: String) = throwMissingKey(key)
    }

    def apply(key: String, args: I18NString*) =
      {
        val parts = keys(key)
        I18NString(
          parts.iterator.zip(args.iterator).map(t => t._1 + t._2).reduce(_ + _)
        )
      }

    def context(key: String) = this
  }
}
