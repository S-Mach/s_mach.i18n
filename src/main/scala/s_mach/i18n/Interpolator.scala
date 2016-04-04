package s_mach.i18n

import s_mach.i18n.impl.InterpolatorOps

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
  val strict = InterpolatorOps.strict
  val tolerant = InterpolatorOps.tolerant
  val default = strict
}
