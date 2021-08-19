package diaryApplication.diary.controller;

import diaryApplication.diary.domain.friend.FriendDto;
import diaryApplication.diary.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class FriendController {

    private final FriendService friendService;

    @PostMapping("/friend")
    public void save(@RequestBody FriendDto friendDto) {
        friendService.save(friendDto.getMemberId_1(), friendDto.getMemberId_2());
    }

    @GetMapping("/friend")
    public void findAll(@RequestParam("id") Long id) {
        friendService.findAll(id);
    }
}
