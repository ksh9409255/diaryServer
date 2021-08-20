package diaryApplication.diary.service;

import diaryApplication.diary.domain.category.Category;
import diaryApplication.diary.domain.category.CategoryDto;
import diaryApplication.diary.domain.emoticon.EmoticonDto;
import diaryApplication.diary.domain.member.Member;
import diaryApplication.diary.domain.member_category.MemberCategoryRelation;
import diaryApplication.diary.repository.CategoryRepository;
import diaryApplication.diary.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final MemberRepository memberRepository;

    public void register(CategoryDto categoryDto){
        Category category = new Category(categoryDto.getName());
        categoryRepository.save(category);
    }

    public void remove(int id){
        categoryRepository.remove(id);
    }

    public List<CategoryDto> findAll(){
        return categoryRepository.findAll();
    }

    public void updateCategory(int id, String name){
        categoryRepository.changeCategoryName(id,name);
    }

    /**
     * 멤버에 카테고리를 추가해주는 서비스
     * @param memberId : 카테고리를 추가할 멤버의 id
     * @param categoryId : 추가할 카테고리
     */
    public void addMemberCategory(Long memberId, int categoryId){
        Member member = memberRepository.findById(memberId);
        Category category = categoryRepository.findById(categoryId);
        categoryRepository.addMemberCategory(member,category);
    }

    public List<CategoryDto> findMemberCategory(Long id){
        List<CategoryDto> categoryDtos = new ArrayList<>();
        List<Category> categoryList = categoryRepository.findByMemberId(memberRepository.findById(id));
        for(Category category : categoryList){
            CategoryDto categoryDto = new CategoryDto(category.getId(),category.getName());
            categoryDtos.add(categoryDto);
        }
        return categoryDtos;
    }
}
