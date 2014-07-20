package io.github.reggert.reactivexmpp

import org.jivesoftware.smack.util.StringUtils

final class JIDNode (val unescaped : String) extends AnyVal {
	def escaped = StringUtils.escapeNode(unescaped)
}

object JIDNode 
{
	def fromEscaped(escaped : String) : JIDNode = 
		new JIDNode(StringUtils.unescapeNode(escaped))
}

final case class BareJabberID(name : JIDNode, server : JIDNode) {
	def toFullJID(resource : JIDNode) = JabberID(name, server, resource)
}

final case class JabberID(name : JIDNode, server : JIDNode, resource : JIDNode) {
	def toBareJID = BareJabberID(name, server)
}