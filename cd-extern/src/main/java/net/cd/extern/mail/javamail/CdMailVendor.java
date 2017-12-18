package net.cd.extern.mail.javamail;

import net.cd.extern.mail.CdMailAbstract;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by Tree.Yip on 31/7/2016.
 */
public class CdMailVendor extends CdMailAbstract {

    @Override
    public String send() {
        System.out.println("smtp send");
        Properties mailProps = new Properties();
        mailProps.put("mail.transport.protocol", getProtocol());
        mailProps.put("mail.smtp.port", getPort());
        mailProps.put("mail.smtp.auth", "true");
        mailProps.put("mail.smtp.starttls.enable", "true");
        mailProps.put("mail.smtp.starttls.required", "true");
        mailProps.put("mail.smtp.debug", "true");

        Session session = Session.getDefaultInstance(mailProps);
        Transport transport = null;

        try {
            transport = session.getTransport();
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(getFrom(), getFromname()));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(getTo()));
            msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(getBcc()));
            msg.setSubject(getSubject());
            msg.setContent(getBody(), "text/html; charset=UTF-8");

            transport.connect(getHost(), getUsername(), getPassphrase());
            transport.sendMessage(msg, msg.getAllRecipients());
        }
        catch (Exception ex) {
            return org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace(ex);//ex.getMessage();
        }
        finally
        {
            if (transport != null) {
                try {
                    transport.close();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

}
