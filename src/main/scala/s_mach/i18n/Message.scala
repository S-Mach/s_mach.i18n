package s_mach.i18n


trait Message {

  def key: String

  def throwIfMissing()(implicit m:Messages) : this.type = {
    if(m.contains(key) == false) {
      throw new IllegalArgumentException(s"Messages missing key $key")
    } else {
      this
    }
  }

//  def arity : Int
//
//  def bind(message: String) : (String,Seq[String]) = {
//    val matchCount = Message.splitRegex.findAllIn(message).size
//    require(matchCount == arity,s"Bound message string must have exactly $arity parameters")
//    val parts = Message.splitRegex.split(message)
//    key -> parts
//  }
}

object Message {
  val splitRegex = "(?<=[^$])\\$[0-9]+".r
//  implicit val i18n_Message = I18N[Message0] { (a,l,m) =>
//    m(a.key)
//  }

  def apply(key: String) : Message0 = Message0(key)
}

case class BoundMessage(key: String, parts: Seq[String])
object BoundMessage {
  implicit def toTuple(b: BoundMessage) : (String,Seq[String]) =
    b.key -> b.parts
}

case class MessageBuilder(
  key: String
) {
  def apply(default: Option[I18NString] = None) = Message0(key,default)
  def apply[A] = Message1[A](key)
  def apply[A,B] = Message2[A,B](key)
}

case class Message0(
  key: String,
  default: Option[I18NString] = None
) extends Message {
  def withDefault(value: I18NString) =
    copy(default = Some(value))

  def apply()(implicit
    cfg: I18NConfig
    ) : I18NString = {
    cfg.messages.get(key) orElse default match {
      case Some(i18n) => i18n
      case None =>
        // Access key again to force throw since no default
        cfg.messages(key)
    }
  }

  def bind(message: String) =
    BoundMessage(key,Seq(message))

  def ->(message: String) = bind(message)
}


case class Message1[A](key: String) extends Message {
  def apply(a: A)(implicit
    cfg: I18NConfig,
    ia: I18N[A]
    ) : I18NString = {
    cfg.messages(key,ia.i18n(a))
  }

  def bind(f: String => StringContext) ={
    val parts = f("").parts
    require(parts.size == 1 || parts.size == 2,"StringContext must have 1 or 2 parts")
    BoundMessage(key,parts)
  }

  def ->(f: String => StringContext) = bind(f)
}

case class Message2[A,B](key: String) extends Message {
  def apply(a: A, b: B)(implicit
    cfg: I18NConfig,
    ia: I18N[A],
    ib: I18N[B]
  ) : I18NString = {
    cfg.messages(key,ia.i18n(a),ib.i18n(b))
  }

  def bind(f: (String,String) => StringContext) = {
    val parts = f("","").parts
    require(parts.size == 2 || parts.size == 3,"StringContext must have 2 or 3 parts")
    BoundMessage(key,parts)
  }

  def ->(f: (String,String) => StringContext) = bind(f)
}
