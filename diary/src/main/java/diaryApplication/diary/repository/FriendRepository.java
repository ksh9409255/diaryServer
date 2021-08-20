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

    public void add(Friend friend1, Friend friend2) { // 친구 요청이 들어와서 DB에 올라간 상태
        em.persist(friend1);
        em.persist(friend2);
    }

    public void save(Long memberId_1, Long memberId_2) { // 친구 수락 상태
        Friend friend1 = em.createQuery("SELECT f FROM Friend f WHERE f.memberId_1 = :memberId_1 and f.memberId_2 = :memberId_2",
                Friend.class).getSingleResult();
        Friend friend2 = em.createQuery("SELECT f FROM Friend f WHERE f.memberId_1 = :memberId_2 and f.memberId_2 = :memberId_1",
                Friend.class).getSingleResult();

        friend1.isAccept(true);
        friend2.isAccept(true);
    }

//    public List<MemberDto> findAll(Long id) { // 친구 조회
//        List<MemberDto> friends = new ArrayList<>();
//
//    }
}
