package org.example.auth.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.lang.JoseException;

import java.util.Base64;
import java.util.Calendar;
import java.util.Map;

public class SecretHandle {

    /**
     * 创建jwt token
     * @param issuer
     * @param keyId
     * @param clientId
     * @param subject
     * @param keyPair
     * @param headers
     * @param payload
     * @return
     */
    public static String genJWT(String issuer,
                                     String keyId,
                                     String clientId,
                                     String subject,
                                     RsaJsonWebKey keyPair,
                                     Map<String, Object> headers,
                                     Map<String, String> payload) {
        JWTCreator.Builder builder = JWT.create();
        builder.withIssuer(issuer);
        builder.withKeyId(keyId);
        builder.withSubject(subject);
        builder.withAudience(clientId);

        Calendar calendar = Calendar.getInstance();
        builder.withIssuedAt(calendar.getTime());
        //有效期 自行配置
        calendar.add(Calendar.HOUR, 24);
        builder.withExpiresAt(calendar.getTime());

        if (null != headers && headers.size() > 0) {
            builder.withHeader(headers);
        }
        if (null != payload && payload.size() > 0) {
            for (Map.Entry<String, String> entry : payload.entrySet()) {
                builder.withClaim(entry.getKey(), entry.getValue());
            }
        }
        Algorithm algorithm = Algorithm.RSA256(keyPair.getRsaPublicKey(),keyPair.getRsaPrivateKey());
        return builder.sign(algorithm);
    }

    private static String decodeBase64(String src) {
        return new String(Base64.getDecoder().decode(src));
    }

    private static byte[] decodeBase64ToBytes(String src) {
        return Base64.getDecoder().decode(src);
    }

    private static String encodeBase64(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * 获取rsa密钥对
     * @param keyId 公钥kid
     * @return
     * @throws JoseException
     */
    public static RsaJsonWebKey genJWKKey(String keyId) throws JoseException {
        RsaJsonWebKey jwk = RsaJwkGenerator.generateJwk(2048);
        jwk.setKeyId(keyId);
        jwk.setAlgorithm(AlgorithmIdentifiers.RSA_USING_SHA256);
        System.out.println(encodeBase64(jwk.getRsaPublicKey().getEncoded()));
        System.out.println(encodeBase64(jwk.getRsaPrivateKey().getEncoded()));
        String publicKey = jwk.toJson(RsaJsonWebKey.OutputControlLevel.PUBLIC_ONLY);
        String privateKey = jwk.toJson(RsaJsonWebKey.OutputControlLevel.INCLUDE_PRIVATE);
        System.out.println("publicKey: " + publicKey);
        System.out.println("privateKey: " + privateKey);

        return jwk;
    }
}
