package site.fish119.adminss.domain.sys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sys_menu")
@Data
@EqualsAndHashCode(exclude="parentMenu")
public class Menu implements Serializable {
    private static final long serialVersionUID = -1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String action;
    private String icon;
    private String title;
    @OrderColumn
    private Long sort;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    @JsonIgnore
    private Menu parentMenu;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "parentMenu")
    @OrderBy("sort ASC")
    private Set<Menu> childrenMenu = new HashSet<>(0);

    @JsonIgnore
    @ManyToMany(mappedBy="menus")
    private Set<User> users = new HashSet<>(0);
}
