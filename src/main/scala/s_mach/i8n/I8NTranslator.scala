package s_mach.i18n

import java.util.Locale

import s_mach.i18n.impl.DefaultTranslator

/**
 * A trait for a implicit config instance that allows
 * internationalizing strings.
 */
trait i18nTranslator {
  /** @return Local associated with this translator */
  def locale: Locale

  /*
    Note: Scala custom string interpolation using StringContext parses
    the supplied string into a sequence of string parts interspersed with
    the arguments supplied in the interpolation. To avoid having to adopt
    some kind printf-like interpolation convention, this convention is
    propagated here. For further details see:
    http://docs.scala-lang.org/overviews/core/string-interpolation.html
  */

  /**
   * Internationalize a string parsed in parts/args by "translating" (as
   * defined by the implementation).
   *
   * Typical implementations will build a lookup key based on parts and
   * use that key to lookup a translated message in a message file. The
   * arguments would then be interpolated into the message using an
   * implementation defined format.
   *
   * The default implementation does nothing other than reassemble the
   * string from parts and args.
   *
   * @param parts parts of the original string
   * @param args already i18n'd args substituted between parts. Note: extra
   *             args are ignored.
   * @return i18nString derived from parts interpolated with args
   */
  def translate(parts: Seq[String], args: i18nString*) : i18nString

  /**
   * Internalize a whole string by "translating" the string (as defined by the
   * implementation).
   *
   * Typical implementations will use value as a lookup key to lookup a
   * translated message in a message file.
   *
   * @param value string to translate
   * @return i18nString derived from value
   */
  def translate(value: String) : i18nString
}

object i18nTranslator {
  def apply(locale: Locale) : i18nTranslator = new DefaultTranslator(locale)
  val defaulti18nTranslator = apply(Locale.getDefault)
  object Implicits {
    implicit val defaulti18nTranslator = i18nTranslator.defaulti18nTranslator
  }
}
