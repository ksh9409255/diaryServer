package diaryApplication.diary.repository;

import diaryApplication.diary.domain.category.Category;
import diaryApplication.diary.domain.emoticon.Emoticon;
import diaryApplication.diary.domain.member.Member;
import diaryApplication.diary.domain.member_category.MemberCategoryRelation;
import diaryApplication.diary.domain.member_emoticon.MemberEmoticonRelation;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;
    private final EmoticonRepository emoticonRepository;
    private final CategoryRepository categoryRepository;

    public void save(Member member){
        Category category = em.find(Category.class,member.getCategoryId());
        MemberCategoryRelation relation = new MemberCategoryRelation(member,category);
        em.persist(member);
        em.persist(relation);
        List<Emoticon> emoticonList = emoticonRepository
                .findByCategoryId(categoryRepository.findById(member.getCategoryId()));
        for(Emoticon emoticon : emoticonList){
            emoticonRepository.saveMemberEmoticon(member,emoticon);
        }
    }

    public Member findById(Long id){
        Member member = em.find(Member.class,id);
        return member;
    }

    public void remove(Long id){
        List<MemberCategoryRelation> relationList1 = em.createQuery(
                "select r from MemberCategoryRelation r where r.memberId=:memberId")
                .setParameter("memberId",findById(id))
                .getResultList();
        for(MemberCategoryRelation relation :relationList1){
            em.remove(relation);
        }
        List<MemberEmoticonRelation> relationList2 = em.createQuery(
                "select r from MemberEmoticonRelation r where r.memberId=:memberId")
                .setParameter("memberId",findById(id))
                .getResultList();
        for(MemberEmoticonRelation relation :relationList2){
            em.remove(relation);
        }
        em.remove(findById(id));
    }

    /**
     * FriendController에서 닉네임 존재 여부 확인을 위한 메서드
     */
    public void findByNickname(String nickname) {
        Member member;

        try {
            em.createQuery("SELECT m FROM Member m WHERE m.nickname = :nickname", Member.class)
                    .setParameter("nickname", nickname)
                    .getSingleResult();
        } catch (Exception e) {
           new IllegalStateException("존재하지 않는 회원입니다.");
        }
    }

    public Boolean validNickName(String name) {
        Member member;
        try{
            member = em.createQuery("select m from Member m where m.nickname = :nickname",Member.class)
                    .setParameter("nickname",name)
                    .getSingleResult();
        }catch (NoResultException e){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
