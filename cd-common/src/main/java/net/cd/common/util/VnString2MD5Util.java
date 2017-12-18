package net.cd.common.util;

import org.apache.commons.codec.binary.Hex;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Tree.Yip on 2/8/2016.
 */
public class VnString2MD5Util {

    public static synchronized String convert(String in) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.reset();
        messageDigest.update(in.getBytes(Charset.forName("UTF8")));
        return new String(Hex.encodeHex(messageDigest.digest()));
    }
}
