package diaryApplication.diary.service;

import diaryApplication.diary.domain.friend.Friend;
import diaryApplication.diary.domain.friend.FriendDto;
import diaryApplication.diary.domain.member.MemberDto;
import diaryApplication.diary.repository.FriendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FriendService {

    private final FriendRepository friendRepository;

    public void add(FriendDto friendDto) {
        Friend friend1 = new Friend();
        Friend friend2 = new Friend();

        friend1.add(friendDto.getMemberId_1(), friendDto.getMemberId_2(), friendDto.getMemberId_2().getId());
        friend2.add(friendDto.getMemberId_2(), friendDto.getMemberId_1(), friendDto.getMemberId_2().getId());

        friendRepository.add(friend1, friend2);
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

    public Friend findById(FriendDto friendDto) {
        return friendRepository.findById(friendDto.getMemberId_1().getId(), friendDto.getMemberId_2());
    }
}
