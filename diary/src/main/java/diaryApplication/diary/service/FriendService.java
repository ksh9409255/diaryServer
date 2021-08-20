package diaryApplication.diary.service;

import diaryApplication.diary.domain.friend.Friend;
import diaryApplication.diary.domain.friend.FriendDto;
import diaryApplication.diary.repository.FriendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class FriendService {

    private final FriendRepository friendRepository;

    public void add(FriendDto friendDto) {
        Friend friend1 = new Friend();
        Friend friend2 = new Friend();

        friend1.add(friendDto.getMemberId_1(), friendDto.getMemberId_2(), friendDto.getMemberId_2());
        friend2.add(friendDto.getMemberId_2(), friendDto.getMemberId_1(), friendDto.getMemberId_2());

        friendRepository.add(friend1, friend2);
    }

    public void save(FriendDto friendDto) {
        friendRepository.save(friendDto.getMemberId_1(), friendDto.getMemberId_2());
    }

//    public void findAll(Long id) {
//        friendRepository.findAll(id);
//    }
}
