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

import java.util.ArrayList;
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

    public void removeEmoticon(int id){
        emoticonRepository.remove(id);
    }

    public void updateEmoticon(int id, String name, String description){
        Emoticon emoticon = emoticonRepository.findById(id);
        emoticon.update(name,description);
    }

    /**
     * 멤버이모티콘을 초기 등록해주는 서비스
     */
    public void initMemberEmoticon(MemberDto memberDto){
        Member member = memberRepository.findById(memberDto.getId());
        List<Emoticon> emoticonList = emoticonRepository.findByCategoryId(categoryRepository.findById(memberDto.getCategoryId()));
        for(Emoticon emoticon : emoticonList){
            emoticonRepository.saveMemberEmoticon(member,emoticon);
        }
    }

    /**
     * 카테고리에 있는 모든 이모티콘들을 다 조회하는 서비스
     * @param categoryId : 카테고리 id
     * @return : 이모티콘dto 리스트
     */
    public List<EmoticonDto> findByCategoryId(int categoryId){
        List<Emoticon> emoticonList = emoticonRepository.findByCategoryId(categoryRepository.findById(categoryId));
        List<EmoticonDto> emoticonDtos = new ArrayList<>();
        for(Emoticon emoticon : emoticonList){
            EmoticonDto emoticonDto = new EmoticonDto(emoticon.getId(),emoticon.getName(),
                    new CategoryDto(emoticon.getCategoryId().getId(),emoticon.getCategoryId().getName())
                    , emoticon.getDescription());
            emoticonDtos.add(emoticonDto);
        }
        return emoticonDtos;
    }
}
