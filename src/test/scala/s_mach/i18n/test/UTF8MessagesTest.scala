package s_mach.i18n.test

import java.util.Locale

import org.scalatest.{Matchers, FlatSpec}
import s_mach.i18n._

class UTF8MessagesTest extends FlatSpec with Matchers {
  "UTF8Messages" should "read messages from default resource files when no locale specific file is present" in {
    implicit val locale = Locale.US
    val messages = UTF8Messages()
    messages("true") should equal("true")
    messages("false") should equal("false")
    // extra key found in extra messages.txt (UTF8Messages should concat same named files)
    messages("test.key") should equal("testvalue")
  }

  "UTF8Messages" should "concat same named message files located in different jars" in {
    implicit val locale = Locale.US
    val messages = UTF8Messages()
    messages("true") should equal("true")
    // extra key found in test messages.txt (UTF8Messages should concat same named files)
    messages("test.key") should equal("testvalue")
  }

  "UTF8Messages" should "replace messages in base messages file with locale specific file" in {
    implicit val locale = Locale.FRENCH
    // should replace messages read from messages.txt with those in messages_fr.txt
    val messages = UTF8Messages()
    messages("true") should equal("vrai")
    messages("false") should equal("faux")
  }

  "UTF8Messages" should "still concat same named message files located in different jars when using a specific locale" in {
    implicit val locale = Locale.FRENCH
    val messages = UTF8Messages()
    // extra key found in extra messages.txt (UTF8Messages should concat same named files)
    messages("test.key") should equal("testvalue")
  }
}
