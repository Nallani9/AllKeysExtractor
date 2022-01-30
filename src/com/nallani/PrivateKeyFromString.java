package com.nallani;
import org.bouncycastle.util.encoders.Base64;

import java.io.BufferedReader;
import java.io.StringReader;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

public class PrivateKeyFromString {

    public PrivateKey getPrivateKeyString(String keyStore) {
        StringBuilder pkcs8Lines = new StringBuilder();
        try {
            if (null != keyStore) {
                System.out.println("keyStore is null");
            }
            BufferedReader rdr = new BufferedReader(new StringReader(keyStore));
            String line;
            while ((line = rdr.readLine()) != null) {
                pkcs8Lines.append(line);
            }
            // Remove any whitespace
            String pkcs8Pem = pkcs8Lines.toString();
            pkcs8Pem = pkcs8Pem.replaceAll("\\s+", "");
            // Base64 decode the result
            byte[] pkcs8EncodedBytes = Base64.decode(pkcs8Pem);
            // extract the private key
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(pkcs8EncodedBytes);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            return kf.generatePrivate(keySpec);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
