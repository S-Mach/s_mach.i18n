package s_mach.i18n.test

import java.util.Locale

import org.scalatest.{Matchers, FlatSpec}
import s_mach.i18n._

class UTF8MessagesTest extends FlatSpec with Matchers {
  "UTF8Messages" should "read messages from default resource files when no locale specific file is present" in {
    implicit val locale = Locale.US
    val messages = UTF8Messages()
    messages.literals("m_true") should equal("true")
    messages.literals("m_false") should equal("false")
    // extra key found in extra messages.txt (UTF8Messages should concat same named files)
    messages.literals("test.key") should equal("testvalue")
  }

  "UTF8Messages" should "concat same named message files located in different jars" in {
    implicit val locale = Locale.US
    val messages = UTF8Messages()
    messages.literals("m_true") should equal("true")
    // extra key found in test messages.txt (UTF8Messages should concat same named files)
    messages.literals("test.key") should equal("testvalue")
  }

  "UTF8Messages" should "replace messages in base messages file with locale specific file" in {
    implicit val locale = Locale.FRENCH
    // should replace messages read from messages.txt with those in messages_fr.txt
    val messages = UTF8Messages()
    messages.literals("m_true") should equal("vrai")
    messages.literals("m_false") should equal("faux")
  }

  "UTF8Messages" should "still concat same named message files located in different jars when using a specific locale" in {
    implicit val locale = Locale.FRENCH
    val messages = UTF8Messages()
    // extra key found in extra messages.txt (UTF8Messages should concat same named files)
    messages.literals("test.key") should equal("testvalue")
  }

  "UTF8Messages" should "parse message value into parts based on MessageFormat format" in {
    implicit val locale = Locale.getDefault
    val messages = UTF8Messages()

    messages.interpolations("fmt.test1.key") should equal {
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
    messages.interpolations("fmt.test2.key") should equal {
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

  "UTF8Messages" should "parse choices and format them correctly for default" in {
    implicit val locale = Locale.getDefault
    val messages = UTF8Messages()
    messages.choices("fmt.choice.key")(0) should equal("There are no apples.")
    messages.choices("fmt.choice.key")(1) should equal("There is one apple.")
    messages.choices("fmt.choice.key")(2) should equal("There are 2 apples.")
  }

  "UTF8Messages" should "parse choices and format them correctly for FR" in {
    implicit val locale = Locale.FRENCH
    val messages = UTF8Messages()
    messages.choices("fmt.choice.key")(0) should equal("Il n'y a pas de pommes.")
    messages.choices("fmt.choice.key")(1) should equal("Il y a une pomme.")
    messages.choices("fmt.choice.key")(2) should equal("Il y a 2 pommes.")
  }

}
