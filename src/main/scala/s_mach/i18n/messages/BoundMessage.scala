package s_mach.i18n.messages

import s_mach.i18n.{I18NConfig, I18NString}

trait BoundMessage {
  def apply()(implicit i18ncfg:I18NConfig) : I18NString
}

object BoundMessage {
  def apply(f: I18NConfig => I18NString) : BoundMessage =
    new BoundMessage {
      def apply()(implicit i18ncfg:I18NConfig) : I18NString =
        f(i18ncfg)
    }
}
