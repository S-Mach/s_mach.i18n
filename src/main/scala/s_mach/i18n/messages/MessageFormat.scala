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

/**
  * Format for a message that can be either a literal, an interpolation
  * or a choice
  */
sealed trait MessageFormat
object MessageFormat {
  case class Literal(value: String) extends MessageFormat

  /**
    * A message format that requires arguments
    * @param parts parts of the interpolation (either a literal or an argument)
    */
  case class Interpolation(parts: Seq[Interpolation.Part]) extends MessageFormat
  object Interpolation {
    sealed trait Part
    object Part {
      case class Literal(value: String) extends Part

      /**
        * A interpolation part that should be replaced with the argument
        * specified by index
        * @param index index of argument to select
        */
      case class StringArg(index: Int) extends Part
    }
  }

  /**
    * A message format that converts a BigDecimal to a string. Choices
    * are used to display different strings based on a quantity value.
    * @param value function to convert quantity to string
    */
  case class Choice(value: BigDecimal => String) extends MessageFormat
}