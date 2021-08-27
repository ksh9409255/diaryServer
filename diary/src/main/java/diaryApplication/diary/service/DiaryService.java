package diaryApplication.diary.service;

import diaryApplication.diary.domain.diary.Diary;
import diaryApplication.diary.domain.diary.DiaryDto;
import diaryApplication.diary.domain.diary.DiaryFindDto;
import diaryApplication.diary.domain.diary.DiaryModifyDto;
import diaryApplication.diary.domain.emoticon.Emoticon;
import diaryApplication.diary.domain.member.Member;
import diaryApplication.diary.repository.DiaryRepository;
import diaryApplication.diary.repository.EmoticonRepository;
import diaryApplication.diary.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DiaryService {

    private final DiaryRepository diaryRepository;
    private final EmoticonRepository emoticonRepository;
    private final MemberRepository memberRepository;

    public Long save(DiaryDto diaryDto) {
        Emoticon emoticon = emoticonRepository.findById(diaryDto.getEmoticonId());
        Member member = memberRepository.findById(diaryDto.getMemberId());

        Diary diary = new Diary();
        diary.save(diaryDto, emoticon, member);

        return diaryRepository.save(diary);
    }

    public List<DiaryFindDto> findAll(Long id) {
        return diaryRepository.findAll(id);
    }

    public DiaryDto findOne(Long id) {
        return diaryRepository.findOne(id);
    }

    public void remove(Long id) {
        diaryRepository.remove(id);
    }

    public void modify(DiaryModifyDto diaryModifyDto) {
        diaryRepository.modify(diaryModifyDto);
    }
}
