package site.fish119.adminss.secruity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;
import site.fish119.adminss.domain.sys.Authority;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Service
public class AccessDecisionManagerImple implements AccessDecisionManager {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //decide 方法是判定是否拥有权限的决策方法
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        String url = request.getRequestURI();
        String method;
        AntPathRequestMatcher matcher;
        if (url.contains("/swagger") ||
                url.contains("/api-docs") ||
                url.contains("/swagger-resources") ||
                url.contains("/auth") ||
                url.contains(".html") ||
                url.contains(".css") ||
                url.contains(".js") ||
                url.contains(".jpg") ||
                url.contains(".png") ||
                url.contains(".gif") ||
//                url.contains("/SysUser")||
                url.contains(".ico")) {
            return;
        } else {
            for (GrantedAuthority ga : authentication.getAuthorities()) {
                if (ga instanceof Authority) {
                    Authority urlGrantedAuthority = (Authority) ga;
                    url = urlGrantedAuthority.getUrl();
                    method = urlGrantedAuthority.getMethod();
                    matcher = new AntPathRequestMatcher(url);
                    if (matcher.matches(request)) {
                        if (method.equals(request.getMethod()) || "ALL".equals(method)) {
                            return;
                        }
                    }
                }
            }
        }
        throw new AccessDeniedException("no right");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
