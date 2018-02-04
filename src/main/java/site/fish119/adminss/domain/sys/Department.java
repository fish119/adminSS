package site.fish119.adminss.domain.sys;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import site.fish119.adminss.domain.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(of = {"id"}, callSuper = true)
@Entity
@Table(name = "sys_department")
@Data
public class Department extends BaseEntity {
    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private Long sort;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "parent_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
    private Department parent;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderBy("sort ASC")
    @JoinColumn(name = "parent_id")
    private Set<Department> children = new HashSet<>(0);

    @OneToMany(fetch= FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="dept_id")
    @JsonIgnore
    private Set<User> users;
}
