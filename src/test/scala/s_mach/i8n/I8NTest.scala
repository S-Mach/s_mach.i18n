package s_mach.i8n

import java.util.Locale

import org.scalatest.{FlatSpec, Matchers}

class I8NTest extends FlatSpec with Matchers {
  val sym1 = 'hello
  val sym2 = 'hello_$name
  val sym3 = 'hello_$fname_$lname

//  "Symbol.apply()" should "" in {
//    sym1.msg() should equal("hello")
//  }

  "mString EN US" should "" in {
    import MessageFor.Implicits._
    val name = "Lance"
    val qty = 10000.1

    m"hello ${name.i8n} test ${qty.i8n}" should equal("hello Lance test 10,000.1")
  }

  "mString FR" should "" in {
    implicit val mr = MessageFor.noop(Locale.FRENCH)
    val name = "Lance"
    val qty = 10000.1

    // Note: not a space between '10' and '000' below
    m"hello ${name.i8n} test ${qty.i8n}" should equal("hello Lance test 10 000,1")
  }

//  "Symbol.apply(arg1,arg2)" should "" in {
//    sym3 << ("Lance","Gatlin") should equal("hello Lance Gatlin")
//  }
}
