package com.nallani;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.net.URLCodec;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AESDecrypt {

    PrivateKeyFromString aesPrivateKey = new PrivateKeyFromString();
    String keyStore = "key";
    public String decrypt(String encryptedData) {
        String result = null;
        String urlDecodedString = null;

        try {
           urlDecodedString = URLDecoder.decode(encryptedData, String.valueOf(StandardCharsets.UTF_8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            // Decode tokens and split them
            final String[] tokens = new URLCodec().decode(urlDecodedString).split("\\|");
            // Decrypt key using RSA and then decrypt the data using decrypted key
            final byte[] decryptedData =
                    decrypt(
                            Base64.decodeBase64(tokens[1]),
                            decryptWithPrivateKey(Base64.decodeBase64(tokens[0])));
            result = new String(decryptedData);
        } catch (DecoderException
                | InvalidAlgorithmParameterException
                | NoSuchPaddingException
                | IllegalBlockSizeException
                | NoSuchAlgorithmException
                | BadPaddingException
                | InvalidKeyException e) {
        }
        return result;
    }

    private byte[] decryptWithPrivateKey(final byte[] encData)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException {
        Cipher rsa = Cipher.getInstance("RSA");
        rsa.init(Cipher.DECRYPT_MODE, aesPrivateKey.getPrivateKeyString(keyStore));
        return rsa.doFinal(encData);
    }

    private byte[] decrypt(byte[] data, byte[] keyBytes)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {

        SecretKey key = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(keyBytes);
        Cipher encryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); // NOSONAR
        encryptCipher.init(javax.crypto.Cipher.DECRYPT_MODE, key, ivParameterSpec);
        return encryptCipher.doFinal(data);
    }
}
