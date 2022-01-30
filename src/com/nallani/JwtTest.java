package com.nallani;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jose.crypto.RSAEncrypter;
import com.nimbusds.jwt.EncryptedJWT;
import com.nimbusds.jwt.JWTClaimsSet;

import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

public class JwtTest {

    public static void jwt() throws JOSEException, ParseException {
        Date now = new Date();

        JWTClaimsSet jwtClaims = new JWTClaimsSet.Builder()
                .issuer("https://openid.net")
                .subject("alice")
                .audience(Arrays.asList("https://app-one.com", "https://app-two.com"))
                .expirationTime(new Date(now.getTime() + 1000 * 60 * 10)) // expires in 10 minutes
                .notBeforeTime(now)
                .issueTime(now)
                .jwtID(UUID.randomUUID().toString())
                .build();

        System.out.println(jwtClaims.toJSONObject());
// Produces
// {
//   "iss" : "https:\/\/openid.net",
//   "sub" : "alice",
//   "aud" : [ "https:\/\/app-one.com" , "https:\/\/app-two.com" ],
//   "exp" : 1364293137871,
//   "nbf" : 1364292537871,
//   "iat" : 1364292537871,
//   "jti" : "165a7bab-de06-4695-a2dd-9d8d6b40e443"
// }

        // Request JWT encrypted with RSA-OAEP-256 and 128-bit AES/GCM
        JWEHeader header = new JWEHeader(JWEAlgorithm.RSA_OAEP_256, EncryptionMethod.A128GCM);

        // Create the encrypted JWT object
        EncryptedJWT jwt = new EncryptedJWT(header, jwtClaims);

        // Create an encrypter with the specified public RSA key
        RSAEncrypter encrypter = new RSAEncrypter((RSAPublicKey) PublicKeyFromFile.create());

        // Do the actual encryption
        jwt.encrypt(encrypter);

        // Serialise to JWT compact form
        String jwtString = jwt.serialize();

        System.out.println(jwtString);

        // Parse back
        jwt = EncryptedJWT.parse(jwtString);

        PrivateKeyBouncy privateKeyBouncy = new PrivateKeyBouncy();
        // Create a decrypter with the specified private RSA key
        RSADecrypter decrypter = new RSADecrypter(privateKeyBouncy.createPrivateKey());

        // Decrypt
        jwt.decrypt(decrypter);

        // Retrieve JWT claims
        System.out.println(jwt.getJWTClaimsSet().getIssuer());
        ;
        System.out.println(jwt.getJWTClaimsSet().getSubject());
        System.out.println(jwt.getJWTClaimsSet().getAudience().size());
        System.out.println(jwt.getJWTClaimsSet().getExpirationTime());
        System.out.println(jwt.getJWTClaimsSet().getNotBeforeTime());
        System.out.println(jwt.getJWTClaimsSet().getIssueTime());
        System.out.println(jwt.getJWTClaimsSet().getJWTID());

    }
}
