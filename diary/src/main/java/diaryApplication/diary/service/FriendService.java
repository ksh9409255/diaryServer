package diaryApplication.diary.service;

import diaryApplication.diary.domain.friend.Friend;
import diaryApplication.diary.repository.FriendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class FriendService {

    private final FriendRepository friendRepository;

    public void save(Long memberId_1, Long memberId_2) {
        Friend friend1 = new Friend();
        Friend friend2 = new Friend();

        friend1.save(memberId_1, memberId_2, memberId_2);
        friend2.save(memberId_2, memberId_1, memberId_2);

        friendRepository.save(friend1, friend2);
    }

    public void findAll(Long id) {
        friendRepository.findAll(id);
    }
}
