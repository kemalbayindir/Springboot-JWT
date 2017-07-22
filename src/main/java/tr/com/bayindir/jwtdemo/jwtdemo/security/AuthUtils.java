package tr.com.bayindir.jwtdemo.jwtdemo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import tr.com.bayindir.jwtdemo.jwtdemo.model.MemberInfo;

import java.util.Date;

/**
 * Created by kemalbayindir on 21/07/2017.
 */
public class AuthUtils {

    public final static String SECRET_KEY = "SECRET_KEY";

    public static String generateToken(String username, MemberInfo member) {
        return Jwts.builder()
                       .setSubject(username)
                       .claim("user", member)
                       .setIssuedAt(new Date())
                       .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                       .compact();
    }

    public static Claims validateToken(String token) {
        return Jwts.parser()
                   .setSigningKey(SECRET_KEY)
                   .parseClaimsJws(token)
                   .getBody();
    }
}
