package diaryApplication.diary.controller;

import diaryApplication.diary.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FriendController {

    private final FriendService friendService;

    public void add(Long memberId_1, Long memberId_2) {
        friendService.add(memberId_1, memberId_2);
    }
}
