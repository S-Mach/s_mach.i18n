package s_mach.i18n.test

import java.util.Locale

import org.scalatest.{FlatSpec, Matchers}
import s_mach.i18n._
import I18NFormat._
import s_mach.i18n.messages.{I18NFormat, _}

class OrElseMessagesTest extends FlatSpec with Matchers {
  "Messages.orElse" should "fall back to second Messages if not present in first" in {
    val m1 = Messages(
      Locale.US,
      'key1 -> Literal("test1")
    )
    val m2 = Messages(
      Locale.US,
      'key2 -> Literal("test2")
    )
    val m3 = m1 orElse m2

    m3.get('key1) should equal(Some(Literal("test1")))
    m3.get('key2) should equal(Some(Literal("test2")))
    m3.get('key3) should equal(None)
  }
  "Messages.orElse" should "should contain keys from both messages" in {
    val m1 = Messages(
      Locale.US,
      'key1 -> Literal("test1")
    )
    val m2 = Messages(
      Locale.US,
      'key2 -> Literal("test2")
    )
    val m3 = m1 orElse m2

    m3.keys should contain theSameElementsAs Iterable('key1,'key2)
  }

  "Messages.orElse" should "throw an exception if locales do not match" in {
    val m1 = Messages(
      Locale.US,
      'key1 -> Literal("test1")
    )
    val m2 = Messages(
      Locale.FRANCE,
      'key2 -> Literal("test2")
    )
    an[IllegalArgumentException] should be thrownBy (m1 orElse m2)
  }
}
