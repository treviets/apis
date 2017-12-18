package net.cd.extern.xmpp.openfire.datatype;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Vincent
 * @version 11252017:154502
 */
@XmlRootElement(name="group")
public class XmppGroup {
	// Parameter  Description
	/**
	 * The name of the group, Optional No
	 */
	private String name; 
	/**
	 * The description of the group, Optional No
	 */
	private String description; 
	/**
	 * A collection with current admins of the group, Optional Yes
	 */
	private List<XmppUser> admins;
	/**
	 * A collection with current members of the group, Optional Yes
	 */
	private List<XmppUser> members;
	
	public XmppGroup(){}
	
	public XmppGroup(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<XmppUser> getAdmins() {
		return admins;
	}

	public void setAdmins(List<XmppUser> admins) {
		this.admins = admins;
	}

	public List<XmppUser> getMembers() {
		return members;
	}

	public void setMembers(List<XmppUser> members) {
		this.members = members;
	}


}
