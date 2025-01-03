package com.kw.Proj2_spr_2020202060.util;

import com.kw.Proj2_spr_2020202060.Model.UserVo;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private static final String jwtSecretKey = "thisIsASecretKeyUsedForJwtTokenGenerationAndItIsLongEnoughToMeetTheRequirementOf256Bits";
    // jwtSecretKey를 바이트 배열로 변환하고, 이를 사용하여 HMAC-SHA256 알고리즘에 사용할 키를 생성한다.
    private static final Key key = Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
    private static final String JWT_TYPE = "JWT";
    private static final String ALGORITHM = "HS256";
    private static final String LOGIN_ID = "loginId";
    private static final String USERNAME = "username";


    /**
     * 사용자 pk를 기준으로 JWT 토큰을 발급하여 반환해 준다.
     */
    public String generateJwtToken(UserVo userVo) {

        JwtBuilder builder = Jwts.builder()
                .setHeader(createHeader())                                  // Header 구성
                .setClaims(createClaims(userVo))                           // Payload - Claims구성
                .setSubject(String.valueOf(userVo.getId()))              // Payload - Subjects구성
                .setIssuer("profile")                                       // Issuer 구성
                .signWith(key, SignatureAlgorithm.HS256)                    // Signature 구성 : 이 키를 사용하여 JWT 토큰에 서명을 추가한다. 이 서명은 토큰의 무결성을 보장하는 데 사용된다.
                .setExpiration(createExpiredDate());                        // Expired Date 구성

        return builder.compact();
    }

    /**
     * 토큰을 기반으로 사용자의 정보를 반환해주는 메서드
     */
    public static boolean isValidToken(String token) {
        try {
            Claims claims = getClaimsFromToken(token);



            return true;
        } catch (ExpiredJwtException expiredJwtException) {

            return false;
        } catch (JwtException jwtException) {

            return false;
        } catch (NullPointerException npe) {

            return false;
        }
    }

    /**
     * 토큰의 만료기간을 지정하는 함수
     * @return Date
     */
    private static Date createExpiredDate() {
        // 토큰의 만료기간은 8시간으로 지정
        Instant now = Instant.now();
        Instant expiryDate = now.plus(Duration.ofHours(8));
        return Date.from(expiryDate);
    }

    /**
     * JWT의 헤더값을 생성해주는 메서드
     */
    private static Map<String, Object> createHeader() {
        Map<String, Object> header = new HashMap<>();

        header.put("typ", JWT_TYPE);
        header.put("alg", ALGORITHM);
        header.put("regDate", System.currentTimeMillis());
        return header;
    }

    /**
     * 사용자 정보를 기반으로 클래임을 생성해주는 메서드
     * @param userVo 사용자 정보
     * @return Map<String, Object>
     */
    private static Map<String, Object> createClaims(UserVo userVo) {
        // 공개 클래임에 사용자의 이름과 이메일을 설정해서 정보를 조회할 수 있다.
        Map<String, Object> claims = new HashMap<>();




        claims.put(LOGIN_ID, userVo.getId());
        claims.put(USERNAME, userVo.getName());
        return claims;
    }

    // 토큰에서 클레임을 추출하는 메서드
    private static Claims getClaimsFromToken(String token) {
        return Jwts.parser() // 기존 parser() 사용
                .setSigningKey(key)  // Signing key 설정
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 토큰을 기반으로 사용자 정보를 반환받는 메서드
     * @return String : 사용자 아이디
     */
    public static String getUserIdFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.get(LOGIN_ID).toString();
    }
}
