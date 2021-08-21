package diaryApplication.diary.controller;

import diaryApplication.diary.domain.diary.DiaryDto;
import diaryApplication.diary.domain.diary.DiaryModifyDto;
import diaryApplication.diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService diaryService;

    @PostMapping("/diary/save")
    public ResponseEntity save(@RequestBody DiaryDto diaryDto) {
        diaryService.save(diaryDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    public void findAll() {

    }

    @GetMapping("/diary/findOne")
    public ResponseEntity<DiaryDto> findOne(@RequestParam("id") Long id) {
        return new ResponseEntity<>(diaryService.findOne(id), HttpStatus.OK);
    }

    @GetMapping("/diary/remove")
    public ResponseEntity remove(Long id) {
        diaryService.remove(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/diary/modify")
    public ResponseEntity modify(@RequestBody DiaryModifyDto diaryModifyDto) {
        diaryService.modify(diaryModifyDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
