package site.fish119.adminss.domain.sys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import site.fish119.adminss.domain.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@EqualsAndHashCode(of = {"id"}, callSuper = true)
@Entity()
@Table(name = "sys_role")
@Data
public class Role extends BaseEntity {
    private static final long serialVersionUID = -1L;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = true)
    private Long sort;

    @JsonIgnore
    @ManyToMany(mappedBy="roles")
    private Set<User> users = new HashSet<>(0);


    @ManyToMany(targetEntity = Authority.class, fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "ROLE_ID"),
            inverseJoinColumns = @JoinColumn(name = "Authority_ID"))
    @OrderBy("sort ASC")
    private Set<Authority> authorities = new HashSet<>(0);


    @ManyToMany(targetEntity = Menu.class, fetch = FetchType.EAGER)
    @JoinTable(name="sys_role_menus", joinColumns = @JoinColumn(name = "ROLE_ID"),
            inverseJoinColumns = @JoinColumn(name = "MENU_ID"))
    @OrderBy("sort ASC")
    private Set<Menu> menus = new HashSet<>(0);
}
