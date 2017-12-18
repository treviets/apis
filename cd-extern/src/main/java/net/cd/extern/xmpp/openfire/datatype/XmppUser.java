package net.cd.extern.xmpp.openfire.datatype;

import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Vincent
 * @version 11212017:163014
 */
@XmlRootElement(name="user")
public class XmppUser {
	private String username;
	private String name;
	private String email;
	private String password;
	private Map<String, Object> properties;

	public XmppUser() {super();}

	public XmppUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "username:"+username+"  name:"+name;
	}

	
}
