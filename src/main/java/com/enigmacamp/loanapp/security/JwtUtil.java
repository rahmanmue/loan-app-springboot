package com.enigmacamp.loanapp.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.enigmacamp.loanapp.model.entity.AppUser;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
@Component
public class JwtUtil {

    private String jwtSecret = "rahasia";
    private String appName= "loanapp";
    private long jwtExpiration = 3600;


    public String generateToken(AppUser appUser){
        Algorithm algorithm = Algorithm.HMAC256(jwtSecret.getBytes(StandardCharsets.UTF_8));
        return JWT.create()
                .withIssuer(appName)
                .withSubject(appUser.getId())
                .withExpiresAt(Instant.now().plusSeconds(jwtExpiration))
                .withIssuedAt(Instant.now())
                .sign(algorithm);
    }
    public boolean verifyJwtToken(String token){
        Algorithm algorithm = Algorithm.HMAC256(jwtSecret.getBytes(StandardCharsets.UTF_8));
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);

        return decodedJWT.getIssuer().equals(appName);
    };

    public Map<String, String> getUserInfoByToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(jwtSecret.getBytes(StandardCharsets.UTF_8));
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = verifier.verify(token);

            Map<String, String> userInfo = new HashMap<>();
            userInfo.put("userId", decodedJWT.getSubject());
            userInfo.put("role", decodedJWT.getClaim("role").asString());

            return userInfo;
        }catch(JWTVerificationException e){
            throw new RuntimeException();

        }

    }
}
