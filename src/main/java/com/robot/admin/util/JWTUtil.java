package com.robot.admin.util;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.Objects;


/**
 * @author robot
 * @date 2019/12/26 14:47
 */
public class JWTUtil {

    private static Logger log = LoggerFactory.getLogger(JWTUtil.class);

    /**
     * 解析jwt
     *
     * @param jsonWebToken
     * @param base64Security
     * @return
     */
    public static Message parseJWT(String jsonWebToken, String base64Security) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
                    .parseClaimsJws(jsonWebToken).getBody();
            return Message.success(claims);
        } catch (ExpiredJwtException eje) {
            log.error("-----------token过期-----------");
            return Message.error(ErrorType.TOKEN_EXPIRES);

        } catch (Exception e) {
            log.error("-----------token解析异常-----------");
            return Message.error(ErrorType.ERROR);
        }
    }

    /**
     * 构建jwt
     *
     * @param
     * @param userName
     * @return
     */
    public static Message createJWT(String userName) {
        try {
            // 使用HS256加密算法
            SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
            long nowMillis = System.currentTimeMillis();
            Date now = new Date(nowMillis);

            //生成签名密钥
            byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(StaticUtil.base64Secret);
            Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

            //phone，进行加密下
            String user = Base64Util.encode(userName);

            //添加构成JWT的参数
            JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
                    .claim("userName", userName)
                    .setSubject(user)           // 代表这个JWT的主体，即它的所有人
                    .setIssuer(StaticUtil.clientId)              // 代表这个JWT的签发主体；
                    .setIssuedAt(new Date())        // 是一个时间戳，代表这个JWT的签发时间；
                    .setAudience(StaticUtil.name)          // 代表这个JWT的接收对象；
                    .signWith(signatureAlgorithm, signingKey);
            //添加Token过期时间
            int TTLMillis = StaticUtil.expiresSecond;
            long expMillis = nowMillis + TTLMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp)  // 是一个时间戳，代表这个JWT的过期时间；
                    .setNotBefore(now); // 是一个时间戳，代表这个JWT生效的开始时间，意味着在这个时间之前验证JWT是会失败的
            //生成JWT
            return Message.success(builder.compact());
        } catch (Exception e) {

            log.error("签名失败", e);
            return Message.error(ErrorType.SIGN_ERROR);

        }
    }

    /**
     * 从token中获取用户名
     *
     * @param token
     * @param base64Security
     * @return
     */
    public static String getUsername(String token, String base64Security) {
        Claims claims = (Claims) parseJWT(token, base64Security).getData();
        return claims.getSubject();
    }

    /**
     * 从token中获取用户ID
     *
     * @param token
     * @param base64Security
     * @return
     */
    public static String getUserId(String token, String base64Security) {
        Claims claims = (Claims) parseJWT(token, base64Security).getData();
        String userId = Objects.requireNonNull(claims).get("userName", String.class);
        return Base64Util.decode(userId);
    }

    /**
     * 是否已过期
     *
     * @param token
     * @param base64Security
     * @return
     */
    public static boolean isExpiration(String token, String base64Security) {
        Claims claims = (Claims) parseJWT(token, base64Security).getData();
        return Objects.requireNonNull(claims).getExpiration().before(new Date());
    }
}

