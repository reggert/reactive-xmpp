package io.github.reggert.reactivexmpp.config

object SecurityMode extends Enumeration
{
	val Required, Enabled, Disabled = Value
	
	def default = Enabled
}