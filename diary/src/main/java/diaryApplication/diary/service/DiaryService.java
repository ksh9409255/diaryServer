package diaryApplication.diary.service;

import diaryApplication.diary.domain.diary.Diary;
import diaryApplication.diary.domain.diary.DiaryDto;
import diaryApplication.diary.domain.emoticon.Emoticon;
import diaryApplication.diary.domain.member.Member;
import diaryApplication.diary.repository.DiaryRepository;
import diaryApplication.diary.repository.EmoticonRepository;
import diaryApplication.diary.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DiaryService {

    private final DiaryRepository diaryRepository;
    private final EmoticonRepository emoticonRepository;
    private final MemberRepository memberRepository;

    public void save(DiaryDto diaryDto) {
        Emoticon emoticon = emoticonRepository.findById(diaryDto.getEmoticonId());
        Member member = memberRepository.findById(diaryDto.getMemberId());

        Diary diary = new Diary();
        diary.save(diaryDto, emoticon, member);

        diaryRepository.save(diary);
    }

    public void findAll() {

    }

    public void findOne(Long id) {
        diaryRepository.findOne(id);
    }

    public void remove() {

    }

    public void modify() {

    }
}
