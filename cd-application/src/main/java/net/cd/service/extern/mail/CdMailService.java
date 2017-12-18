package net.cd.service.extern.mail;

import net.cd.service.extern.mail.mail.CdMailServiceImpl;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdMailService {

    CdMailServiceImpl bind(String canonical, Long id);
    CdMailServiceImpl setTo(String to);
    CdMailServiceImpl setSubject(String subject);
    CdMailServiceImpl setBody(String body);
    String send();
}
