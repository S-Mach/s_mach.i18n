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

object Implicits {
  /* UOhrCDet suffix added to prevent shadowing issues */

  implicit class StringPML_UOhrCDet(val self: String) extends AnyVal {
    def m : MessageBuilder = MessageBuilder(Symbol(self))
    def m0 : MessageLiteral = MessageLiteral(Symbol(self))
    def literal : MessageLiteral = MessageLiteral(Symbol(self))
    def choice : MessageChoice = MessageChoice(Symbol(self))
  }

  implicit class SymbolPML_UOhrCDet(val self: Symbol) extends AnyVal {
    def m : MessageBuilder = MessageBuilder(self)
    def m0 : MessageLiteral = MessageLiteral(self)
    def literal : MessageLiteral = MessageLiteral(self)
    def choice : MessageChoice = MessageChoice(self)
  }

  implicit class MessagesPML_UOhrCDet(val self: Messages) extends AnyVal {
    def orElse(other: Messages) : Messages =
      Messages.orElse(self,other)
  }
}
