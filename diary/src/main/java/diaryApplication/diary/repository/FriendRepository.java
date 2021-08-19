package diaryApplication.diary.repository;

import diaryApplication.diary.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class FriendRepository {

    private final EntityManager em;

    public void add(Member memberId1, Member memberId2) { // 친구 추가
        em.persist(memberId1);
        em.persist(memberId2);
    }
}
