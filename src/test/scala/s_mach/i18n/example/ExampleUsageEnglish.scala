package s_mach.i18n.example

object ExampleUsageEnglish {

import java.util.Locale
import s_mach.i18n._
import s_mach.i18n.messages._

// Uses UTF8Messages by default
implicit val i18ncfg = I18NConfig(Locale.ENGLISH)

// Create a message with the key m_test that accepts 2 arguments, an Int and an I18NString
// Note: this is sugar for Message2[Int,I18NString]('m_test)
val m_test : Message2[Int,I18NString] = 'm_test.m[Int,I18NString]

// Using i18ncfg, resolve the message key to a message format and interpolate the arguments
// Note: the Int argument is automatically converted to I18NString by invoking the
// I18N[Int] type-class
val test_message_lookup : I18NString = m_test(1,"test".asI18N)

// Note: the Double argument is automatically converted to I18NString by invoking the
// I18N[Double] type-class
val test_i18n_str : I18NString = i18n"interpolate some arguments $test_message_lookup ${25.0}"

}
