package diaryApplication.diary.domain.member_category;

import diaryApplication.diary.domain.category.Category;
import diaryApplication.diary.domain.member.Member;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "member_category")
@Getter
public class MemberCategoryRelation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member memberId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category categoryId;
}
