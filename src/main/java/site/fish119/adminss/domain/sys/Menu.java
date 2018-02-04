package site.fish119.adminss.domain.sys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import site.fish119.adminss.domain.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(of = {"id"}, callSuper = true)
@Entity
@Table(name = "sys_menu")
@Data
public class Menu extends BaseEntity {
    private static final long serialVersionUID = -1L;
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
}
