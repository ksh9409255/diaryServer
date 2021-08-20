package diaryApplication.diary.repository;

import diaryApplication.diary.domain.diary.Diary;
import diaryApplication.diary.domain.diary.DiaryDto;
import diaryApplication.diary.domain.emoticon.Emoticon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class DiaryRepository {

    private final EntityManager em;

    public void write(Diary diary) {
         em.persist(diary);
    }
}
