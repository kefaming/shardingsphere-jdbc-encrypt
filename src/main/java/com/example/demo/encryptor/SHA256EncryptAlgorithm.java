package com.example.demo.encryptor;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shardingsphere.encrypt.spi.EncryptAlgorithm;

import java.util.Properties;

@Getter
@Setter
public class SHA256EncryptAlgorithm implements EncryptAlgorithm {

    private Properties properties = new Properties();

    private static final String HAES_KEY = "sha256-key-value";

    @Override
    public void init() {

    }

    @Override
    public String encrypt(Object plaintext) {
        if (null == plaintext) {
            return null;
        }
        return DigestUtils.sha256Hex(String.valueOf(plaintext));
    }

    @Override
    public Object decrypt(String ciphertext) {
        return ciphertext;
    }

    @Override
    public String getType() {
        return "SHA256";
    }
}
