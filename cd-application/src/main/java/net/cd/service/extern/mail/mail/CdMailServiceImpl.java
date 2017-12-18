package net.cd.service.extern.mail.mail;

import net.cd.common.util.VnJNDIUtil;
import net.cd.exception.CdErrors;
import net.cd.extern.mail.CdMailAbstract;
import net.cd.service.extern.mail.CdMailService;
import org.springframework.stereotype.Service;

/**
 * Created by Vincent 01/12/2017
 */
@Service
public class CdMailServiceImpl implements CdMailService {

    private static final String prefix = "net.cd.extern.mail.%s.CdMailVendor";
    private CdMailAbstract instance;

    @Override
    public CdMailServiceImpl bind(String canonical, Long id) {
        try {
            Object[] arguments = new Object[1];
            arguments[0] = id;
            instance = (CdMailAbstract) Class.forName(String.format(prefix, canonical)).newInstance();
            instance.setHost(VnJNDIUtil.getInstance().getString(String.format("extern/mail/%s/host", canonical)));
            instance.setPort(VnJNDIUtil.getInstance().getInteger(String.format("extern/mail/%s/port", canonical)));
            instance.setProtocol(VnJNDIUtil.getInstance().getString(String.format("extern/mail/%s/protocol", canonical)));
            instance.setUsername(VnJNDIUtil.getInstance().getString(String.format("extern/mail/%s/username", canonical)));
            instance.setPassphrase(VnJNDIUtil.getInstance().getString(String.format("extern/mail/%s/passphrase", canonical)));
            instance.setFrom(VnJNDIUtil.getInstance().getString("extern/mail/from"));
            instance.setFromname(VnJNDIUtil.getInstance().getString("extern/mail/fromname"));
            instance.setBcc(VnJNDIUtil.getInstance().getString(String.format("extern/mail/bcc", canonical)));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public CdMailServiceImpl setTo(String to) {
        if (instance != null) {
            instance.setTo(to);
        }
        return this;
    }

    @Override
    public CdMailServiceImpl setSubject(String subject) {
        if (instance != null) {
            instance.setSubject(subject);
        }
        return this;
    }

    @Override
    public CdMailServiceImpl setBody(String body) {
        if (instance != null) {
            instance.setBody(body);
        }
        return this;
    }

    @Override
    public String send() {
        if (instance != null) {
            return instance.send();
        }
        return CdErrors.CD_T_MAIL_EXCEPTION.name();
    }
}
