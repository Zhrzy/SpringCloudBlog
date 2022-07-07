package com.zy.blog.oauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;

/**
 * 非对称加密公钥私钥
 * @author  小章鱼 1716457206@qq.com
 */
@RestController
@RequestMapping
public class PublicKeyController {
    @Autowired
    private KeyPair keyPair;

    @GetMapping("/getPublicKey")
    public Map<String, Object> loadPublicKey() {
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAKey key = new RSAKey.Builder(publicKey).build();
        return new JWKSet(key).toJSONObject();
    }
}
