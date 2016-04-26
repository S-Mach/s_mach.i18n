package s_mach.i18n.impl

import s_mach.i18n.{Format, Messages}

case class OrElseMessages(
  m1: Messages,
  m2: Messages
) extends Messages {
  require(m1.locale == m2.locale)

  val locale = m1.locale

  def get(key: Symbol): Option[Format] =
    m1.get(key) orElse m2.get(key)

  def keys: Iterable[Symbol] =
    m1.keys.toSet ++ m2.keys

  def contains(key: Symbol): Boolean =
    m1.contains(key) || m2.contains(key)

  def apply(key: Symbol) : Format =
    m1.applyOrElse(key,m2.apply)

  def applyOrElse(key: Symbol, default: Symbol => Format): Format =
    m1.applyOrElse(key,m2.applyOrElse(_, default))

}