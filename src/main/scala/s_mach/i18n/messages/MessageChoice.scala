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
package s_mach.i18n.messages

import s_mach.i18n._

/**
  * A message that converts a BigDecimal to a string. Choices are used
  * to display different strings based on a quantity value.
  *
  * @param key message key
  */
case class MessageChoice(
  key: Symbol
) extends Message { self =>
  def apply(
    n: BigDecimal
  )(implicit
    cfg: I18NConfig
  ) : I18NString = {
    cfg.resolver.resolveChoice(key, n)
  }
  def bind(
    n: BigDecimal
  ) : BoundMessageChoice = BoundMessageChoice(key,n)
}

case class BoundMessageChoice(
  key: Symbol,
  n: BigDecimal
) extends BoundMessage {
  def apply()(implicit cfg: I18NConfig) : I18NString =
    cfg.resolver.resolveChoice(key, n)
}
