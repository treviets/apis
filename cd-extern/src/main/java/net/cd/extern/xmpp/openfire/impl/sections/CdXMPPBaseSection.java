package net.cd.extern.xmpp.openfire.impl.sections;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.amazonaws.util.Base64;
import com.google.api.client.util.Lists;

import net.cd.common.util.VnJNDIUtil;

/**
 * @author bill lee
 * @version 11222017:115455
 */
public abstract class CdXMPPBaseSection {
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	RestTemplate restTemplate;

	protected String baseurl;
	protected String username;
	protected String password;

	private void init() {
		restTemplate=new RestTemplate();

		VnJNDIUtil jndiUtil = VnJNDIUtil.getInstance();
		this.baseurl = jndiUtil.getString("extern/xmpp/openfire/restapi/baseurl");
		this.username = jndiUtil.getString("extern/xmpp/openfire/restapi/username");
		this.password = jndiUtil.getString("extern/xmpp/openfire/restapi/password");
	
	}
	
	public CdXMPPBaseSection() {
		super();
		init();
	}

	protected HttpHeaders createJsonHeaderWithAuthorization() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);
		String user = Base64.encodeAsString((username+":"+password).getBytes());
		headers.add("Authorization", "Basic " + user);
		List<MediaType> acceptableMediaTypes = Lists.newArrayList();
		acceptableMediaTypes.add(MediaType.APPLICATION_XML);
		acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
		headers.setAccept(acceptableMediaTypes );
		return headers;
	}

}
