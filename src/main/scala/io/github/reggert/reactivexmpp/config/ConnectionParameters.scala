package io.github.reggert.reactivexmpp.config

import javax.security.auth.callback.CallbackHandler
import javax.net.SocketFactory

final case class ConnectionParameters(
		serviceName : Option[String],
		serverAddress : Option[String],
		serverPort : Option[PortNumber],
		proxy : Option[ProxyParameters] = None,
		autoReconnect : Boolean = true,
		tlsSecurity : SecurityMode.Value = SecurityMode.Enabled 
	)
