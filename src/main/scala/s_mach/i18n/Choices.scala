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

trait Choices {
  def contains(key: String) : Boolean
  def get(key: String) : Option[BigDecimal => I18NString]
  def apply(key: String) : BigDecimal => I18NString
}

object Choices {
  def apply(choices: (String,BigDecimal => I18NString)*) : Choices = {
    val _choices = choices.toMap
    new Choices {
      val choices = _choices.toMap
      def contains(key: String) = choices.contains(key)
      def apply(key: String) = choices(key)
      def get(key: String) = choices.get(key)
    }
  }
}