package com.kr.caption.normal;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;

public class CodecUtil {

    private static final Logger logger = LogManager.getLogger(CodecUtil.class);
    private static final String IV = "0123456789abcdef";

    public CodecUtil() {
    }

    public static String md5(String data, boolean toLowerCase) {
        if (data == null) {
            return null;
        } else {
            byte[] result = DigestUtils.md5(data);
            return Hex.encodeHexString(result, toLowerCase);
        }
    }

    public static String encodeBase64(Object data) {
        if (data == null) {
            return null;
        } else {
            String result;
            if (data instanceof byte[]) {
                result = (new Base64(true)).encodeAsString((byte[])((byte[])data));
                return format(result);
            } else if (data instanceof String) {
                result = (new Base64(true)).encodeAsString(StringUtils.getBytesUtf8((String)data));
                return format(result);
            } else {
                return null;
            }
        }
    }

    public static byte[] decodeBase64(Object data) {
        if (data == null) {
            return null;
        } else if (data instanceof byte[]) {
            return (new Base64(true)).decode((byte[])((byte[])data));
        } else {
            return data instanceof String ? (new Base64(true)).decode((String)data) : null;
        }
    }

    public static String decodeBase64AsString(Object data) {
        byte[] result = decodeBase64(data);
        return result == null ? null : StringUtils.newStringUtf8(result);
    }

    public static String encryptAES(String data, String password) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecureRandom random = getSecureRandom(password);
            keyGenerator.init(128, random);
            SecretKey key = keyGenerator.generateKey();
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, key, new IvParameterSpec("0123456789abcdef".getBytes()));
            byte[] result = cipher.doFinal(StringUtils.getBytesUtf8(data));
            return encodeBase64(result);
        } catch (Exception var7) {
            var7.printStackTrace();
            logger.error("encryptAES error:{}", var7.getMessage());
            return null;
        }
    }

    public static String decryptAES(String data, String password) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecureRandom random = getSecureRandom(password);
            keyGenerator.init(128, random);
            SecretKey key = keyGenerator.generateKey();
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, key, new IvParameterSpec("0123456789abcdef".getBytes()));
            byte[] result = cipher.doFinal(decodeBase64(data));
            return StringUtils.newStringUtf8(result);
        } catch (Exception var7) {
            var7.printStackTrace();
            logger.error("decryptAES error:{}", var7.getMessage());
            return null;
        }
    }

    private static String format(String result) {
        return result == null ? null : result.replaceAll("\r\n", "");
    }

    private static SecureRandom getSecureRandom(String password) throws Exception {
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(password.getBytes());
        return secureRandom;
    }
}
