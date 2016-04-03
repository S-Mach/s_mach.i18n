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

trait Messages {
  def keys: Iterable[String]
  def contains(key: String) : Boolean
  def get(key: String, args: I18NString*) : Option[I18NString]
  def apply(key: String, args: I18NString*) : I18NString
}

object Messages {
  def apply(
    messages: (String,Seq[String])*
  ) : Messages = {
    val _messages = messages
    new Messages {
      val messages = _messages.toMap

      def keys = messages.keys
      def contains(key: String) = messages.contains(key)
      def get(key: String, args: I18NString*) =
        messages.get(key).map(parts => mkI18NString(parts,args:_*))

      def apply(key: String, args: I18NString*) =
        mkI18NString(messages(key),args:_*)

      def mkI18NString(parts: Seq[String], args: I18NString*) = {
        I18NString(
          StringContext(parts:_*).raw(args:_*)
        )
      }

      override def toString = s"Messages(keys=${messages.keys.mkString(",")})"
    }
  }
}
