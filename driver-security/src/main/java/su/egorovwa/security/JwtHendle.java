package su.egorovwa.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.Base64;
import java.util.Date;

public class JwtHendle {
    private final String secret;

    public JwtHendle(String secret) {
        this.secret = secret;
    }

    private VertificationResult getVertificationResult(String token) throws Exception {
        Claims claims = Jwts.parser().setSigningKey(Base64.getEncoder().encodeToString(secret.getBytes()))
                .parseClaimsJws(token)
                .getBody();
        if (claims.getExpiration().before(new Date())){
            throw new Exception("Token expiries");
        }
        return new VertificationResult(claims, token);
    }

    public VertificationResult check(String token) throws Exception {
      return   getVertificationResult(token);
    }

    public class VertificationResult {
        Claims claims;
        String token;

        public VertificationResult(Claims claims, String token) {
            this.claims = claims;
            this.token = token;
        }
    }

}
