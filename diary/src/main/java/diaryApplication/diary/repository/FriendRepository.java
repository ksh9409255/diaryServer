package diaryApplication.diary.repository;

import diaryApplication.diary.domain.friend.Friend;
import diaryApplication.diary.domain.friend.FriendDto;
import diaryApplication.diary.domain.member.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class FriendRepository {

    private final EntityManager em;

    public void add(Friend friend1, Friend friend2) { // 친구 추가(요청이 들어온 상태)
        em.persist(friend1);
        em.persist(friend2);
    }

    public List<MemberDto> findAll(Long id) { // 친구 조회
        List<MemberDto> friends = new ArrayList<>();

    }
}
