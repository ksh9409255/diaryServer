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

    public void save(Diary diary) { // 일기 작성
         em.persist(diary);
    }

    public void findAll() {

    }

    public DiaryDto findOne(Long id) {
        Diary diary = em.find(Diary.class, id);
        DiaryDto diaryDto = new DiaryDto(diary.isOpen(), diary.getTitle(), diary.getContent(), diary.getDate(),
                diary.getEmoticonId().getId(), diary.getMemberId().getId());

        return diaryDto;
    }

    public void remove() {

    }

    public void modify() {

    }
}
