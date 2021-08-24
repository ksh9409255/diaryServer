package diaryApplication.diary.repository;

import diaryApplication.diary.domain.category.Category;
import diaryApplication.diary.domain.member.Member;
import diaryApplication.diary.domain.member_category.MemberCategoryRelation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    public void save(Member member){
        Category category = em.find(Category.class,member.getCategoryId());
        MemberCategoryRelation relation = new MemberCategoryRelation(member,category);
        em.persist(member);
        em.persist(relation);
    }

    public Member findById(Long id){
        return em.find(Member.class,id);
    }

    public void remove(Long id){
        em.remove(findById(id));
    }
}
