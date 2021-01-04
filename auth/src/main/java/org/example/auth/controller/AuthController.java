package org.example.auth.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.example.auth.entity.JWTCertResult;
import org.example.auth.security.SecretHandle;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.lang.JoseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/auth")
@RestController
public class AuthController {
    private RsaJsonWebKey keyPair;
    private final String KID="jwt_rsa";
    private final String issuer="auth-service.school";
    private final String subject="test";

    AuthController() throws JoseException {
        keyPair= SecretHandle.genJWKKey(KID);
    }

    /**
     * 获取token
     * @param clientId 用户标示符
     * @return
     */
    @GetMapping("/token")
    public String getToken(@RequestParam String clientId){
        Map<String,Object> header=new HashMap<>();
        header.put("test1","test---value---1");
        header.put("test2","test---value---2");

        Map<String,String> payload=new HashMap<>();
        payload.put("biz1","value1");
        payload.put("biz2","value2");


        return SecretHandle.genJWT(issuer,KID,clientId,subject,
                keyPair,header,payload);
    }

    @GetMapping("/cert")
    public JWTCertResult getCert(){
        log.info("======获取 auth 公钥=====");
        JWTCertResult keys = new JWTCertResult();
        String pubKeyJson = keyPair.toJson(RsaJsonWebKey.OutputControlLevel.PUBLIC_ONLY);
        List<JWTCertResult.JWTCert> keyList = new ArrayList<>();
        JWTCertResult.JWTCert key = JSON.parseObject(pubKeyJson, JWTCertResult.JWTCert.class);
        keyList.add(key);
        keys.setKeys(keyList);
        return keys;
    }

    @GetMapping("/authority")
    public String authority(String token){
        log.info("=====进行用户权限校验=====\n token:{}",token);
        return "true";
    }
}
