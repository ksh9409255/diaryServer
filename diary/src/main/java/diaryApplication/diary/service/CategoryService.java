package diaryApplication.diary.service;

import diaryApplication.diary.domain.category.Category;
import diaryApplication.diary.domain.category.CategoryDto;
import diaryApplication.diary.domain.emoticon.EmoticonDto;
import diaryApplication.diary.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {
    private final CategoryRepository categoryRepository;

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
}
