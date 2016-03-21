///*
//                    ,i::,
//               :;;;;;;;
//              ;:,,::;.
//            1ft1;::;1tL
//              t1;::;1,
//               :;::;               _____       __  ___              __
//          fCLff ;:: tfLLC         / ___/      /  |/  /____ _ _____ / /_
//         CLft11 :,, i1tffLi       \__ \ ____ / /|_/ // __ `// ___// __ \
//         1t1i   .;;   .1tf       ___/ //___// /  / // /_/ // /__ / / / /
//       CLt1i    :,:    .1tfL.   /____/     /_/  /_/ \__,_/ \___//_/ /_/
//       Lft1,:;:       , 1tfL:
//       ;it1i ,,,:::;;;::1tti      s_mach.i8n
//         .t1i .,::;;; ;1tt        Copyright (c) 2016 S-Mach, Inc.
//         Lft11ii;::;ii1tfL:       Author: lance.gatlin@gmail.com
//          .L1 1tt1ttt,,Li
//            ...1LLLL...
//*/
//package s_mach.i8n
//
//import java.util.Locale
//
//import s_mach.i8n.impl.NoopI8NTranslator
//
//trait I8NTranslator {
//  /** @return Local associated with this */
//  def locale: Locale
//
//  /*
//    Note: Scala custom string interpolation using StringContext parses
//    the supplied string into a sequence of string parts interspersed with
//    the arguments supplied in the interpolation. To avoid having to adopt
//    some kind printf-like interpolation convention, this convention is
//    propagated here.
//  */
//
//  /**
//   * Internationalize a string parsed in parts/args by "translating" (as
//   * defined by the implementation)
//   * @param parts parts of the original string
//   * @param args already i8n'd args substituted between parts. Note: extra
//   *             args are ignored.
//   * @return I8NString derived from parts interpolated with args
//   */
//  def translate(parts: Seq[String], args: I8NString*) : I8NString
//
//  /**
//   * Internalize a whole string by "translating" the string (as defined by the
//   * implementation)
//   * @param value string to translate
//   * @return I8NString derived from value
//   */
//  def translate(value: String) : I8NString
//
//  /** Internal key type */
//  type MessageKey
//  def mkKey(parts: Seq[String]) : MessageKey
//  def mkKey(value: String) : MessageKey
//  def findByKey(key: MessageKey, args: I8NString*) : I8NString
//
//  final def findByParts(parts: Seq[String], args: I8NString*) : String =
//    findByKey(mkKey(parts),args:_*)
//
//  final def findByValue(value: String, args: I8NString*) : String =
//    findByKey(mkKey(value),args:_*)
//}
//
//object I8NTranslator {
//  def noop(locale: Locale) : I8NTranslator = new NoopI8NTranslator(locale)
//  val defaultI8NTranslator = I8NTranslator.noop(Locale.getDefault)
//
//  object Implicits {
//    implicit val defaultI8NTranslator = I8NTranslator.defaultI8NTranslator
//  }
//}