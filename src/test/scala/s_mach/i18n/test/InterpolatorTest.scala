package s_mach.i18n.test

import org.scalatest.{Matchers, FlatSpec}
import s_mach.i18n._
import CommonTest._

class InterpolatorTest extends FlatSpec with Matchers {
  "Interpolator.strict.interpolate" should "assemble literals and replace in order arguments correctly" in {
    Interpolator.strict.interpolate(parts1,"1".asI18N,"2".asI18N) should equal("hello 1 test 2 {2}")
  }

  "Interpolator.strict.interpolate" should "assemble literals and replace repeated or out of order arguments correctly" in {
    Interpolator.strict.interpolate(parts2,"1".asI18N,"2".asI18N,"3".asI18N) should equal("When 2 on 2, there will be 3 on moon 1")
  }
  
  "Interpolator.strict.interpolate" should "throw if too many arguments are passed" in {
    an[IllegalArgumentException] should be thrownBy Interpolator.strict.interpolate(parts1,"1".asI18N,"2".asI18N,"3".asI18N)
  }

  "Interpolator.strict.interpolate" should "throw if an argument is missing" in {
    an[IllegalArgumentException] should be thrownBy Interpolator.strict.interpolate(parts1,"1".asI18N)
  }

  "Interpolator.lax.interpolate" should "ignore extra arguments" in {
    Interpolator.lax.interpolate(parts1,"1".asI18N,"2".asI18N,"3".asI18N) should equal("hello 1 test 2 {2}")
  }

  "Interpolator.lax.interpolate" should "replace missing arguments with missing arg string'" in {
    Interpolator.lax.interpolate(parts1,"1".asI18N) should equal("hello 1 test {1:null} {2}")
  }
}
