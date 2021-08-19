package diaryApplication.diary.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class FriendRepository {

    private final EntityManager em;

    public void add(Long memberId1, Long memberId2) { // 친구 추가
        em.persist(memberId1);
        em.persist(memberId2);
    }

    public void findAll(Long member) { // 친구 조회
        em.persist(member);
    }

    public void delete(Long memberId1, Long memberId2) { // 친구 삭제

    }
}
