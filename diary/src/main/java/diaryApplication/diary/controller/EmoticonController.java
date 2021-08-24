package diaryApplication.diary.controller;

import diaryApplication.diary.domain.emoticon.EmoticonDto;
import diaryApplication.diary.domain.member.MemberDto;
import diaryApplication.diary.service.EmoticonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/emoticon")
public class EmoticonController {
    private final EmoticonService emoticonService;

    @PostMapping
    public ResponseEntity emoticonRegister(@RequestBody EmoticonDto emoticonDto){
        emoticonService.register(emoticonDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/init")
    public ResponseEntity emoticonInit(@RequestBody MemberDto memberDto){
        System.out.println("init");
        emoticonService.initMemberEmoticon(memberDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<EmoticonDto>> findByCategoryId(@RequestParam("categoryId") int categoryId){
        return new ResponseEntity(emoticonService.findByCategoryId(categoryId),HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteEmoticon(@RequestParam("id") int id){
        emoticonService.removeEmoticon(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity updateEmoticon(@RequestParam("id") int id,
                                         @RequestParam("name") String name,
                                         @RequestParam("description") String description){
        emoticonService.updateEmoticon(id,name,description);
        return new ResponseEntity(HttpStatus.OK);
    }
}
