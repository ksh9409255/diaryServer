package diaryApplication.diary.repository;

import diaryApplication.diary.domain.category.Category;
import diaryApplication.diary.domain.emoticon.Emoticon;
import diaryApplication.diary.domain.emoticon.EmoticonDto;
import diaryApplication.diary.domain.member.Member;
import diaryApplication.diary.domain.member_emoticon.MemberEmoticonRelation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmoticonRepository {
    private final EntityManager em;

    public void save(Emoticon emoticon){
        em.persist(emoticon);
    }

    public Emoticon findById(int id){
        return em.find(Emoticon.class,id);
    }

    public List<Emoticon> findByCategoryId(Category id){
        return em.createQuery("select e from Emoticon e " +
                "where e.categoryId=:id")
                .setParameter("id",id)
                .getResultList();
    }

    /**
     * 멤버에 이모티콘을 등록해주는 메서드
     * @param member
     * @param emoticon : 멤버에 등록될 이모티콘
     */
    public void saveMemberEmoticon(Member member,Emoticon emoticon){
        MemberEmoticonRelation memberEmoticonRelation = new MemberEmoticonRelation(member,emoticon);
        em.persist(memberEmoticonRelation);
    }
}
