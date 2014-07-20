package io.github.reggert.reactivexmpp.event

import io.github.reggert.reactivexmpp.XMPPAgent
import scala.concurrent.duration.Duration

sealed trait ConnectionEvent

case object ConnectionEstablished extends ConnectionEvent

case object ConnectionAuthenticated extends ConnectionEvent

case object ConnectionTerminated extends ConnectionEvent

final case class ConnectionLost(e : Exception) extends ConnectionEvent

final case class WillAttemptReconnect(when : Duration) extends ConnectionEvent

case object ConnectionReestablished extends ConnectionEvent

final case class ReconnectionFailed(e : Exception) extends ConnectionEvent