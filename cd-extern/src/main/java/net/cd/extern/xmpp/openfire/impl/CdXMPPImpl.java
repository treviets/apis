package net.cd.extern.xmpp.openfire.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.cd.extern.xmpp.openfire.CdXMPPInterface;
import net.cd.extern.xmpp.openfire.datatype.XmppGroup;
import net.cd.extern.xmpp.openfire.datatype.XmppRoster;
import net.cd.extern.xmpp.openfire.datatype.XmppUser;
import net.cd.extern.xmpp.openfire.impl.sections.CdXMPPGroupSection;
import net.cd.extern.xmpp.openfire.impl.sections.CdXMPPMessageSection;
import net.cd.extern.xmpp.openfire.impl.sections.CdXMPPUserSection;

@Component
public class CdXMPPImpl implements CdXMPPInterface {
	@Autowired
	private CdXMPPUserSection userService;
	@Autowired
	private CdXMPPGroupSection groupService;
	@Autowired
	private CdXMPPMessageSection messageService;

	@Override
	public List<XmppUser> retrieveUsers(String search, String propertyKey, Object propertyValue) {
		return userService.retrieveUsers(search, propertyKey, propertyValue);
	}
	
	@Override
	public XmppUser retrieveUser(String username) {
		return userService.retrieveUser(username);
	}
	
	@Override
	public boolean createUser(XmppUser user) {
		return userService.createUser(user);
	}
	
	@Override
	public boolean deleteUser(String username) {
		return userService.deleteUser(username);
	}
	
	@Override
	public boolean updateUser(XmppUser user) {
		return userService.updateUser(user);
	}

	@Override
	public List<String> retrieveUserGroups(String username) {
		return userService.retrieveUserGroups(username);
	}

	@Override
	public boolean addUserToGroup(String username, String groupName) {
		return userService.addUserToGroup(username, groupName);
	}

	@Override
	public boolean deleteUserFromGroup(String username, String groupName) {
		return userService.deleteUserFromGroup(username, groupName);
	}

	@Override
	public boolean lockoutUser(String username) {
		return userService.lockoutUser(username);
	}

	@Override
	public boolean unlockUser(String username) {
		return userService.unlockUser(username);
	}

	@Override
	public List<XmppRoster> retrieveUserRoster(String username) {
		return userService.retrieveUserRoster(username);
	}

	@Override
	public boolean createUserRoster(String username, XmppRoster roster) {
		return userService.createUserRoster(username, roster);
	}

	@Override
	public boolean deleteUserRoster(String username, String jid) {
		return userService.deleteUserRoster(username, jid);
	}

	@Override
	public boolean updateUserRoster(String username, XmppRoster roster) {
		return userService.updateUserRoster(username, roster);
	}

	@Override
	public List<XmppGroup> retrieveGroups() {
		return groupService.retrieveGroups();
	}

	@Override
	public XmppGroup retrieveGroup(String groupName) {
		return groupService.retrieveGroup(groupName);
	}

	@Override
	public boolean createGroup(XmppGroup group) {
		return groupService.createGroup(group);
	}

	@Override
	public boolean deleteGroup(String groupName) {
		return groupService.deleteGroup(groupName);
	}

	@Override
	public boolean updateGroup(XmppGroup group) {
		return groupService.updateGroup(group);
	}

	@Override
	public boolean sendBroadcastMessage(String message) {
		return messageService.sendBroadcastMessage(message);
	}

}
