package diaryApplication.diary.service;

import diaryApplication.diary.domain.category.Category;
import diaryApplication.diary.domain.category.CategoryDto;
import diaryApplication.diary.domain.emoticon.Emoticon;
import diaryApplication.diary.domain.emoticon.EmoticonDto;
import diaryApplication.diary.domain.member.Member;
import diaryApplication.diary.domain.member.MemberDto;
import diaryApplication.diary.domain.member_emoticon.MemberEmoticonRelation;
import diaryApplication.diary.repository.CategoryRepository;
import diaryApplication.diary.repository.EmoticonRepository;
import diaryApplication.diary.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EmoticonService {
    private final EmoticonRepository emoticonRepository;
    private final CategoryRepository categoryRepository;
    private final MemberRepository memberRepository;

    public void register(EmoticonDto emoticon){
        emoticonRepository.save(emoticon.toEntity());
    }

    /**
     * 멤버이모티콘을 초기 등록해주는 서비스
     * @param id : 멤버id
     * @param categoryId : 카테고리id
     */
    public void initMemberEmoticon(Long id,int categoryId){
        Member member = memberRepository.findById(id);
        List<Emoticon> emoticonList = emoticonRepository.findByCategoryId(categoryId);
        for(Emoticon emoticon : emoticonList){
            emoticonRepository.saveMemberEmoticon(member,emoticon);
        }
    }
}
