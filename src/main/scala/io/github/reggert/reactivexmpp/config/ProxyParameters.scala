package io.github.reggert.reactivexmpp.config

object ProxyType extends Enumeration {
	val HTTP, SOCKS4, SOCKS5 = Value
}

final case class ProxyParameters(
		proxyType : ProxyType.Value,
		address : String,
		port : PortNumber,
		credentials : Option[LoginCredentials]
	)
