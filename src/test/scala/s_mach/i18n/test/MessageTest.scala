package s_mach.i18n.test

import java.util.Locale

import org.scalatest.{Matchers, FlatSpec}
import s_mach.i18n._
import CommonTest._

class MessageTest extends FlatSpec with Matchers {
  val name = "Lance"
  val qty = 10000.1


  "I18N for EN US" should "internationalize arguments correctly using JVM default locale (EN_US)" in {
    // import this unused import to ensure no implicit shadow conflicts
    implicit val locale = Locale.US
    implicit val m = mkTestMessages()

    m_hello() should equal("hello")
    m_hello_name_qty(name.asI18N,qty) should equal("hello Lance test 10,000.1")

    m_there_are_qty_apples(0) should equal("There are no apples")
    m_there_are_qty_apples(1) should equal("There is one apple")
    m_there_are_qty_apples(2) should equal("There are 2 apples")

    m_hello_name_qty(m_there_are_qty_apples(2),qty) should equal("hello There are 2 apples test 10,000.1")

    i18n"${m_there_are_qty_apples(0)} test $qty ${name.asI18N}" should equal("There are no apples test 10,000.1 Lance")

    """i18n"${m_there_are_qty_apples(0)} test $qty ${name}"""" shouldNot compile
  }

  "I18N for FR" should "internationalize arguments correctly for custom locale" in {
    // import this unused import to ensure no implicit shadow conflicts
    import s_mach.i18n._
    implicit val locale = Locale.FRENCH
    implicit val m = mkTestMessages()

    m_hello() should equal("bonjour")
    // Note: not a space between '10' and '000' below
    m_hello_name_qty(name.asI18N,qty) should equal("bonjour Lance test 10 000,1")

    m_there_are_qty_apples(0) should equal("Il n'y a pas de pommes")
    m_there_are_qty_apples(1) should equal("Il y a une pomme")
    m_there_are_qty_apples(2) should equal("Il y a 2 pommes")

    m_hello_name_qty(m_there_are_qty_apples(2),qty) should equal("bonjour Il y a 2 pommes test 10 000,1")

    i18n"${m_there_are_qty_apples(0)} test $qty ${name.asI18N}" should equal("Il n'y a pas de pommes test 10 000,1 Lance")
  }
}
