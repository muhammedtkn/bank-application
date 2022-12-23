package com.muhammed.bankapplication.sec.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenGenerator {

    @Value("${mt.jwt-expire-time}")
    private Long EXPIRE_TIME;

    @Value("${mt.jwt-app-key}")
    private String APP_KEY;

    public String generateJwtToken(Authentication authentication){

        JwtUserDetails jwtUserDetails = (JwtUserDetails) authentication.getPrincipal();

        Date expireDate = new Date(new Date().getTime() + EXPIRE_TIME);

        String token = Jwts.builder()
                .setSubject(Long.toString(jwtUserDetails.getId()))
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, APP_KEY)
                .compact();

        return token;
    }

    public Long findCustomerIdByToken(String token){

        Jws<Claims> claimsJws = getClaimsJws(token);

        String customerId = claimsJws.getBody().getSubject();

        return Long.valueOf(customerId);
    }

    public boolean validateToken(String token){

        boolean isValid;
        try {
            Jws<Claims> claimsJws = getClaimsJws(token);

            isValid = !isTokenExpired(claimsJws);

        } catch (Exception e){
            isValid = false;
        }

        return isValid;
    }

    private boolean isTokenExpired(Jws<Claims> claimsJws) {
        Date expirationDate = claimsJws.getBody().getExpiration();

        return expirationDate.before(new Date());
    }


    private Jws<Claims> getClaimsJws(String token) {
        Jws<Claims> claimsJws = Jwts.parser()
                .setSigningKey(APP_KEY)
                .parseClaimsJws(token);
        return claimsJws;
    }

}
