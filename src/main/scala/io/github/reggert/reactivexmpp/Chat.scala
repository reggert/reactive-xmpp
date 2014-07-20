package io.github.reggert.reactivexmpp

trait Chat {
	def sendMessage(text : String) : Unit
}