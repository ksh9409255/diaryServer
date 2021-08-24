package diaryApplication.diary.service;

import diaryApplication.diary.domain.category.Category;
import diaryApplication.diary.domain.category.CategoryDto;
import diaryApplication.diary.domain.member.Member;
import diaryApplication.diary.domain.member.MemberDto;
import diaryApplication.diary.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
@Rollback(value = false)
class MemberServiceTest {

    @Autowired
    CategoryService categoryService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    @Test
    void registerMember() {
        CategoryDto category = new CategoryDto("potato");
        categoryService.register(category);
        MemberDto memberDto1 = new MemberDto(1L,"KIM",1);
        memberRepository.save(memberDto1.toEntity());
    }

    @Test
    void findById() {
        MemberDto memberDto1 = new MemberDto(1L,"KIM",1);
        memberRepository.save(memberDto1.toEntity());
        System.out.println(memberRepository.findById(1L).getNickname());
    }

    @Test
    void checkRegister() {
        MemberDto memberDto1 = new MemberDto(1L,"KIM",1);
        memberRepository.save(memberDto1.toEntity());
        //System.out.println(memberService.checkRegister(1L)); // 회원 아닌경우
        System.out.println(memberService.checkRegister(2L)); // 회원 인 경우
    }

    @Test
    void deleteMember() {
        MemberDto memberDto1 = new MemberDto(1L,"KIM",1);
        memberRepository.save(memberDto1.toEntity());
        memberRepository.remove(1L);
    }

    @Test
    void updateMember() {
        MemberDto memberDto1 = new MemberDto(1L,"KIM",1);
        memberRepository.save(memberDto1.toEntity());
        memberService.updateMember(new MemberDto(1L,"SEOR",2));
        System.out.println(memberService.findById(1L).getNickName());
    }
}