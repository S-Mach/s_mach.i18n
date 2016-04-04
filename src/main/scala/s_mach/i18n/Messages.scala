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
  trait Lookup[A] {
    def get(key: String): Option[A]
    def apply(key: String): A
  }

  def keys: Iterable[String]
  def contains(key: String): Boolean

  def literals : Lookup[String]
  def interpolations : Lookup[Seq[Interpolation]]
  def choices : Lookup[BigDecimal => String]
}

object Messages {
  val empty = apply()

  def apply(
    literals: Map[String,String] = Map.empty,
    interpolations: Map[String,Seq[Interpolation]] = Map.empty,
    choices: Map[String,BigDecimal => String] = Map.empty
  ) : Messages = {
    val keyCounts = (literals.keys ++ interpolations.keys ++ choices.keys).groupBy(k => k).mapValues(_.size)
    require(
      keyCounts.forall(_._2 == 1),
      s"Non unique keys: ${keyCounts.filter(_._2 > 1).mkString(",")}"
    )
    val _literals = literals
    val _interpolations = interpolations
    val _choices = choices
    
    new Messages {
      val literals = new Lookup[String] {
        def get(key: String) = _literals.get(key)
        def apply(key: String) = _literals(key)
      }
      val choices = new Lookup[BigDecimal => String] {
        def get(key: String) = _choices.get(key)
        def apply(key: String) = _choices(key)
      }
      val interpolations = new Lookup[Seq[Interpolation]] {
        def get(key: String) = _interpolations.get(key)
        def apply(key: String) = _interpolations(key)
      }

      val keys = _literals.keys ++ _interpolations.keys ++ _choices.keys
      def contains(key: String) = 
        _literals.contains(key) || 
        _interpolations.contains(key) || 
        _choices.contains(key)

      override def toString = s"Messages(keys=${keys.mkString(",")})"
    }
  }
}
