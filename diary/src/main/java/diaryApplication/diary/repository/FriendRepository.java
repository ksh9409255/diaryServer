package diaryApplication.diary.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class FriendRepository {

    private final EntityManager em;

    public void add(Long memberId_1, Long memberId_2) { // 친구 추가 // Friend 생성
        em.persist(memberId_1);
        em.persist(memberId_2);
    }
}
