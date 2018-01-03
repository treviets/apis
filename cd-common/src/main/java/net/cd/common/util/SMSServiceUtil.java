package net.cd.common.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.xhtmlrenderer.simple.extend.URLUTF8Encoder;

@Service
@Scope("singleton")
public class SMSServiceUtil {

	private final String SMS_SERVICE_URL = "http://210.211.108.20:9999/onsmsapi/sendsms.jsp?param=";

	private final String SMS_SERVICE_USERNAME = "minhcanh";
	private final String SMS_SERVIVE_PASSWORD = "minhcanh#@!";
	private final String SMS_SERVICE_KEY = "c75d25ebd3556eccc16fa9678ba44a865a0ee8e1";
	private final String SMS_SENDER = "0901800016";
	private final String SMS_ID = "22252";
	public String getFullSMSServiceURL(String messageContent, String phoneReceiver) {
		String fullSMSServiceURL = SMS_SERVICE_URL+URLUTF8Encoder.encode(messageContent)+"&username="+SMS_SERVICE_USERNAME+
				"&pass="+URLUTF8Encoder.encode(SMS_SERVIVE_PASSWORD)+"&smsid="+SMS_ID+"&key="+SMS_SERVICE_KEY+"&phonesend="+phoneReceiver+"&sender="+SMS_SENDER;
		return fullSMSServiceURL;
	}
}
