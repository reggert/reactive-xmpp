package io.github.reggert.reactivexmpp.config

import javax.security.auth.callback.CallbackHandler
import javax.net.SocketFactory

final case class ConnectionParameters(
		serverAddress : String,
		serverPort : PortNumber = PortNumber(5222),
		serviceName : Option[String] = None,
		proxy : Option[ProxyParameters] = None,
		autoReconnect : Boolean = true,
		tlsSecurity : SecurityMode.Value = SecurityMode.Enabled 
	)
