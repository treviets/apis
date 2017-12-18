package net.cd.extern.xmpp.openfire.impl.sections;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import net.cd.common.util.XmlUtils;
import net.cd.extern.xmpp.openfire.datatype.XmppRoster;
import net.cd.extern.xmpp.openfire.datatype.XmppUser;

/**
 * @author bill lee
 * @version 11222017:115556
 */
@Component
public class CdXMPPUserSection extends CdXMPPBaseSection {
	/**
	 * Retrieve Users
	 * 
	 * @param search
	 * @param propertyKey
	 * @param propertyValue
	 * @return
	 */
	public List<XmppUser> retrieveUsers(String search, String propertyKey, Object propertyValue) {
		String url = "/users?_r=" + new Random().nextLong();
		if (StringUtils.isNotBlank(search)) {
			url += "&search=" + search;
		}
		if (StringUtils.isNotBlank(propertyKey) && propertyValue != null) {
			url += "&propertyKey=" + propertyKey + "&propertyValue=" + propertyValue;
		}

		HttpEntity<String> entity = new HttpEntity<String>(createJsonHeaderWithAuthorization());

		ResponseEntity<String> responseEntity = restTemplate.exchange(baseurl + url, HttpMethod.GET, entity, String.class);
		List<XmppUser> result = XmlUtils.parseXmlStringToList(XmppUser.class, responseEntity.getBody());
		
		return result;
	}

	/**
	 * Retrieve User
	 * 
	 * @param username
	 * @return
	 */
	public XmppUser retrieveUser(String username) {
		String url = "/users/" + username;

		HttpEntity<String> entity = new HttpEntity<String>(createJsonHeaderWithAuthorization());
		
		ResponseEntity<XmppUser> responseEntity = restTemplate.exchange(baseurl + url, HttpMethod.GET, entity, XmppUser.class);

		return responseEntity.getBody();
	}

	/**
	 * Create User
	 * 
	 * @param user
	 * @return
	 */
	public boolean createUser(XmppUser user) {
		String url = "/users";

		HttpEntity<String> entity = new HttpEntity<String>(XmlUtils.convertToXml(user), createJsonHeaderWithAuthorization());
		try {
			@SuppressWarnings("rawtypes")
			ResponseEntity<Map> responseEntity = restTemplate.exchange(baseurl + url, HttpMethod.POST, entity, Map.class);
			return responseEntity.getStatusCode().equals(HttpStatus.CREATED);
		}catch (Exception e) {
			return false;
		}
	}

	/**
	 * Delete a user
	 * @param username
	 * @return
	 */
	public boolean deleteUser(String username) {
		String url = "/users/"+username;

		HttpEntity<String> entity = new HttpEntity<String>(createJsonHeaderWithAuthorization());

		try {
			@SuppressWarnings("rawtypes")
			ResponseEntity<Map> responseEntity = restTemplate.exchange(baseurl + url, HttpMethod.DELETE, entity, Map.class);
			return responseEntity.getStatusCode().equals(HttpStatus.OK);
		}catch (Exception e) {
			log.warn(e.getMessage());
			return false;
		}
	}
	
	/**
	 * Update a user
	 * @param username
	 * @return
	 */
	public boolean updateUser(XmppUser user) {
		String url = "/users/"+user.getUsername();

		HttpEntity<String> entity = new HttpEntity<String>(XmlUtils.convertToXml(user), createJsonHeaderWithAuthorization());

		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> responseEntity = restTemplate.exchange(baseurl + url, HttpMethod.PUT, entity, Map.class);
		return responseEntity.getStatusCode().equals(HttpStatus.OK);
	}
	
	/**
	 * Retrieve all user group names
	 * @param username
	 * @return
	 */
	public List<String> retrieveUserGroups(String username){
		String url = "/users/"+username+"/groups";
		HttpEntity<String> entity = new HttpEntity<String>(createJsonHeaderWithAuthorization());

		ResponseEntity<String> responseEntity = restTemplate.exchange(baseurl + url, HttpMethod.GET, entity, String.class);
		List<String> result = XmlUtils.parseXmlChildNodeToStringList( responseEntity.getBody(),"groupname");
		return result;
	}
	
	/**
	 * Add user to group
	 * @param username
	 * @param groupName
	 * @return
	 */
	public boolean addUserToGroup(String username, String groupName) {
		String url = "/users/"+username+"/groups/"+groupName;
		
		HttpEntity<String> entity = new HttpEntity<String>(createJsonHeaderWithAuthorization());

		ResponseEntity<String> responseEntity = restTemplate.exchange(baseurl + url, HttpMethod.POST, entity, String.class);
		return responseEntity.getStatusCode().equals(HttpStatus.CREATED);
	}
	
	/**
	 * Delete a user from a group
	 * @param username
	 * @param groupName
	 * @return
	 */
	public boolean deleteUserFromGroup(String username, String groupName) {
		String url = "/users/"+username+"/groups/"+groupName;
		
		HttpEntity<String> entity = new HttpEntity<String>(createJsonHeaderWithAuthorization());

		ResponseEntity<String> responseEntity = restTemplate.exchange(baseurl + url, HttpMethod.DELETE, entity, String.class);
		return responseEntity.getStatusCode().equals(HttpStatus.OK);
	}
	
	/**
	 * Lockout a user
	 * @param username
	 * @return
	 */
	public boolean lockoutUser(String username) {
		String url = "/lockouts/"+username;
		HttpEntity<String> entity = new HttpEntity<String>(createJsonHeaderWithAuthorization());

		ResponseEntity<String> responseEntity = restTemplate.exchange(baseurl + url, HttpMethod.POST, entity, String.class);
		return responseEntity.getStatusCode().equals(HttpStatus.CREATED);
		
	}
	
	/**
	 * Unlock a user
	 * @param username
	 * @return
	 */
	public boolean unlockUser(String username) {
		String url = "/lockouts/"+username;
		HttpEntity<String> entity = new HttpEntity<String>(createJsonHeaderWithAuthorization());

		ResponseEntity<String> responseEntity = restTemplate.exchange(baseurl + url, HttpMethod.DELETE, entity, String.class);
		return responseEntity.getStatusCode().equals(HttpStatus.OK);
		
	}
	
	/**
	 * Retrieve user roster
	 * @param username
	 * @return
	 */
	public List<XmppRoster> retrieveUserRoster(String username) {
		String url = "/users/"+username+"/roster";
		HttpEntity<String> entity = new HttpEntity<String>(createJsonHeaderWithAuthorization());

		ResponseEntity<String> responseEntity = restTemplate.exchange(baseurl + url, HttpMethod.GET, entity, String.class);
		List<XmppRoster> result = XmlUtils.parseXmlStringToList(XmppRoster.class, responseEntity.getBody());
		return result;
	}
	
	/**
	 *  Create a user roster entry
	 * @param username
	 * @param roster
	 * @return
	 */
	public boolean createUserRoster(String username, XmppRoster roster) {
		String url = "/users/"+username+"/roster";
		System.out.println(XmlUtils.convertToXml(roster));
		HttpEntity<String> entity = new HttpEntity<String>(XmlUtils.convertToXml(roster),createJsonHeaderWithAuthorization());
		try {
			ResponseEntity<String> responseEntity = restTemplate.exchange(baseurl + url, HttpMethod.POST, entity, String.class);
			return responseEntity.getStatusCode().equals(HttpStatus.CREATED);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	/**
	 * Delete a user roster entry
	 * @param username
	 * @param jid
	 * @return
	 */
	public boolean deleteUserRoster(String username, String jid) {
		String url = "/users/"+username+"/roster/"+jid;
		HttpEntity<String> entity = new HttpEntity<String>(createJsonHeaderWithAuthorization());
		
		ResponseEntity<String> responseEntity = restTemplate.exchange(baseurl + url, HttpMethod.DELETE, entity, String.class);
		return responseEntity.getStatusCode().equals(HttpStatus.OK);
	}
	
	/**
	 * Update a user roster entry
	 * @param username
	 * @return
	 */
	public boolean updateUserRoster(String username, XmppRoster roster) {
		String url = "/users/"+username+"/roster/"+roster.getJid();
		HttpEntity<String> entity = new HttpEntity<String>(XmlUtils.convertToXml(roster),createJsonHeaderWithAuthorization());
		
		ResponseEntity<String> responseEntity = restTemplate.exchange(baseurl + url, HttpMethod.PUT, entity, String.class);
		return responseEntity.getStatusCode().equals(HttpStatus.OK);
	}
	
}
