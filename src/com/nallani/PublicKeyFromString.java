package com.nallani;

import sun.security.provider.X509Factory;

import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

public class PublicKeyFromString {


    public static X509Certificate parseCertificate(String certStr) throws CertificateException {
        //before decoding we need to get rod off the prefix and suffix
        byte[] decoded = Base64.getDecoder().decode(certStr.replaceAll(X509Factory.BEGIN_CERT, "").replaceAll(X509Factory.END_CERT, ""));

        return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(decoded));
    }
}
