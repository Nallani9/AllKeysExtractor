package com.nallani;

import org.bouncycastle.util.encoders.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;

public class ExtractKeysFromJCEKS {

    public void getAESKeysInfo() {
        try {
            KeyStore store = KeyStore.getInstance("JCEKS");
            store.load(new FileInputStream(new File("open-xx-xx-x.jceks")), "changeit".toCharArray());

            KeyStore.PrivateKeyEntry privateKey = (KeyStore.PrivateKeyEntry) store.getEntry(
                    "open-xx-xx", new KeyStore.PasswordProtection("changeit".toCharArray()));
            PrivateKey key = privateKey.getPrivateKey();
            System.out.println("test format---->> " + privateKey.getPrivateKey().getFormat());
            System.out.println("private key ---->> " + new String(Base64.encode(key.getEncoded())));

            PublicKey publicKey = privateKey.getCertificate().getPublicKey();
            System.out.println("test format---->> " + publicKey.getFormat());
            System.out.println("test alg---->> " + publicKey.getAlgorithm());
            System.out.println("public key Base64---->> " + new String(Base64.encode(publicKey.getEncoded())));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void getSAMLKeysInfo() {
        try {
            KeyStore store = KeyStore.getInstance("JCEKS");
            store.load(new FileInputStream(new File("xxxx.jceks")), "changeit".toCharArray());

            KeyStore.PrivateKeyEntry privateKey = (KeyStore.PrivateKeyEntry) store.getEntry(
                    "i-xx-xxxx", new KeyStore.PasswordProtection("keystore".toCharArray()));
            PrivateKey key = privateKey.getPrivateKey();
            System.out.println("alog --->" + privateKey.getPrivateKey().getAlgorithm());
            System.out.println("test format---->> " + privateKey.getPrivateKey().getFormat());
            System.out.println("private key ---->> " + new String(Base64.encode(key.getEncoded())));

            PublicKey publicKey = privateKey.getCertificate().getPublicKey();
            System.out.println("test format---->> " + publicKey.getFormat());
            System.out.println("test alg---->> " + publicKey.getAlgorithm());
            System.out.println("public key Base64---->> " + new String(Base64.encode(publicKey.getEncoded())));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void getAESKeysInfoProd() {
        try {
            KeyStore store = KeyStore.getInstance("JCEKS");
            store.load(new FileInputStream(new File("xxxx.jceks")), "changeit".toCharArray());

            KeyStore.PrivateKeyEntry privateKey = (KeyStore.PrivateKeyEntry) store.getEntry(
                    "open-xx", new KeyStore.PasswordProtection("keystore".toCharArray()));
            PrivateKey key = privateKey.getPrivateKey();
            System.out.println("test format---->> " + privateKey.getPrivateKey().getFormat());
            System.out.println("private key ---->> " + new String(Base64.encode(key.getEncoded())));

            PublicKey publicKey = privateKey.getCertificate().getPublicKey();
            System.out.println("test format---->> " + publicKey.getFormat());
            System.out.println("test alg---->> " + publicKey.getAlgorithm());
            System.out.println("public key Base64---->> " + new String(Base64.encode(publicKey.getEncoded())));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void getSAMLKeysInfoProd() {
        try {
            KeyStore store = KeyStore.getInstance("JCEKS");
            store.load(new FileInputStream(new File("idp-sign-private.jceks")), "changeit".toCharArray());

            KeyStore.PrivateKeyEntry privateKey = (KeyStore.PrivateKeyEntry) store.getEntry(
                    "idp-xxx", new KeyStore.PasswordProtection("keystore".toCharArray()));
            PrivateKey key = privateKey.getPrivateKey();
            System.out.println("test format---->> " + privateKey.getPrivateKey().getFormat());
            System.out.println("private key ---->> " + new String(Base64.encode(key.getEncoded())));

            PublicKey publicKey = privateKey.getCertificate().getPublicKey();
            System.out.println("test format---->> " + publicKey.getFormat());
            System.out.println("test alg---->> " + publicKey.getAlgorithm());
            System.out.println("public key Base64---->> " + new String(Base64.encode(publicKey.getEncoded())));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
