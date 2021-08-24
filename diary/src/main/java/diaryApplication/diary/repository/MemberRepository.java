package diaryApplication.diary.repository;

import diaryApplication.diary.domain.category.Category;
import diaryApplication.diary.domain.member.Member;
import diaryApplication.diary.domain.member_category.MemberCategoryRelation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

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
        Member member = em.find(Member.class,id);
        return member;
    }

    public void remove(Long id){
        List<MemberCategoryRelation> relationList = em.createQuery(
                "select r from MemberCategoryRelation r where r.memberId=:memberId")
                .setParameter("memberId",findById(id))
                .getResultList();
        for(MemberCategoryRelation relation :relationList){
            em.remove(relation);
        }
        em.remove(findById(id));
    }
}
