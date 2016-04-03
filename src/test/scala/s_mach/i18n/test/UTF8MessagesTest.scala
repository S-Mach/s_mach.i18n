package s_mach.i18n.test

import java.util.Locale

import org.scalatest.{Matchers, FlatSpec}
import s_mach.i18n._
import Interpolation._

class UTF8MessagesTest extends FlatSpec with Matchers {
  "UTF8Messages" should "read messages from default resource files when no locale specific file is present" in {
    implicit val locale = Locale.US
    val messages = UTF8Messages()
    messages("m_true") should equal(List(Literal("true")))
    messages("m_false") should equal(List(Literal("false")))
    // extra key found in extra messages.txt (UTF8Messages should concat same named files)
    messages("test.key") should equal(List(Literal("testvalue")))
  }

  "UTF8Messages" should "concat same named message files located in different jars" in {
    implicit val locale = Locale.US
    val messages = UTF8Messages()
    messages("m_true") should equal(List(Literal("true")))
    // extra key found in test messages.txt (UTF8Messages should concat same named files)
    messages("test.key") should equal(List(Literal("testvalue")))
  }

  "UTF8Messages" should "replace messages in base messages file with locale specific file" in {
    implicit val locale = Locale.FRENCH
    // should replace messages read from messages.txt with those in messages_fr.txt
    val messages = UTF8Messages()
    messages("m_true") should equal(List(Literal("vrai")))
    messages("m_false") should equal(List(Literal("faux")))
  }

  "UTF8Messages" should "still concat same named message files located in different jars when using a specific locale" in {
    implicit val locale = Locale.FRENCH
    val messages = UTF8Messages()
    // extra key found in extra messages.txt (UTF8Messages should concat same named files)
    messages("test.key") should equal(List(Literal("testvalue")))
  }

  "UTF8Messages" should "parse message value into parts based on MessageFormat format" in {
    implicit val locale = Locale.getDefault
    val messages = UTF8Messages()

    messages("fmt.test1.key") should equal {
      import Interpolation._
      List(
        Literal("hello "),
        Arg(0),
        Literal(" test "),
        Arg(1),
        Literal(" {2}")
      )
    }
  }

  "UTF8Messages" should "ignore any kind of specialized formatting in message value MessageFormat and just return parts" in {
    implicit val locale = Locale.getDefault
    val messages = UTF8Messages()
    messages("fmt.test2.key") should equal {
      import Interpolation._
      List(
        Literal("When "),
        Arg(1),
        Literal(" on "),
        Arg(1),
        Literal(", there will be "),
        Arg(2),
        Literal(" on moon "),
        Arg(0)
      )
    }
  }

}
