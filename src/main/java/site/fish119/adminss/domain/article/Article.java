package site.fish119.adminss.domain.article;

import lombok.Data;
import lombok.EqualsAndHashCode;
import site.fish119.adminss.domain.BaseEntity;
import site.fish119.adminss.domain.sys.User;

import javax.persistence.*;

/**
 * @Project adminss
 * @Package site.fish119.adminss.domain.article
 * @Author fish119
 * @Date 2018/1/28 16:29
 * @Version V1.0
 */
@EqualsAndHashCode(of = {"id"}, callSuper = true)
@Entity
@Table(name = "article_article")
@Data
public class Article extends BaseEntity {
    private static final long serialVersionUID = -1L;

    @Column(nullable = false)
    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private User author;
}
