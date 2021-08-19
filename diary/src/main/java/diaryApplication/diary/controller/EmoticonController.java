package diaryApplication.diary.controller;

import diaryApplication.diary.domain.emoticon.EmoticonDto;
import diaryApplication.diary.service.EmoticonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
