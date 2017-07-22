package tr.com.bayindir.jwtdemo.jwtdemo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureException;
import org.apache.catalina.servlet4preview.GenericFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kemalbayindir on 21/07/2017.
 */
public class SecurityFilter extends GenericFilter {
    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
            throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;
        final String authHeader = request.getHeader("authorization");

        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);

            chain.doFilter(req, res);
        } else {

            if (authHeader == null) {
                throw new ServletException("Missing or invalid Authorization header");
            }

            final String token = authHeader;

            try {

                final Claims claims = AuthUtils.validateToken(token);
                request.setAttribute("claims", claims);

            } catch (final SignatureException e) {
                throw new ServletException("Invalid token");
            }

            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {

    }
}
