package com.demo.contacts.Security.Jwt;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.ParseException;
import java.util.Base64;
import java.util.Date;
/**
 * //class that works for encrypted and decrypted, generated and check JWT tokens
 * //openssl can generate keys more secure to use in ours token
 */
@Service
public class JWTUtilityImpl implements IJWTUtilityServices {
    /**
     * private key private and public key
     *
     */ //value get route where are the keys made by OpenSSL
    @Value("classpath:jwtKeys/private_key.pem")
    private Resource privateKeyPrivate;

    @Value("classpath:jwtKeys/public_key.pem")
    private Resource publicKeyPublic;

    /**
     * generate j w t
     */ //method to generate a token with id user
    @Override
    public String generateJWT(Long userId) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, JOSEException {
        PrivateKey privateKey = loadPrivateKey(privateKeyPrivate);
        JWSSigner signer = new RSASSASigner(privateKey);
        Date now = new Date();

        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject(userId.toString())
                .issueTime(now)
                .expirationTime(new Date(now.getTime()+944000000))//miliseconds time to expire token
                .build();
        //encrypt the token
        SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.RS256), claimsSet);
        signedJWT.sign(signer);

        return  signedJWT.serialize();
    }

/**
 * parse j w t
 */ //this method works and verify that the signature and parsing token
    @Override
    public JWTClaimsSet parseJWT(String jwt) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException, JOSEException, ParseException {
        PublicKey publicKey = loadPublicKey(publicKeyPublic);
        SignedJWT signedJWT = SignedJWT.parse(jwt);
        JWSVerifier verifier = new RSASSAVerifier((RSAPublicKey) publicKey);

        if(!signedJWT.verify(verifier)){
            throw new JOSEException("Invalid Signature");
        }

        JWTClaimsSet claimsSet = signedJWT.getJWTClaimsSet();

        if(claimsSet.getExpirationTime().before(new Date())){
           throw new JOSEException("Expired token"); //fix this send to client
        }

        return claimsSet;
    }

    //this method load public form folder resources and parse pem to a key
    private byte[] decodeBase64Key(byte[] keyBytes, String typeKey){
        String KeyPEM = new String(keyBytes, StandardCharsets.UTF_8)
                .replace("-----BEGIN "+typeKey+" KEY-----", "")
                .replace("-----END "+typeKey+" KEY-----", "")
                .replaceAll("\\s", "");
        byte[] decodedKey = Base64.getDecoder().decode(KeyPEM);
        return decodedKey;
    }

    private byte[] readKeyBytes(InputStream inputStream) throws IOException {
        return inputStream.readAllBytes();
    }

    private PublicKey generatePublicKey(byte[] decodedKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(new X509EncodedKeySpec(decodedKey));
    }

    private PrivateKey generatePrivateKey(byte[] decodedKey) throws NoSuchAlgorithmException, InvalidKeySpecException{
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(decodedKey));
    }
    private PublicKey loadPublicKey(Resource resource)  {
        try (InputStream inputStream = resource.getInputStream()) {
            byte[] keyBytes = readKeyBytes(inputStream);
            byte[] decodedKey = decodeBase64Key(keyBytes, "PUBLIC");

            return generatePublicKey(decodedKey);
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException("Error loading key from resource", e);
        }
    }
    private PrivateKey loadPrivateKey(Resource resource)  {
        try (InputStream inputStream = resource.getInputStream()) {
            byte[] keyBytes = readKeyBytes(inputStream);
            byte[] decodedKey = decodeBase64Key(keyBytes, "PRIVATE");

            return generatePrivateKey(decodedKey);
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException("Error loading public key from resource", e);
        }
    }

}

//make a catch when token expired