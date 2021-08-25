package diaryApplication.diary.repository;

import diaryApplication.diary.domain.friend.Friend;
import diaryApplication.diary.domain.member.Member;
import diaryApplication.diary.domain.member.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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

    public void save(Friend friend1, Friend friend2) { // 친구 수락 상태
        friend1.isAccept(true);
        friend2.isAccept(true);
    }

    public List<MemberDto> findAll(Long id) { // 친구 조회
        List<Friend> friends;
        List<MemberDto> memberDtos = new ArrayList<>();

        try {
            friends = em.createQuery("SELECT f FROM Friend f WHERE f.memberId_1 = :id and f.accept = true", Friend.class)
                    .setParameter("id", id)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        }

        for (Friend friend : friends) {
            MemberDto memberDto = new MemberDto();
            memberDto.findMemberDtos(friend.getMemberId_2());
            memberDtos.add(memberDto);
        }

        return memberDtos;
    }

    public void remove(Long memberId_1, Member memberId_2) { // 친구 삭제
        Friend friend = em.createQuery("SELECT f FROM Friend f WHERE f.memberId_1 = :memberId_1 and f.memberId_2 = :memberId_2",
                Friend.class)
                .setParameter("memberId_1", memberId_1)
                .setParameter("memberId_2", memberId_2)
                .getSingleResult();

        em.remove(friend);
    }

    public List<MemberDto> findRequest(Long id) {
        List<Friend> friends;
        List<MemberDto> memberDtos = new ArrayList<>();

        try {
            friends = em.createQuery("SELECT f FROM Friend f WHERE f.memberId_1 = :id and f.targetId = :id and f.accept = false",
                    Friend.class)
                    .setParameter("id", id)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        }

        for (Friend friend : friends) {
            MemberDto memberDto = new MemberDto();
            memberDto.findMemberDtos(friend.getMemberId_2());
            memberDtos.add(memberDto);
        }

        return memberDtos;
    }

    /**
     * 친구 수락을 위해 생성한 메서드로, Friend 테이블에 올라가 있는 두개의 튜플을 뽑아내는 메서드
     */
    public Friend findSet(Long memberId_1, Member memberId_2) {
        Friend friend = em.createQuery("SELECT f FROM Friend f WHERE f.memberId_1 = :memberId_1 and f.memberId_2 = :memberId_2",
                Friend.class)
                .setParameter("memberId_1", memberId_1)
                .setParameter("memberId_2", memberId_2)
                .getSingleResult();

        return friend;
    }

    /**
     * 중복으로 친구 신청을 한 경우 혹은 친구 상태임에도 친구 추가를 하려고 한 경우에 실행되는 메서드로,
     * memberId를 통해 Friend 테이블에 튜플이 있는지 확인하는 용도
     */
    public Boolean findById(Long memberId_1, String memberId_2_nickname) {
        Friend friend;
        Member member = em.createQuery("SELECT m FROM Member m WHERE m.nickname = :memberId_2_nickname",
                Member.class)
                .setParameter("memberId_2_nickname", memberId_2_nickname)
                .getSingleResult();

        try {
            friend = em.createQuery("SELECT f FROM Friend f WHERE f.memberId_1 = :memberId_1 and f.memberId_2 = :memberId_2",
                    Friend.class)
                    .setParameter("memberId_1", memberId_1)
                    .setParameter("memberId_2", member)
                    .getSingleResult();
        } catch (NoResultException e){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
