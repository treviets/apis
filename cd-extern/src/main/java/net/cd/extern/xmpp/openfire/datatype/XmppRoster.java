package net.cd.extern.xmpp.openfire.datatype;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Vincent
 * @version 11272017:162237
 */
@XmlRootElement(name = "rosterItem")
public class XmppRoster {
	/**
	 * Optional No The JID of the roster item
	 */
	private String jid;
	/**
	 * Optional Yes The nickname for the user when used in this roster
	 */
	private String nickname;
	/**
	 * Optional Yes The subscription type Possible numeric values are: -1 (remove),
	 * 0 (none), 1 (to), 2 (from), 3 (both)
	 */
	private int subscriptionType = 3;
	/**
	 * Optional No A list of groups to organize roster entries under (e.g. friends,
	 * co-workers, etc.)
	 */
	private List<String> groups;

	public String getJid() {
		return jid;
	}

	public void setJid(String jid) {
		this.jid = jid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(int subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	@XmlElementWrapper(name = "groups")
	@XmlElements(value = { @XmlElement(name = "group", type = String.class) })
	public List<String> getGroups() {
		return groups;
	}

	public void setGroups(List<String> groups) {
		this.groups = groups;
	}

}
