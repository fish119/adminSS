package site.fish119.adminss.secruity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    public AuthenticationEntryPoint unauthorizedEntryPoint() {
        return (request, response, authException) -> {
            if (!response.isCommitted()) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "认证失败或权限不足，请重新登录或联系管理员");
            }
        };
    }


    @Autowired
    private UserDetailsServiceImple userDetailsService;

    @Autowired
    private SecurityInterceptorImple securityInterceptor;

    @Bean
    public AuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
        return new AuthenticationTokenFilter();
    }

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                // 设置UserDetailsService
                .userDetailsService(this.userDetailsService)
                // 使用BCrypt进行密码的hash
                .passwordEncoder(passwordEncoder());
    }

    // 装载BCrypt密码编码器
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //允许跨域
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**").allowedOrigins("*")
//                        .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
//                        .allowedHeaders("Authorization")
//                        .allowCredentials(false).maxAge(3600);
//            }
//        };
//    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
////        web.ignoring().antMatchers("/**");
////        web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui/**", "/swagger-resources/**", "/configuration/security/**", "/swagger-ui.html", "/webjars/**");
//    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        /**
         * important 跨域配置，重要！
         **/
        httpSecurity.cors().configurationSource(httpServletRequest -> {
            CorsConfiguration cc = new CorsConfiguration().applyPermitDefaultValues();
            cc.addAllowedMethod("*");
            return cc;
        });
//        httpSecurity.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
        httpSecurity
                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint()).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/druid/**", "/auth/**", "/api-docs/",
                        "/swagger-resources/**",
                        "/swagger-ui.html",
                        "/v2/api-docs",
                        "/webjars/**").permitAll()
                .antMatchers(
                        HttpMethod.GET,
                        "/",
                        "/*.html",
                        "/**/*.gif",
                        "/**/*.png",
                        "/*.jpg",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js"
                ).permitAll()
                .anyRequest().authenticated();

        // 添加JWT filter
        httpSecurity.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
        httpSecurity.addFilterBefore(securityInterceptor, FilterSecurityInterceptor.class);
        // 禁用缓存
        httpSecurity.headers().cacheControl().disable();
    }
}
