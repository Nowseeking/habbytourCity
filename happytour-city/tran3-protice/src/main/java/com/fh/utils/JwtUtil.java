package com.fh.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    //过期时间
    private static final long EXPIRE_TIME = 30*60* 1000;
    //私钥
    private static final String TOKEN_SECRET = "tohka";

    /**
     * 生成签名，30分钟过期
     * @param **username**
    * @param **password**
    * @return
     */
    //这里返回值改为String
    public static String sign(String userString) {
        try {
            // 设置过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            // 私钥和加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            // 设置头部信息
            Map<String, Object> header = new HashMap<>(2);
            header.put("Type", "Jwt");
            header.put("alg", "HS256");
            // 返回token字符串
            return JWT.create()
                    .withHeader(header)
                    .withClaim("user", userString)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 检验token是否正确
     * @param **token**
    * @return
     */
    public static String verify(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            String userStr = jwt.getClaim("user").asString();
            return userStr;
        } catch (Exception e){
            return "";
        }
    }

    public static void main(String[] args) {
       String name="十香";
       String token = sign(name);
       System.out.println(token);
       String verify = verify("eyJhbGciOiJIUzI1NiIsIlR5cGUiOiJKd3QiLCJ0eXAiOiJKV1QifQ.eyJleHAiOjE2MDQzNzQ2NDcsInVzZXIiOiLljYHpppkifQ.xspT1fN4guR_aMpwFUgpUXUFejrzdjNLYwWj4_MzNIw");
       System.out.println(verify);
    }
}
