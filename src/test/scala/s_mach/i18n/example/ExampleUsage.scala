package s_mach.i18n.example

object ExampleUsage {

import java.util.Locale
import s_mach.i18n._
import s_mach.i18n.messages._

// Uses UTF8Messages by default
implicit val i18ncfg = I18NConfig(Locale.US)

// Create a message with they key m_test that accepts 2 arguments, an Int and an I18NString
val m_test = 'm_test.m[Int,I18NString]

// Using i18ncfg, resolve the message key to a message format and interpolate the arguments
val test_i18n_str = m_test(1,"test".asI18N)

i18n"interpolate some arguments $test_i18n_str ${25.0}"

}
