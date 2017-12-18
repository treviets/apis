package net.cd.extern.xmpp.openfire.impl.sections;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * @author bill lee 
 * @version 12012017:161610 
 */
@Component
public class CdXMPPMessageSection extends CdXMPPBaseSection {
	/**
	 * Send a broadcast message
	 * @return
	 */
	public boolean sendBroadcastMessage(String message) {
		String url = "/messages/users";
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><message><body>"+message+"</body></message>";
		HttpEntity<String> entity = new HttpEntity<String>(xml, createJsonHeaderWithAuthorization());

		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> responseEntity = restTemplate.exchange(baseurl + url, HttpMethod.POST, entity, Map.class);
		return responseEntity.getStatusCode().equals(HttpStatus.CREATED);
	}

}
