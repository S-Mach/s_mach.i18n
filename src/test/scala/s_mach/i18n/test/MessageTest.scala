package s_mach.i18n.test

import java.util.Locale

import org.scalatest.{Matchers, FlatSpec}
import s_mach.i18n._
import CommonTest._

class MessageTest extends FlatSpec with Matchers {
  val name = "Gary"
  val qty = 10000.1


  "Message0.apply" should "retrieve the message from Messages for the current locale" in {

    {
      implicit val locale = Locale.US
      implicit val m = mkTestMessages()
      m_hello() should equal("hello")
    }
    {
      implicit val locale = Locale.FRENCH
      implicit val m = mkTestMessages()
      m_hello() should equal("bonjour")
    }
  }

  "Message1.apply" should "retrieve the message from I18NConfig and interpolate arguments" in {
    {
      implicit val locale = Locale.US
      implicit val m = mkTestMessages()
      m_hello_name_qty(name.asI18N,qty) should equal("hello Gary test 10,000.1")
    }
    {
      implicit val locale = Locale.FRENCH
      implicit val m = mkTestMessages()
      m_hello_name_qty(name.asI18N,qty) should equal("bonjour Gary test 10 000,1")
    }
  }

  "Message2.apply" should "retrieve the message from I18NConfig and interpolate arguments" in {
    {
      implicit val locale = Locale.US
      implicit val m = mkTestMessages()
      m_hello_name_qty("There are 2 apples".asI18N,qty) should equal("hello There are 2 apples test 10,000.1")
    }
    {
      implicit val locale = Locale.FRENCH
      implicit val m = mkTestMessages()
      m_hello_name_qty("Il y a 2 pommes".asI18N,qty) should equal("bonjour Il y a 2 pommes test 10 000,1")
    }
  }

  "Choice.apply" should "retrieve the message from I18NConfig and choose the correct message" in {
    {
      implicit val locale = Locale.US
      implicit val m = mkTestMessages()
      m_there_are_qty_apples(0) should equal("There are no apples")
      m_there_are_qty_apples(1) should equal("There is one apple")
      m_there_are_qty_apples(2) should equal("There are 2 apples")
    }
    {
      implicit val locale = Locale.FRENCH
      implicit val m = mkTestMessages()
      m_there_are_qty_apples(0) should equal("Il n'y a pas de pommes")
      m_there_are_qty_apples(1) should equal("Il y a une pomme")
      m_there_are_qty_apples(2) should equal("Il y a 2 pommes")
    }
  }


}
