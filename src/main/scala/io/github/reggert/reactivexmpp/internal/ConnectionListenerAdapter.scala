package io.github.reggert.reactivexmpp.internal

import scala.language.postfixOps 
import org.jivesoftware.smack.ConnectionListener
import rx.lang.scala.Subject
import io.github.reggert.reactivexmpp.event.ConnectionEvent
import org.jivesoftware.smack.XMPPConnection
import io.github.reggert.reactivexmpp.event._
import scala.concurrent.duration._

/**
 * Constructs a [[ConnectionListener]] that feeds all events to a [[Subject]].
 */
object ConnectionListenerAdapter {
	
	def apply(subject : Subject[ConnectionEvent]) = new ConnectionListener {
		
		 override def authenticated(connection : XMPPConnection): Unit = 
			 subject onNext ConnectionAuthenticated
		 
		 override def connected(connection : XMPPConnection): Unit = 
			 subject onNext ConnectionEstablished
		 
		 override def connectionClosed(): Unit = {
			 subject onNext ConnectionTerminated
			 subject.onCompleted()
		 }
		 
		 override def connectionClosedOnError(e : Exception): Unit = 
			 subject onNext ConnectionLost(e)
		 
		 override def reconnectingIn(nSeconds : Int): Unit =
			 subject onNext WillAttemptReconnect(nSeconds seconds)
		 
		 override def reconnectionFailed(e : Exception): Unit = 
			 subject onNext ReconnectionFailed(e)
 
		 override def reconnectionSuccessful(): Unit = 
			 subject onNext ConnectionReestablished
	}

}