package s_mach.i18n

import s_mach.i18n.impl._

trait Interpolator {
  def interpolate(
    parts: Seq[Interpolation],
    args: I18NString*
  )(implicit
    cfg:I18NConfig
  ) : I18NString

  def interpolate(
    key: String,
    args: I18NString*
  )(implicit
    cfg:I18NConfig
  ) : I18NString
}

object Interpolator {
  val strict = new StrictInterpolator
  val tolerant = new TolerantInterpolator
  val default = strict
}
