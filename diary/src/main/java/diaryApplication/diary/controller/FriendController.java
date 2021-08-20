package diaryApplication.diary.controller;

import diaryApplication.diary.domain.friend.FriendDto;
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
    public ResponseEntity add(@RequestBody FriendDto friendDto) {
        friendService.add(friendDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/friend/save")
    public ResponseEntity save(@RequestBody FriendDto friendDto) {
        friendService.save(friendDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/friend")
    public ResponseEntity<List<Long>> findAll(@RequestParam("id") Long id) {
        return new ResponseEntity<>(friendService.findAll(id), HttpStatus.OK);
    }

    @PostMapping("/friend/remove")
    public ResponseEntity remove(@RequestBody FriendDto friendDto) {
        friendService.remove(friendDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
