package s_mach.i18n.impl

import s_mach.i18n.I18NString
import s_mach.i18n.messages.Interpolator
import s_mach.i18n.messages.MessageFormat.Interpolation.Part

class LaxInterpolator(missingArg: Int => String) extends Interpolator {
  override def interpolate(parts: Seq[Part], args: I18NString*): I18NString = {
    InterpolatorOps.laxInterpolate(missingArg)(parts,args:_*)
  }
  override def toString = "LaxInterpolator"
}
