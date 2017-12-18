package net.cd.service.xtras;

import net.cd.dto.kernal.CdKAssetMetaDataDto;
import net.cd.dto.kernal.CdKMemberDto;
import org.springframework.scheduling.annotation.Async;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdXNotificationService {

    @Async
    void sendMemberRegisterVerificationCodeSMS(CdKMemberDto cdKMemberDto, String acceptLanguage) throws UnsupportedEncodingException;

    @Async
    void sendMemberPasswordResetVerificationCodeSMS(CdKMemberDto cdKMemberDto, String acceptLanguage) throws UnsupportedEncodingException;

    @Async
    void sendBillSMS(CdKAssetMetaDataDto cdKAssetMetaDataDto, Date dueDate, BigDecimal amount, List<String> recipientList, String acceptLanguage) throws IOException;

    @Async
    void sendBillMail(CdKAssetMetaDataDto cdKAssetMetaDataDto, Date dueDate, BigDecimal amount, List<String> recipientList, List<String> referenceList, String acceptLanguage) throws IOException;
}
