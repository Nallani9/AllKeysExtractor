package com.nallani;

import java.io.FileInputStream;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class PublicKeyFromFile {


    public static PublicKey create() {


        try {

            CertificateFactory certFactory = CertificateFactory.getInstance("X.509");

            FileInputStream is = new FileInputStream("public_nonprod.txt");

            X509Certificate cer = (X509Certificate) certFactory.generateCertificate(is);

            PublicKey key = cer.getPublicKey();

            return key;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
