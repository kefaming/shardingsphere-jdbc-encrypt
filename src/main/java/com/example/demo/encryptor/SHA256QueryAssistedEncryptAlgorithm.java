package com.example.demo.encryptor;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shardingsphere.encrypt.spi.QueryAssistedEncryptAlgorithm;

import java.time.LocalDateTime;
import java.util.Properties;

@Getter
@Setter
public class SHA256QueryAssistedEncryptAlgorithm implements QueryAssistedEncryptAlgorithm {

    private Properties properties = new Properties();

    @Override
    public void init() {

    }

    @Override
    public String encrypt(Object plaintext) {
        if (null == plaintext) {
            return null;
        }
        // 原始字符串+变动因子（如时间戳）
        plaintext = plaintext.toString() + LocalDateTime.now().toString();
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

    /**
     * Query assisted encrypt.
     *
     * @param plaintext plaintext
     * @return ciphertext
     */
    @Override
    public String queryAssistedEncrypt(Object plaintext) {
        if (null == plaintext) {
            return null;
        }
        // 原始字符串
        return DigestUtils.sha256Hex(String.valueOf(plaintext));
    }
}
