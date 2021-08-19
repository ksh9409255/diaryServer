package diaryApplication.diary.domain.mem_cate_rel;

import diaryApplication.diary.domain.category.Category;
import diaryApplication.diary.domain.member.Member;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "mem_cate_rel")
@Getter
public class CateRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mem_cate_rel_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member memberId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category categoryId;
}
