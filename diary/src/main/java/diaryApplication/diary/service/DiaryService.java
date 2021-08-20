package diaryApplication.diary.service;

import diaryApplication.diary.domain.diary.Diary;
import diaryApplication.diary.domain.diary.DiaryDto;
import diaryApplication.diary.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DiaryService {

    private final DiaryRepository diaryRepository;

    public void write(DiaryDto diaryDto) {
        Diary diary = new Diary();
        diary.write(diaryDto);

        diaryRepository.write(diary);
    }
}
