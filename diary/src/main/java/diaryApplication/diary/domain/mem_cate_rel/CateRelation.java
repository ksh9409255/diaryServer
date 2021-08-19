package diaryApplication.diary.domain.mem_cate_rel;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "mem_cate_rel")
@Getter
public class CateRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mem_cate_rel_id",nullable = false,unique = true)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Long memberId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private int categoryId;
}
