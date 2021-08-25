package diaryApplication.diary.controller;

import diaryApplication.diary.domain.friend.FriendAndroidDto;
import diaryApplication.diary.domain.friend.FriendDto;
import diaryApplication.diary.domain.member.MemberDto;
import diaryApplication.diary.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FriendController {

    private final FriendService friendService;

    @PostMapping("/friend/add")
    public ResponseEntity<Boolean> add(@RequestBody FriendAndroidDto friendAndroidDto) {
        return friendService.add(friendAndroidDto);
    }

    @PostMapping("/friend/save")
    public ResponseEntity save(@RequestBody FriendDto friendDto) {
        friendService.save(friendDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/friend/find")
    public ResponseEntity<List<MemberDto>> findAll(@RequestParam("id") Long id) {
        return new ResponseEntity<>(friendService.findAll(id), HttpStatus.OK);
    }

    @PostMapping("/friend/remove")
    public ResponseEntity<Boolean> remove(@RequestBody FriendAndroidDto friendAndroidDto) {
        friendService.remove(friendAndroidDto);
        return new ResponseEntity(Boolean.TRUE, HttpStatus.OK);
    }

    /**
     * 친구 요청 List
     */
    @GetMapping("/friend/request")
    public ResponseEntity<List<MemberDto>> findRequest(@RequestParam("id") Long id) {
        return new ResponseEntity<>(friendService.findRequest(id), HttpStatus.OK);
    }
}
