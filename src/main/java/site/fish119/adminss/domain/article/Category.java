package site.fish119.adminss.domain.article;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import site.fish119.adminss.domain.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Project adminss
 * @Package site.fish119.adminss.domain.article
 * @Author fish119
 * @Date 2018/1/28 16:29
 * @Version V1.0
 */
@EqualsAndHashCode(of = {"id"}, callSuper = false)
@Entity
@Table(name = "article_category")
@Data
public class Category extends BaseEntity {
    private static final long serialVersionUID = -1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
    private Long sort;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Set<Article> articles;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "parent_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private Category parent;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderBy("sort ASC")
    @JoinColumn(name = "parent_id")
    private Set<Category> children = new HashSet<>(0);

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        if (sameParent(parent))
            return;
        Category oldParent = this.parent;
        this.parent = parent;
        if (oldParent != null) {
            oldParent.getChildren().remove(this);
        }
        if (parent != null) {
            parent.getChildren().add(this);
        }
    }

    private boolean sameParent(Category newParent) {
        return parent == null ? newParent == null : parent.equals(newParent);
    }
}
