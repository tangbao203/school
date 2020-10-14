package org.example.auth.entity;

import lombok.Data;

import java.util.List;

@Data
public class JWTCertResult {

    private List<JWTCert> keys;

    @Data
    public static class JWTCert {
        /**
         * 公钥ID
         */
        private String kid;
        /**
         * 公钥算法类型
         */
        private String kty;
        /**
         * 公钥算法
         */
        private String alg;
        /**
         * 公钥用途:  sig 签名;enc 加密
         */
        private String use;
        /**
         * 公钥
         */
        private String n;
        /**
         * AQAB
         */
        private String e;
    }
}
