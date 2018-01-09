package site.fish119.adminss.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity()
@Table(name = "sys_authority")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private SysAuthority parent;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parent")
    private Set<SysAuthority> children = new HashSet<>(0);

    @JsonIgnore
    @ManyToMany(mappedBy="authorities",fetch = FetchType.EAGER)
    private Set<SysRole> roles = new HashSet<>(0);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public SysAuthority getParent() {
        return parent;
    }

    public void setParent(SysAuthority parent) {
        this.parent = parent;
    }

    public Set<SysAuthority> getChildren() {
        return children;
    }

    public void setChildren(Set<SysAuthority> children) {
        this.children = children;
    }

    public Set<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SysRole> roles) {
        this.roles = roles;
    }

    @Override

    public String getAuthority() {
        return this.name;
    }
}
