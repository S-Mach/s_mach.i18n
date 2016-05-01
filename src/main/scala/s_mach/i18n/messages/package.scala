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

package object messages {
  /* UOhrCDet suffix added to prevent shadowing issues */

  implicit class StringPML_UOhrCDet(val self: String) extends AnyVal {
    /** Create a message builder with the key set to this string */
    def m : MessageBuilder = MessageBuilder(Symbol(self))
    /** Create a message literal with the key set to this string */
    def literal : MessageLiteral = MessageLiteral(Symbol(self))
    /** Alias for literal */
    def m0 : MessageLiteral = MessageLiteral(Symbol(self))
    /** Create a message choice with the key set to this string */
    def choice : MessageChoice = MessageChoice(Symbol(self))
  }

  implicit class SymbolPML_UOhrCDet(val self: Symbol) extends AnyVal {
    /** Create a message builder with the key set to this symbol */
    def m : MessageBuilder = MessageBuilder(self)
    /** Create a message literal with the key set to this symbol */
    def literal : MessageLiteral = MessageLiteral(self)
    /** Alias for literal */
    def m0 : MessageLiteral = MessageLiteral(self)
    /** Create a message choice with the key set to this symbol */
    def choice : MessageChoice = MessageChoice(self)
  }

  implicit class MessagesPML_UOhrCDet(val self: Messages) extends AnyVal {
    /** @return a Messages that uses other as a backup if self does is missing a key */
    def orElse(other: Messages) : Messages =
      Messages.orElse(self,other)
  }
}
