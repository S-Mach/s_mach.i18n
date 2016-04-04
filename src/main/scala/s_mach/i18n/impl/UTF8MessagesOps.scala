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
package s_mach.i18n.impl

import java.text._
import java.util.{Locale, ResourceBundle}
import s_mach.i18n._
import s_mach.string._

object UTF8MessagesOps {
  // todo: support for Choices parsed from ChoiceFormat

  private val fakeFormat = new Format {
    // Never called
    def parseObject(source: String, pos: ParsePosition) = ???
    def format(obj: scala.Any, toAppendTo: StringBuffer, pos: FieldPosition) =
      toAppendTo.append(obj.toString)
  }

  private val uniqueKey = "<>" * 12
  private val parseRegex = s"$uniqueKey([0-9]+)".r

  def apply(
    fileBaseDir: String = "conf",
    fileBaseName: String = "messages",
    fileExt: String = "txt"
  )(implicit locale: Locale) : Messages = {
    // Note: can't load multiple resources with same name without a base dir
    // See https://stackoverflow.com/questions/6730580/how-to-read-several-resource-files-with-the-same-name-from-different-jars
    require(fileBaseDir.length > 0,"Base directory must not be empty")

    val control = new UTF8ResourceBundleControl(
      fileExt = fileExt
    )
    val bundle = ResourceBundle.getBundle(s"${fileBaseDir.ensureSuffix("/")}$fileBaseName", locale, control)

    case class R(
      optLiteral: Option[String] = None,
      optInterpolation: Option[Seq[Interpolation]] = None,
      optChoice: Option[BigDecimal => String] = None
    )
    val keyToParts =
      bundle.getKeys.toStream.map { k =>
        import Interpolation._
        val raw = bundle.getString(k)
        val fmt = new MessageFormat(raw)
        val parts =
          fmt.getFormats.size match {
            case 0 => R(optLiteral = Some(raw))
            case 1 if fmt.getFormats.head.isInstanceOf[ChoiceFormat] =>
              R(optChoice = Some({ n =>
                fmt.format(
                  Array(n.underlying().doubleValue()).map(_.asInstanceOf[java.lang.Object])
                )
              }))
            case argsCount =>
              // Force all formats to simple string replacement
              val formats = Array.fill[Format](argsCount)(fakeFormat)
              fmt.setFormats(formats)
              // Inject unique key and arg number as fake args to allow
              // standardized parsing below
              val parseable = fmt.format(
                (0 until argsCount).map(i => s"$uniqueKey$i").toArray
              )
              case class M(
                start: Int,
                end: Int,
                argIdx: Int
              )
              // Parse simplified interpolation format
              val ms = parseRegex.findAllMatchIn(parseable)
                .map(m => M(m.start,m.end,m.group(1).toInt))
              // Note: impossible for ms not to match at least once since there at
              // least one arg at this point
              val builder = Seq.newBuilder[Interpolation]
              val _lastIdx =
                ms.foldLeft(0) { case (lastIdx,m) =>
                  if(lastIdx < m.start) {
                    builder += Interpolation.Literal(parseable.substring(lastIdx, m.start))
                  }
                  builder += Interpolation.Arg(m.argIdx)
                  m.end
                }
              if(_lastIdx != parseable.length) {
                builder += Interpolation.Literal(parseable.substring(_lastIdx))
              }
              R(optInterpolation = Some(builder.result()))
          }
        k -> parts
      }
    Messages(
      literals = keyToParts.collect { case (k,R(Some(literal),None,None)) =>
        (k,literal)
      }.toMap,
      interpolations = keyToParts.collect { case (k,R(None,Some(interpolation),None)) =>
        (k,interpolation)
      }.toMap,
      choices = keyToParts.collect { case (k,R(None,None,Some(choice))) =>
        (k,choice)
      }.toMap
    )
  }

}