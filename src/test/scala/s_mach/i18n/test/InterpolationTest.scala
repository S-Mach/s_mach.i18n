package s_mach.i18n.test

import org.scalatest.{Matchers, FlatSpec}
import s_mach.i18n._
import s_mach.i18n.Interpolation.{Arg, Literal}

class InterpolationTest extends FlatSpec with Matchers {
  implicit val m = Messages()
  implicit val c = Choices()

  val parts1 = List(
    Literal("hello "),
    Arg(0),
    Literal(" test "),
    Arg(1),
    Literal(" {2}")
  )

  val parts2 = List(
    Literal("When "),
    Arg(1),
    Literal(" on "),
    Arg(1),
    Literal(", there will be "),
    Arg(2),
    Literal(" on moon "),
    Arg(0)
  )

  "I18NOps.interpolate" should "assemble literals and replace in order arguments correctly" in {
    parts1.interpolate("1".i18n,"2".i18n) should equal("hello 1 test 2 {2}")
  }

  "I18NOps.interpolate" should "assemble literals and replace repeated or out of order arguments correctly" in {
    parts2.interpolate("1".i18n,"2".i18n,"3".i18n) should equal("When 2 on 2, there will be 3 on moon 1")
  }

  "I18NOps.interpolate" should "ignore extra arguments" in {
    parts1.interpolate("1".i18n,"2".i18n,"3".i18n) should equal("hello 1 test 2 {2}")
  }

  "I18NOps.interpolate" should "replace argument with 'null' if missing by default" in {
    parts1.interpolate("1".i18n) should equal("hello 1 test null {2}")
  }

  "I18NOps.interpolate" should "allow custom handling of missing args" in {
    implicit val h = MissingArgHandler { i => throw new RuntimeException(s"Missing argument $i")}
    an[RuntimeException] should be thrownBy parts1.interpolate("1".i18n)
  }
}
