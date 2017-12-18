package net.cd.extern.xmpp.openfire;

import java.util.List;

import net.cd.extern.xmpp.openfire.datatype.XmppGroup;
import net.cd.extern.xmpp.openfire.datatype.XmppRoster;
import net.cd.extern.xmpp.openfire.datatype.XmppUser;

public interface CdXMPPInterface {
	public List<XmppUser> retrieveUsers(String search, String propertyKey, Object propertyValue);

	public XmppUser retrieveUser(String username);

	public boolean createUser(XmppUser user);

	public boolean deleteUser(String username);

	public boolean updateUser(XmppUser user);
	
	public List<String> retrieveUserGroups(String username);
	
	public boolean addUserToGroup(String username, String groupName);
	
	public boolean deleteUserFromGroup(String username, String groupName);
	
	public boolean lockoutUser(String username);
	
	public boolean unlockUser(String username);
	
	public List<XmppRoster> retrieveUserRoster(String username);
	
	public boolean createUserRoster(String username, XmppRoster roster);
	
	public boolean deleteUserRoster(String username, String jid);
	
	public boolean updateUserRoster(String username, XmppRoster roster);
	
	
	
	public List<XmppGroup> retrieveGroups();
	
	public XmppGroup retrieveGroup(String groupName);
	
	public boolean createGroup(XmppGroup group);
	
	public boolean deleteGroup(String groupName);
	
	public boolean updateGroup(XmppGroup group);
	
	
	
	public boolean sendBroadcastMessage(String message);
}
