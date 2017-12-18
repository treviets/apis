package net.cd.service.security;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdCodecService {

    public String AES256Encrypt(String plaintext, String keyAES256IvParameterSpec, String keyAES256SecretKeySpec);

    public String AES256Encrypt(String plaintext);

    public String AES256Decrypt(String ciphertext);

    public String Base64Encode(String plaintext);

    public String Base64Decode(String base64);
}
