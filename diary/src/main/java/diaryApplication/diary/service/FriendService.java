package diaryApplication.diary.service;

import diaryApplication.diary.repository.FriendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FriendService {

    private final FriendRepository friendRepository;

    public void add(Long memberId1, Long memberId2) { // 친구 추가
        friendRepository.add(memberId1, memberId2);
    }
}
