package site.fish119.adminss.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity()
@Table(name = "sys_authority")
@Data
public class SysAuthority implements Serializable , GrantedAuthority {
    private static final long serialVersionUID = -1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String url;

    private String description;

    private Long sort;

    private String method;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private SysAuthority parent;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parent")
    private Set<SysAuthority> children = new HashSet<>(0);

    @JsonIgnore
    @ManyToMany(mappedBy="authorities",fetch = FetchType.EAGER)
    private Set<SysRole> roles = new HashSet<>(0);

    public String getPermissionUrl() {
        return url;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.url = permissionUrl;
    }

    @Override
    public String getAuthority() {
        return this.url + ";" + this.method;
    }
}
