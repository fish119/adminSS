package site.fish119.adminss.secruity;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthRequest implements Serializable {
    private static final long serialVersionUID = -8445943548965154778L;

    private String username;
    private String password;

    public AuthRequest() {
        super();
    }

    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}