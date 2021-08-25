package diaryApplication.diary.service;

import diaryApplication.diary.domain.friend.Friend;
import diaryApplication.diary.domain.friend.FriendAddDto;
import diaryApplication.diary.domain.friend.FriendDto;
import diaryApplication.diary.domain.member.Member;
import diaryApplication.diary.domain.member.MemberDto;
import diaryApplication.diary.repository.FriendRepository;
import diaryApplication.diary.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FriendService {

    private final FriendRepository friendRepository;
    private final MemberRepository memberRepository;

    public ResponseEntity<Boolean> add(FriendAddDto friendAddDto) {
        if(!(memberRepository.validNickName(friendAddDto.getMemberId_2_nickname()))) {
            if(friendRepository.findById(friendAddDto.getMemberId_1().getId(), friendAddDto.getMemberId_2_nickname())) {
                Friend friend1 = new Friend();
                Friend friend2 = new Friend();
                Member member = memberRepository.findByNickname(friendAddDto.getMemberId_2_nickname());

                friend1.add(friendAddDto.getMemberId_1(), member, member.getId());
                friend2.add(member, friendAddDto.getMemberId_1(), member.getId());

                friendRepository.add(friend1, friend2);

                return new ResponseEntity(Boolean.TRUE, HttpStatus.OK);
            }
            else {
                return new ResponseEntity(Boolean.FALSE, HttpStatus.BAD_REQUEST); // 중복 요청
            }
        }
        else {
            return new ResponseEntity(Boolean.FALSE, HttpStatus.NOT_FOUND); // 유저가 없는 경우
        }
    }

    public void save(FriendDto friendDto) {
        Friend friend1 = friendRepository.findSet(friendDto.getMemberId_1().getId(), friendDto.getMemberId_2());
        Friend friend2 = friendRepository.findSet(friendDto.getMemberId_2().getId(), friendDto.getMemberId_1());

        friendRepository.save(friend1, friend2);
    }

    public List<MemberDto> findAll(Long id) {
        return friendRepository.findAll(id);
    }

    public void remove(FriendDto friendDto) {
        friendRepository.remove(friendDto.getMemberId_1().getId(), friendDto.getMemberId_2());
        friendRepository.remove(friendDto.getMemberId_2().getId(), friendDto.getMemberId_1());
    }
}
