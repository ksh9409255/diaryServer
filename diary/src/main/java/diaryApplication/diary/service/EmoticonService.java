package diaryApplication.diary.service;

import diaryApplication.diary.domain.category.Category;
import diaryApplication.diary.domain.category.CategoryDto;
import diaryApplication.diary.domain.emoticon.Emoticon;
import diaryApplication.diary.domain.emoticon.EmoticonDto;
import diaryApplication.diary.domain.member.MemberDto;
import diaryApplication.diary.domain.member_emoticon.MemberEmoticonRelation;
import diaryApplication.diary.repository.CategoryRepository;
import diaryApplication.diary.repository.EmoticonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class EmoticonService {
    private final EmoticonRepository emoticonRepository;
    private final CategoryRepository categoryRepository;

    public void register(EmoticonDto emoticon){
        emoticonRepository.save(emoticon.toEntity());
    }

    public void registerEmoticon(Long id){
        MemberEmoticonRelation relation = new MemberEmoticonRelation();

    }
}
