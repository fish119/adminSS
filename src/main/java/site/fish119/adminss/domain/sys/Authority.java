package site.fish119.adminss.domain.sys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import site.fish119.adminss.domain.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@EqualsAndHashCode(of = {"id"}, callSuper = true)
@Entity()
@Table(name = "sys_authority")
@Data
public class Authority extends BaseEntity implements GrantedAuthority {
    private static final long serialVersionUID = -1L;

    private String name;

    @Column(columnDefinition="/")
    private String url;

    private String description;

    private Long sort;

    private String method;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    @JsonIgnore
    private Authority parent;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parent")
    @OrderBy("sort ASC")
    private Set<Authority> children = new HashSet<>(0);

    @JsonIgnore
    @ManyToMany(mappedBy="authorities",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @OrderBy("sort ASC")
    private Set<Role> roles = new HashSet<>(0);

    public String getPermissionUrl() {
        return url;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.url = permissionUrl;
    }

    @Override
    @JsonIgnore
    public String getAuthority() {
        return this.url + ";" + this.method;
    }
}
