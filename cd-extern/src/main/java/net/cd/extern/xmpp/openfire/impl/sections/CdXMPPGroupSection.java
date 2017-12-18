package net.cd.extern.xmpp.openfire.impl.sections;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import net.cd.common.util.XmlUtils;
import net.cd.extern.xmpp.openfire.datatype.XmppGroup;

/**
 * @author bill lee
 * @version 11252017:155535
 */
@Component
public class CdXMPPGroupSection extends CdXMPPBaseSection {
	
	/**
	 * Retrieve all groups
	 * 
	 * @return
	 */
	public List<XmppGroup> retrieveGroups() {
		String url = "/groups";
		HttpEntity<String> entity = new HttpEntity<String>(createJsonHeaderWithAuthorization());

		ResponseEntity<String> responseEntity = restTemplate.exchange(baseurl + url, HttpMethod.GET, entity, String.class);
		List<XmppGroup> result = XmlUtils.parseXmlStringToList(XmppGroup.class, responseEntity.getBody());
		return result;
	}
	
	/**
	 * Retrieve a groups
	 * @param groupName
	 * @return
	 */
	public XmppGroup retrieveGroup(String groupName) {
		String url = "/groups/" + groupName;

		HttpEntity<String> entity = new HttpEntity<String>(createJsonHeaderWithAuthorization());
		
		try {
			ResponseEntity<XmppGroup> responseEntity = restTemplate.exchange(baseurl + url, HttpMethod.GET, entity, XmppGroup.class);
			return responseEntity.getBody();
		}catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * Create Group
	 * 
	 * @param group
	 * @return
	 */
	public boolean createGroup(XmppGroup group) {
		String url = "/groups";

		HttpEntity<String> entity = new HttpEntity<String>(XmlUtils.convertToXml(group), createJsonHeaderWithAuthorization());

		try {
			@SuppressWarnings("rawtypes")
			ResponseEntity<Map> responseEntity = restTemplate.exchange(baseurl + url, HttpMethod.POST, entity, Map.class);
			return responseEntity.getStatusCode().equals(HttpStatus.CREATED);
		}catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Delete a Group
	 * @param groupName
	 * @return
	 */
	public boolean deleteGroup(String groupName) {
		String url = "/groups/"+groupName;

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
	 * Update a group
	 * @param group
	 * @return
	 */
	public boolean updateGroup(XmppGroup group) {
		String url = "/groups/"+group.getName();

		HttpEntity<String> entity = new HttpEntity<String>(XmlUtils.convertToXml(group), createJsonHeaderWithAuthorization());

		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> responseEntity = restTemplate.exchange(baseurl + url, HttpMethod.PUT, entity, Map.class);
		return responseEntity.getStatusCode().equals(HttpStatus.OK);
	}
	
}
