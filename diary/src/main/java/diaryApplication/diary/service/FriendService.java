package diaryApplication.diary.service;

import diaryApplication.diary.repository.FriendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FriendService {

    private final FriendRepository friendRepository;

    public void add(Long memberId_1, Long memberId_2) { // 친구 추가
        friendRepository.add(memberId_1, memberId_2);
    }
}
