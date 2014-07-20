package io.github.reggert.reactivexmpp

import io.github.reggert.reactivexmpp.config.ConnectionParameters
import io.github.reggert.reactivexmpp.config.LoginCredentials
import rx.lang.scala.Observable
import io.github.reggert.reactivexmpp.event.ConnectionEvent

trait XMPPAgent {
	def connectionEvents : Observable[ConnectionEvent]
	def incomingSingleUserChats : Observable[SingleUserChat]
	def singleUserChatsCreated : Observable[SingleUserChat]
}


object XMPPAgent {
	def apply(connectionParameters : ConnectionParameters, loginCredentials : LoginCredentials) : XMPPAgent = ???
}