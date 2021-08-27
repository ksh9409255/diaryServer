package diaryApplication.diary.controller;

import diaryApplication.diary.domain.diary.DiaryDto;
import diaryApplication.diary.domain.diary.DiaryFindDto;
import diaryApplication.diary.domain.diary.DiaryModifyDto;
import diaryApplication.diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService diaryService;

    @PostMapping("/diary/save")
    public ResponseEntity<Long> save(@RequestBody DiaryDto diaryDto) {
        return new ResponseEntity<>(diaryService.save(diaryDto), HttpStatus.OK);
    }

    @GetMapping("/diary/findAll")
    public ResponseEntity<List<DiaryFindDto>> findAll(@RequestParam("id") Long id) {
        return new ResponseEntity<>(diaryService.findAll(id), HttpStatus.OK);
    }

    @GetMapping("/diary/findOne")
    public ResponseEntity<DiaryDto> findOne(@RequestParam("id") Long id) { // 다이어리 Id
        return new ResponseEntity<>(diaryService.findOne(id), HttpStatus.OK);
    }

    @GetMapping("/diary/remove")
    public ResponseEntity remove(@RequestParam("id") Long id) {
        diaryService.remove(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/diary/modify")
    public ResponseEntity modify(@RequestBody DiaryModifyDto diaryModifyDto) {
        diaryService.modify(diaryModifyDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
