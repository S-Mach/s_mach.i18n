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

import java.util.Locale

import s_mach.i18n.impl.DefaultUTF8Messages

/**
  * An object for constructing Messages based on Java-style UTF8
  * MessageFormat resource bundles
  */
object UTF8Messages {
  /**
    * Create a Messages instance that reads all message files that match
    * the file name and extension from all jar files on the classpath. Message files
    * that match the supplied locale are concatenated and form the first tier of
    * messages. Message files that have no locale are concatenated and form the
    * backup tier. When a key is selected, the first tier is used. If the key is
    * missing from the first tier, the backup tier is used. Note: message files
    * on the same tier should never have the same key. It is undefined which
    * value will be selected if the same key appears in more than one file in a tier.
    *
    * Example:
    *
    * Files in jar1 "conf/":
    * messages.txt
    * messages_fr.txt
    * messages_us.txt
    *
    * Files in jar2 "conf/":
    * messages.txt
    * messages_us.txt
    *
    * For locale US,
    *   First tier:
    *     jar1:conf/messages_us.txt
    *     jar2:conf/messages_us.txt
    *   Backup tier:
    *     jar1:conf/messages.txt
    *     jar2:conf/messages.txt
    *
    * For locale FR,
    *   First tier:
    *     jar1:conf/messages_fr.txt
    *   Backup tier:
    *     jar1:conf/messages.txt
    *     jar2:conf/messages.txt
    *
    * @param locale the locale used to select messages for the first tier
    * @param fileBaseDir the base resource directory to select message files from.
    *                    Note: this must not be empty, currently a bug in the class
    *                    loader only allows loading multiple resources when they are
    *                    located in a sub-directory.
    * @param fileBaseName the base file name for message files
    * @param fileExt the file extension for message files
    * @return messages that returns keys from the first tier or if the key is not present
    *         in the first tier, from the backup tier.
    */
  def apply(
    locale: Locale,
    fileBaseDir: String = "conf",
    fileBaseName: String = "messages",
    fileExt: String = "txt"
  ) : Messages = DefaultUTF8Messages(
    locale = locale,
    fileBaseDir = fileBaseDir,
    fileBaseName = fileBaseName,
    fileExt = fileExt
  )
}
