package site.fish119.adminss.domain.sys;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sys_menu")
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    @JsonIgnore
    private Menu parentMenu;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "parentMenu")
    @OrderBy("sort ASC")
    private Set<Menu> childrenMenu = new HashSet<>(0);

    @JsonIgnore
    @ManyToMany(mappedBy="menus")
    private Set<User> users = new HashSet<>(0);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Menu getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(Menu parentMenu) {
        this.parentMenu = parentMenu;
    }

    public Set<Menu> getChildrenMenu() {
        return childrenMenu;
    }

    public void setChildrenMenu(Set<Menu> childrenMenu) {
        this.childrenMenu = childrenMenu;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
