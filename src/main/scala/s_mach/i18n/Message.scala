package s_mach.i18n

import scala.language.implicitConversions

trait Message {

  def key: String

  def throwIfMissing()(implicit m:Messages) : this.type = {
    if(m.contains(key) == false) {
      throw new IllegalArgumentException(s"Messages missing key $key")
    } else {
      this
    }
  }

}

object Message {
  def apply(key: String) : Message0 = Message0(key)
}

case class MessageBuilder(
  key: String
) {
  def apply[A] = Message1[A](key)
  def apply[A,B] = Message2[A,B](key)
}

case class Message0(
  key: String
) extends Message {
  def apply()(implicit
    cfg: I18NConfig
    ) : I18NString = {
    cfg.interpolator.interpolate(key)
  }
}

case class Message1[A](key: String) extends Message {
  def apply(a: A)(implicit
    cfg: I18NConfig,
    ia: I18N[A]
    ) : I18NString = {
    cfg.interpolator.interpolate(key,ia(a))
  }
}

case class Message2[A,B](key: String) extends Message {
  def apply(a: A, b: B)(implicit
    cfg: I18NConfig,
    ia: I18N[A],
    ib: I18N[B]
  ) : I18NString = {
    cfg.interpolator.interpolate(key,ia(a),ib(b))
  }
}

case class MessageQuantity(
  key: String
  ) extends Message {
  def apply[N](n: N)(implicit numeric:Numeric[N],cfg: I18NConfig) : I18NString = {
    import cfg._
    I18NString(
      messages.choices(key)(BigDecimal(n.toString))
    )
  }
}
