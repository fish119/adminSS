package site.fish119.adminss.domain.sys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import site.fish119.adminss.domain.BaseEntity;
import site.fish119.adminss.domain.article.Article;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@EqualsAndHashCode(of = {"id"}, callSuper = true)
@Entity
@Table(name = "sys_user")
@Data
public class User extends BaseEntity {
    private static final long serialVersionUID = -1L;

    @Column(nullable = false, unique = true)
    private String username;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    private Date lastPasswordResetDate;

    private String avatar;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(unique = true,nullable = true)
    private String email;

    @ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    @OrderBy("sort ASC")
    private Set<Role> roles = new HashSet<>(0);

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="dept_id")
    private Department department;

    @OneToMany(fetch= FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="author_id")
    @JsonIgnore
    private Set<Article> articles;
}
