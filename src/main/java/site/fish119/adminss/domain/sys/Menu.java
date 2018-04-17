package site.fish119.adminss.domain.sys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import site.fish119.adminss.domain.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(of = {"id"}, callSuper = false)
@Entity
@Table(name = "sys_menu")
@Data
public class Menu extends BaseEntity {
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

    @ManyToMany(mappedBy="menus")
    @OrderBy("sort ASC")
    @Getter(onMethod = @__( @JsonIgnore ))
    private Set<Role> mRoles = new HashSet<>(0);

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        if (sameParent(parent))
            return;
        Menu oldParent = this.parent;
        this.parent = parent;
        if (oldParent != null) {
            oldParent.getChildren().remove(this);
        }
        if (parent != null && !parent.getChildren().contains(this)) {
            parent.getChildren().add(this);
        }
    }

    private boolean sameParent(Menu newParent) {
        return parent == null ? newParent == null : parent.equals(newParent);
    }
}
