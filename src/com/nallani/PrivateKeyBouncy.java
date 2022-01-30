package com.nallani;

import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;

import java.io.FileReader;
import java.security.PrivateKey;

public class PrivateKeyBouncy {

    public PrivateKey createPrivateKey() {
        PEMParser reader = null;

        try {

            // Reading a PEM encoded private key
            reader = new PEMParser(new FileReader("private_nonprod.txt"));

            PEMKeyPair keys = (PEMKeyPair) reader.readObject();

            JcaPEMKeyConverter converter = new JcaPEMKeyConverter();

            PrivateKey privateKeyJava = converter.getPrivateKey(keys.getPrivateKeyInfo());
            System.out.println(privateKeyJava);
            return privateKeyJava;
        } catch (Exception e) {

        }
        return null;
    }
}
