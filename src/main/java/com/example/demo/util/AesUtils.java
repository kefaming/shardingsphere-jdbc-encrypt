package com.example.demo.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * AES 加解密
 */
public class AesUtils {

    private static byte[] createSecretKey(String aesKey) {
        return Arrays.copyOf(DigestUtils.sha1(aesKey), 16);
    }

    /**
     * AES 加密方法
     *
     * @param plaintext 加密文本
     * @param aesKey    加密 key
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     */
    public static Object encrypt(String plaintext, String aesKey) throws NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException {
        try {
            if (null == plaintext) {
                return null;
            } else {
                byte[] result = getCipher(1, aesKey).doFinal(StringUtils.getBytesUtf8(plaintext));
                return Base64.encodeBase64String(result);
            }
        } catch (GeneralSecurityException var3) {
            throw var3;
        }
    }

    /**
     * AES 解密方法
     *
     * @param ciphertext 密码
     * @param aesKey     加密 Key
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     */

    public static Object decrypt(String ciphertext, String aesKey) throws NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException {
        try {
            if (null == ciphertext) {
                return null;
            } else {
                byte[] result = getCipher(2, aesKey).doFinal(Base64.decodeBase64(ciphertext));
                return new String(result, StandardCharsets.UTF_8);
            }
        } catch (GeneralSecurityException var3) {
            throw var3;
        }
    }

    private static Cipher getCipher(int decryptMode, String aesKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        Cipher result = Cipher.getInstance(getType());
        result.init(decryptMode, new SecretKeySpec(createSecretKey(aesKey), getType()));
        return result;
    }

    public static String getType() {
        return "AES";
    }

    public static void main(String[] args) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        Object encrypt = AesUtils.encrypt("zhangsan", "123456abc");
        String p = encrypt.toString();
        System.out.println(p);

        String m = (String) AesUtils.decrypt(p, "123456abc");
        System.out.println(m);

    }
}
