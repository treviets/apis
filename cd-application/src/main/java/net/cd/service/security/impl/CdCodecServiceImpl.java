package net.cd.service.security.impl;

import net.cd.common.util.VnAESUtil;
import net.cd.common.util.VnBase64Util;
import net.cd.service.security.CdCodecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by Vincent 01/12/2017
 */
@Service
public class CdCodecServiceImpl implements CdCodecService {

    @Autowired
    @Value("#{cdKeyAES256IvParameterSpec}")
    private String cdKeyAES256IvParameterSpec;

    @Autowired
    @Value("#{cdKeyAES256SecretKeySpec}")
    private String cdKeyAES256SecretKeySpec;

    @Override
    public String AES256Encrypt(String plaintext, String keyAES256IvParameterSpec, String keyAES256SecretKeySpec) {
        return VnAESUtil.encrypt(keyAES256SecretKeySpec, keyAES256IvParameterSpec, plaintext);
    }

    @Override
    public String AES256Encrypt(String plaintext) {
        return VnAESUtil.encrypt(cdKeyAES256SecretKeySpec, cdKeyAES256IvParameterSpec, plaintext);
    }

    @Override
    public String AES256Decrypt(String ciphertext) {
        return VnAESUtil.decrypt(cdKeyAES256SecretKeySpec, cdKeyAES256IvParameterSpec, ciphertext);
    }

    @Override
    public String Base64Encode(String plaintext) {
        return VnBase64Util.encode(plaintext);
    }

    @Override
    public String Base64Decode(String base64) {
        return VnBase64Util.decode(base64);
    }
}
