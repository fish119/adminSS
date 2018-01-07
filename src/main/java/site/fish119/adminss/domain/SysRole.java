package site.fish119.adminss.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity()
@Table(name = "sys_role")
@Data
public class SysRole implements Serializable ,GrantedAuthority {
    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String authority;

    @JsonIgnore
    @ManyToMany(mappedBy="roles")
    private List<SysUser> users;

    @Override
    public String getAuthority(){
        return this.authority;
    }

    public String toString(){
        return this.authority;
    }
}
