package diaryApplication.diary.controller;

import diaryApplication.diary.domain.emoticon.EmoticonDto;
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
    public ResponseEntity emoticonInit(@RequestParam("memberId") Long memberId,
                                       @RequestParam("CategoryId") int categoryId){
        emoticonService.initMemberEmoticon(memberId,categoryId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<EmoticonDto>> findByCategoryId(@RequestParam("CategoryId") int categoryId){
        return new ResponseEntity(emoticonService.findByCategoryId(categoryId),HttpStatus.OK);
    }
}
