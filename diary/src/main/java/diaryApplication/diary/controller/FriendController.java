package diaryApplication.diary.controller;

import diaryApplication.diary.domain.friend.FriendAndroidDto;
import diaryApplication.diary.domain.friend.FriendDto;
import diaryApplication.diary.domain.member.MemberDto;
import diaryApplication.diary.service.FriendService;
import diaryApplication.diary.service.KakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FriendController {

    private final FriendService friendService;
    private final KakaoService kakaoService;

    @PostMapping("/friend/add")
    public ResponseEntity<Boolean> add(@RequestBody FriendAndroidDto friendAndroidDto, HttpServletRequest req) {
        if(kakaoService.getUserInfo(req.getHeader("Authorization")).get("id")
                .equals(String.valueOf(friendAndroidDto.getMemberId_1().getId()))){
            return friendService.add(friendAndroidDto);
        }
        else{
            System.out.println("=================================");
            return new ResponseEntity(Boolean.FALSE,HttpStatus.OK);
        }
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
        return friendService.remove(friendAndroidDto);
    }

    /**
     * 친구 요청 List
     */
    @GetMapping("/friend/request")
    public ResponseEntity<List<MemberDto>> findRequest(@RequestParam("id") Long id) {
        return new ResponseEntity<>(friendService.findRequest(id), HttpStatus.OK);
    }

    @GetMapping("/friend")
    public ResponseEntity<MemberDto> getFriend(@RequestParam("id") Long id) {
        return new ResponseEntity<>(friendService.getFriend(id), HttpStatus.OK);
    }
}
