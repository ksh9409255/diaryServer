package diaryApplication.diary.service;

import diaryApplication.diary.domain.category.Category;
import diaryApplication.diary.domain.category.CategoryDto;
import diaryApplication.diary.domain.emoticon.Emoticon;
import diaryApplication.diary.domain.emoticon.EmoticonDto;
import diaryApplication.diary.domain.member.Member;
import diaryApplication.diary.domain.member.MemberDto;
import diaryApplication.diary.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class EmoticonServiceTest {

    @Autowired
    EmoticonService emoticonService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void register() {
        CategoryDto category = new CategoryDto(1,"potato");
        categoryService.register(category);
        EmoticonDto emoticonDto = new EmoticonDto("angry potato",category,"angry");
        emoticonService.register(emoticonDto);
    }
    @Test
    void registerMemberEmo() {
        CategoryDto category = new CategoryDto(1,"potato");
        categoryService.register(category);
        EmoticonDto emoticonDto1 = new EmoticonDto("angry potato",category,"angry");
        emoticonService.register(emoticonDto1);
        EmoticonDto emoticonDto2 = new EmoticonDto("happy potato",category,"happy");
        emoticonService.register(emoticonDto2);
        Member member = new Member();
        memberRepository.save(member);
        emoticonService.initMemberEmoticon(1L,1);
    }

    @Test
    void findMemberEmo() {
        CategoryDto category = new CategoryDto(1,"potato");
        categoryService.register(category);
        EmoticonDto emoticonDto1 = new EmoticonDto("angry potato",category,"angry");
        emoticonService.register(emoticonDto1);
        EmoticonDto emoticonDto2 = new EmoticonDto("happy potato",category,"happy");
        emoticonService.register(emoticonDto2);
        Member member = new Member();
        memberRepository.save(member);
        System.out.println(emoticonService.findByCategoryId(1));
    }
}