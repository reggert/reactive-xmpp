package io.github.reggert.reactivexmpp.config

final class PortNumber private(val toInt : Int) extends AnyVal 

object PortNumber {
	val MinValue = 0
	val MaxValue = 0xffff
	
	def apply(value : Int) : PortNumber = {
		require(value >= MinValue, s"$value < $MinValue")
		require(value <= MaxValue, s"$value > $MaxValue")
		new PortNumber(value)
	}
	
	def validate(value : Int) : Option[PortNumber] = value match {
		case n if n < MinValue => None
		case n if n > MaxValue => None
		case _ => Some(PortNumber(value))
	}
}