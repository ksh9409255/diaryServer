package diaryApplication.diary.controller;

import diaryApplication.diary.domain.diary.DiaryDto;
import diaryApplication.diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService diaryService;

    @PostMapping("/diary")
    public void write(@RequestParam DiaryDto diaryDto) {
        diaryService.write(diaryDto);
    }
}
