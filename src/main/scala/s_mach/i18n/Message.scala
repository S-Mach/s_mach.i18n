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

//  def apply[A,B] = Message2[A,B](key)
}

object Message {
//  implicit val i18n_Message = I18N[Message0] { (a,l,m) =>
//    m(a.key)
//  }

  def apply(key: String) : Message0 = Message0(key)
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

}


case class Message1[A](key: String) extends Message {
  def apply(a: A)(implicit
    cfg: I18NConfig,
    ia: I18N[A]
    ) : I18NString = {
    cfg.messages(key,ia.i18n(a))
  }
}

case class Message2[A,B](key: String) extends Message {
  def apply(a: A, b: B)(implicit
    cfg: I18NConfig,
    ia: I18N[A],
    ib: I18N[B]
  ) : I18NString = {
    cfg.messages(key,ia.i18n(a),ib.i18n(b))
  }
}
