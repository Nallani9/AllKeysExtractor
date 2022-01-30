package com.nallani;

import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class AESEncrypt {
    String keyStore = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApCp+wyBGrfvXT9kgEruOU/xWQb4Bclii5yxa4viTs06Bij4RsgCu42LsdtItTGWEtBH16oQpeWOWXY5/vLCMPSGXMeQMDiYrLYof/3GolGYuRNfF+G3i7VEUX0lpujMGlO+kTU/u/EsLx9+C0TJvQ5dht0SH3rTMAIi8qAOTpuI2gLdrfOc9WYtS3J4+Eeas4mrdtEgKDJhfWB3byVzBsYFAt0z3RwMhElOTnkuo8s1LkYqawK7FS5ZNnf9SERGEtaqsQORdZE48wr7q6jFl7fbuSmeiQNPBpbMnsNkJ9pqm7mbCEdn0ROcfQHVFTG+de3OrAN7MiU/NPFx7UQE4GwIDAQAB";

    public byte[] encrypt(String data) {
        try {
            String encryptedString = Base64.getEncoder().encodeToString(data.getBytes(StandardCharsets.UTF_8));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(keyStore));
            return cipher.doFinal(encryptedString.getBytes());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new byte[0];
    }

    public PublicKey getPublicKey(String keyStore) throws Exception {
        if (StringUtils.isBlank(keyStore)) {
            System.out.println("keyStore cannot be null");
        }
        byte[] byteKey = Base64.getDecoder().decode(keyStore.getBytes());
        X509EncodedKeySpec encodedKeySpec = new X509EncodedKeySpec(byteKey);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(encodedKeySpec);
    }
}
