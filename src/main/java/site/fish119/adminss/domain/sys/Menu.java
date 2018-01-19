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
    private Long sort;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    @JsonIgnore
    private Menu parent;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "parent")
    @OrderBy("sort ASC")
    private Set<Menu> children = new HashSet<>(0);

    @JsonIgnore
    @ManyToMany(mappedBy="menus")
    @OrderBy("sort ASC")
    private Set<Role> mRoles = new HashSet<>(0);

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

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    public Set<Menu> getChildren() {
        return children;
    }

    public void setChildren(Set<Menu> children) {
        this.children = children;
    }

    public Set<Role> getmRoles() {
        return mRoles;
    }

    public void setmRoles(Set<Role> mRoles) {
        this.mRoles = mRoles;
    }

    @Override
    public int hashCode() {
        if(getId()!=null){
            return getId().hashCode();
        }
        else{
            return -1;
        }
    }

    @Override
    public boolean equals(final Object obj) {
        return this.getId().equals(((Menu) obj).getId());
    }
}
