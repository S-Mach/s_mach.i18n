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
       ;it1i ,,,:::;;;::1tti      s_mach.i8n
         .t1i .,::;;; ;1tt        Copyright (c) 2016 S-Mach, Inc.
         Lft11ii;::;ii1tfL:       Author: lance.gatlin@gmail.com
          .L1 1tt1ttt,,Li
            ...1LLLL...
*/
package s_mach.i8n

/**
 * A type-class for converting an instance of a type to an internationalized string
 * (generally based on locale)
 */
trait I8N[A] {
  def i8n(a: A)(implicit t: I8NTranslator) : I8NString
}

object I8N {
  def apply[A](f: (A,I8NTranslator) => String) : I8N[A] =
    new I8N[A] {
      def i8n(a: A)(implicit t: I8NTranslator) = I8NString(f(a,t))
    }
}

// how to print currency, date and quantities varies by language
