package diaryApplication.diary.repository;

import diaryApplication.diary.domain.diary.Diary;
import diaryApplication.diary.domain.diary.DiaryDto;
import diaryApplication.diary.domain.diary.DiaryFindDto;
import diaryApplication.diary.domain.diary.DiaryModifyDto;
import diaryApplication.diary.domain.emoticon.Emoticon;
import diaryApplication.diary.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DiaryRepository {

    private final EntityManager em;

    public Long save(Diary diary) { // 일기 작성
         em.persist(diary);
         return diary.getId();
    }

    public List<DiaryFindDto> findAll(Long id) {
        Member member = em.find(Member.class, id);
        List<Diary> diaryList = em.createQuery("SELECT d FROM Diary d WHERE d.memberId = :member", Diary.class)
                .setParameter("member", member)
                .getResultList();
        List<DiaryFindDto> diaryFindDtoList = new ArrayList<>();

        for (Diary diary : diaryList) {
            DiaryFindDto diaryFindDto = new DiaryFindDto(diary.getId(), diary.isOpen(),
                    diary.getTitle(), diary.getDate(), diary.getEmoticonId().getId());
            diaryFindDtoList.add(diaryFindDto);
        }

        return diaryFindDtoList;
    }

    public DiaryDto findOne(Long id) {
        Diary diary = em.find(Diary.class, id);
        DiaryDto diaryDto = new DiaryDto(diary.isOpen(), diary.getTitle(), diary.getContent(), diary.getDate(),
                diary.getEmoticonId().getId(), diary.getMemberId().getId());

        return diaryDto;
    }

    public void remove(Long id) {
        Diary diary = em.find(Diary.class, id);

        em.remove(diary);
    }

    public void modify(DiaryModifyDto diaryModifyDto) {
        Diary diary = em.find(Diary.class, diaryModifyDto.getId());
        Emoticon emoticon = em.find(Emoticon.class, diaryModifyDto.getEmoticonId());

        diary.modify(diary, diaryModifyDto, emoticon);
    }
}
