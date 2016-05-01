package s_mach.i18n.example

object ExampleUsage {

import java.util.Locale
import s_mach.i18n._
import s_mach.i18n.messages._

// Uses UTF8Messages by default
implicit val i18ncfg = I18NConfig(Locale.US)

// Create a message with the key m_test that accepts 2 arguments, an Int and an I18NString
val m_test = 'm_test.m[Int,I18NString]

// Using i18ncfg, resolve the message key to a message format and interpolate the arguments
// Note: the Int argument automatically invokes I18N[Int] to correctly format the integer for
// the current locale
val test_i18n_str = m_test(1,"test".asI18N)

// Note: the Double argument automatically invokes I18N[Double] to correctly for the double for
// for the current locale
i18n"interpolate some arguments $test_i18n_str ${25.0}"

}
