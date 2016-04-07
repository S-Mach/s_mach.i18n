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

/**
 * A type-class for converting an instance of a type to an internationalized string
 * (generally based on locale)
 */
trait I18N[A] {
  def apply(a: A)(implicit cfg: I18NConfig) : I18NString
}

object I18N {
  def apply[A](f: I18NConfig => A => I18NString) : I18N[A] =
    new I18N[A] {
      def apply(a: A)(implicit cfg:I18NConfig) = I18NString(f(cfg)(a))
    }

  object BuiltInImplicits extends BuiltInImplicits
  trait BuiltInImplicits {
    implicit val i18n_Boolean =
      I18N[Boolean] { implicit cfg => cfg.stdI18N.i18n }

    implicit val i18n_Byte =
      I18N[Byte] { implicit cfg => cfg.stdI18N.i18n }

    implicit val i18n_Short =
      I18N[Short] { implicit cfg => cfg.stdI18N.i18n }

    implicit val i18n_Int =
      I18N[Int] { implicit cfg => cfg.stdI18N.i18n }

    implicit val i18n_Long =
      I18N[Long] { implicit cfg => cfg.stdI18N.i18n }

    implicit val i18n_Float =
      I18N[Float] { implicit cfg => cfg.stdI18N.i18n }

    implicit val i18n_Double =
      I18N[Double] { implicit cfg => cfg.stdI18N.i18n }

    implicit val i18n_BigInt =
      I18N[BigInt] { implicit cfg => cfg.stdI18N.i18n }

    implicit val i18n_BigDecimal =
      I18N[BigDecimal] { implicit cfg => cfg.stdI18N.i18n }

    // Note: I18N[String] and I18N[Char] are intentionally not declared
    // to prevent accidentally converting a String/Char to I18NString without
    // custom internationalization. To cast a String to I18NString use
    // String.asI18N. To promote Char, use Char.toI18N

    implicit val i18n_I18NString =
      I18N[I18NString] { cfg => a => a }

  }
}
