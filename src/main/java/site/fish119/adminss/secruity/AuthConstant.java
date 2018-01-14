package site.fish119.adminss.secruity;

public class AuthConstant {
    public static final String tokenHeader = "Authorization";
    static final String secret = "7945fb2b22546bf6e9290a68312cb033";
    public static final String tokenPrefix = "fish119";
    static final String CLAIM_KEY_USERNAME = "sub";
    static final String CLAIM_KEY_CREATED = "created";
    static final long expiration = 30*24*60*60*1000L;//1 month
//    static final long expiration = 604800 * 1000;//1 week
//    static final long expiration = 3*1000;
}
