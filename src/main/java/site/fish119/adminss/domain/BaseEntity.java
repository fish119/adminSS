package site.fish119.adminss.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Project adminss
 * @Package site.fish119.adminss.domain
 * @Author fish119
 * @Date 2018/2/4 17:38
 * @Version V1.0
 */
@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(nullable = false)
    private Date createTime;

    @UpdateTimestamp
    @Column(nullable = false)
    private Date updateTime;
}
