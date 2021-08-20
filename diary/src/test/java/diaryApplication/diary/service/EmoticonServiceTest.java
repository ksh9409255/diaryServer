package diaryApplication.diary.service;

import diaryApplication.diary.domain.category.Category;
import diaryApplication.diary.domain.category.CategoryDto;
import diaryApplication.diary.domain.emoticon.Emoticon;
import diaryApplication.diary.domain.emoticon.EmoticonDto;
import diaryApplication.diary.domain.member.Member;
import diaryApplication.diary.domain.member.MemberDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class EmoticonServiceTest {

    @Autowired
    EmoticonService emoticonService;

    @Autowired
    CategoryService categoryService;

    @Test
    void register() {
        CategoryDto category = new CategoryDto(1,"potato");
        categoryService.register(category);
        EmoticonDto emoticonDto = new EmoticonDto("angry potato",category,"angry");
        emoticonService.register(emoticonDto);
    }
    @Test
    void registerMemberEmo() {
        CategoryDto category = new CategoryDto("potato");
        categoryService.register(category);
        EmoticonDto emoticonDto = new EmoticonDto("angry potato",category,"angry");
        emoticonService.register(emoticonDto);

    }
}