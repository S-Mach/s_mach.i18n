package s_mach.i18n.test

import org.scalatest.{Matchers, FlatSpec}
import s_mach.i18n.Messages

class MessagesTest extends FlatSpec with Matchers {
  "Messages.empty" should "be empty" in {
    Messages.empty.keys.isEmpty should be(true)
  }
}
