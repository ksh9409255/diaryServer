package diaryApplication.diary.controller;

import diaryApplication.diary.domain.diary.DiaryDto;
import diaryApplication.diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService diaryService;

    @PostMapping("/diary")
    public ResponseEntity save(@RequestBody DiaryDto diaryDto) {
        diaryService.save(diaryDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    public void findAll() {

    }

    @GetMapping("/diary")
    public void findOne(@RequestParam Long id) {
        diaryService.findOne(id);
    }

    public void remove() {

    }

    public void modify() {

    }
}
