package site.fish119.adminss.secruity;

import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationTokenFilter extends OncePerRequestFilter {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserDetailsServiceImple userDetailsService;

    @Autowired
    TokenUtil jwtTokenUtil;
    @Override
    @Transactional
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader(AuthConstant.tokenHeader);
        if(authHeader!=null&&authHeader.startsWith(AuthConstant.tokenPrefix)){
            try {
                final String authToken = authHeader.substring(AuthConstant.tokenPrefix.length());
                String username = jwtTokenUtil.getUsernameFromToken(authToken);
                logger.debug("checking authentication {} from {}",username,request.getRequestURI());
                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                    if (jwtTokenUtil.validateToken(authToken, userDetails)) {
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                                request));
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            }catch (ExpiredJwtException | CredentialsExpiredException e){
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "认证超时，请重新登录。");
            }
        }
        filterChain.doFilter(request, response);
    }
}
