/*
                    ,i::,
               :;;;;;;;
              ;:,,::;.
            1ft1;::;1tL
              t1;::;1,
               :;::;               _____       __  ___              __
          fCLff ;:: tfLLC         / ___/      /  |/  /____ _ _____ / /_
         CLft11 :,, i1tffLi       \__ \ ____ / /|_/ // __ `// ___// __ \
         1t1i   .;;   .1tf       ___/ //___// /  / // /_/ // /__ / / / /
       CLt1i    :,:    .1tfL.   /____/     /_/  /_/ \__,_/ \___//_/ /_/
       Lft1,:;:       , 1tfL:
       ;it1i ,,,:::;;;::1tti      s_mach.i18n
         .t1i .,::;;; ;1tt        Copyright (c) 2016 S-Mach, Inc.
         Lft11ii;::;ii1tfL:       Author: lance.gatlin@gmail.com
          .L1 1tt1ttt,,Li
            ...1LLLL...
*/
package s_mach.i18n

case class MessageQuantity(
  key: String
  ) {
  def throwIfMissing()(implicit c:Choices) : this.type = {
    if(c.contains(key) == false) {
      throw new IllegalArgumentException(s"Choices missing key $key")
    } else {
      this
    }
  }

  def apply[N](n: N)(implicit numeric:Numeric[N],cfg: I18NConfig) : I18NString = {
    import cfg._
    I18NString(
      choices(key)(BigDecimal(n.toString))
    )
  }
}
