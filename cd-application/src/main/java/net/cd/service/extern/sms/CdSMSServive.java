package net.cd.service.extern.sms;

import net.cd.service.extern.sms.impl.CdSMSServiceImpl;
import org.springframework.http.ResponseEntity;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdSMSServive {

    CdSMSServiceImpl bind(String canonical, Long id);
    CdSMSServiceImpl setMessage(String message);
    CdSMSServiceImpl setRecipient(String recipient);
    ResponseEntity<String> send();

}
