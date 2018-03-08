package site.fish119.adminss.utils;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import site.fish119.adminss.security.UserDetailsImple;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Project adminss
 * @Package site.fish119.adminss.utils
 * @Author fish119
 * @Date 2018/1/28 16:44
 * @Version V1.0
 */
@Aspect
@Component
@Order(1)
public class WebLogAspect {


    @Pointcut("execution(public * site.fish119.adminss.controller..*.*(..))")
    public void webLog() {
    }

    private ThreadLocal<LogContent> logContent = new ThreadLocal<>();

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Long id;
        try {
            id = ((UserDetailsImple) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        } catch (Exception e) {
            id = null;
        }
        LogContent lt = new LogContent();
        lt.setStartTime(System.currentTimeMillis());
        lt.setArgs(Arrays.toString(joinPoint.getArgs()));
        lt.setIp(getIpAddress(request));
        lt.setHttpMethod(request.getMethod());
        lt.setUrl(request.getRequestURL().toString());
        lt.setUserId(id);
        lt.setClassName(joinPoint.getSignature().getDeclaringTypeName());
        logContent.set(lt);
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        Logger logger = LoggerFactory.getLogger(logContent.get().getClassName());
        LogContent lt = logContent.get();
        String message;
        try{
            message = ((ResponseEntity)ret).getStatusCodeValue()+"::"+((ResponseEntity)ret).getStatusCode().name();
        }catch (Exception e){
            message = ret.toString();
        }
        logger.info(message, lt.getUserId(), lt.getHttpMethod() + "::" + lt.getUrl(), System.currentTimeMillis() - lt.getStartTime(), lt.getIp());
    }

    private String getIpAddress(HttpServletRequest request){
        String ip = request.getHeader("X-Forwarded-For");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if(index != -1){
                return ip.substring(0,index);
            }else{
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            return ip;
        }
        return request.getRemoteAddr();
    }

    public class LogContent {
        private Long startTime;
        private String url;
        private String httpMethod;
        private String ip;
        private String method;
        private String args;
        private Long userId;
        private String className;

        public Long getStartTime() {
            return startTime;
        }

        public void setStartTime(Long startTime) {
            this.startTime = startTime;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHttpMethod() {
            return httpMethod;
        }

        public void setHttpMethod(String httpMethod) {
            this.httpMethod = httpMethod;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public String getArgs() {
            return args;
        }

        public void setArgs(String args) {
            this.args = args;
        }
    }
}
