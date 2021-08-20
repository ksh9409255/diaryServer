package diaryApplication.diary.repository;

import diaryApplication.diary.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    public Member findById(Long id){
        return em.find(Member.class,id);
    }
}
