package io.github.reggert.reactivexmpp.internal

import scala.language.postfixOps
import org.jivesoftware.smack.ConnectionConfiguration
import io.github.reggert.reactivexmpp.config.ConnectionParameters
import io.github.reggert.reactivexmpp.config.LoginCredentials
import org.jivesoftware.smack.proxy.ProxyInfo
import io.github.reggert.reactivexmpp.config.ProxyParameters
import org.jivesoftware.smack.proxy.ProxyInfo.{ProxyType => JiveProxyType}
import io.github.reggert.reactivexmpp.config.ProxyType
import org.jivesoftware.smack.ConnectionConfiguration.{SecurityMode => JiveSecurityMode}
import io.github.reggert.reactivexmpp.config.SecurityMode
import org.jivesoftware.smack.tcp.XMPPTCPConnection
import org.jivesoftware.smack.ConnectionListener
import io.github.reggert.reactivexmpp.event.ConnectionEvent
import rx.lang.scala.Subject

class InternalXMPPAgent(connectionParameters : ConnectionParameters, loginCredentials : LoginCredentials, resource : String) 
{
	private def convertProxyType(proxyType : ProxyType.Value) : JiveProxyType = proxyType match {
		case ProxyType.HTTP => JiveProxyType.HTTP
		case ProxyType.SOCKS4 => JiveProxyType.SOCKS4
		case ProxyType.SOCKS5 => JiveProxyType.SOCKS5
	} 
	
	private def convertSecurityMode(tlsSecurity : SecurityMode.Value) : JiveSecurityMode = tlsSecurity match {
		case SecurityMode.Disabled => JiveSecurityMode.disabled
		case SecurityMode.Enabled => JiveSecurityMode.enabled
		case SecurityMode.Required => JiveSecurityMode.required
	}
	
	private val connectionConfiguration = {
		import connectionParameters._
		val proxyInfo = proxy map {
			case ProxyParameters(proxyType, proxyAddress, proxyPort, proxyCredentials) =>
				new ProxyInfo(
						convertProxyType(proxyType), 
						proxyAddress, 
						proxyPort.toInt, 
						proxyCredentials map {_.username} orNull, 
						proxyCredentials map {_.password} orNull
					)
		} getOrElse {ProxyInfo.forNoProxy}
		val config = new ConnectionConfiguration(serverAddress, serverPort.toInt, serviceName getOrElse serverAddress, proxyInfo)
		config.setReconnectionAllowed(autoReconnect)
		config.setSecurityMode(convertSecurityMode(tlsSecurity))
		// TODO: add other settings
		config
	}
	
	private val connection = new XMPPTCPConnection(connectionConfiguration)
	
	private val connectionSubject = Subject[ConnectionEvent]
	connection.addConnectionListener(ConnectionListenerAdapter(connectionSubject))
	
	connection.connect()
	connection.login(loginCredentials.username, loginCredentials.password, resource)
	
	
}