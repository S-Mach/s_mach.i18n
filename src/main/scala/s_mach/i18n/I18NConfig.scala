package s_mach.i18n

import java.util.Locale

case class I18NConfig(
  locale: Locale,
  messages: Messages,
  choices: Choices,
  interpolator: Interpolator
)