package diaryApplication.diary.service;

import diaryApplication.diary.domain.category.CategoryDto;
import diaryApplication.diary.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class CategoryServiceTest {

    @Autowired
    CategoryService categoryService;

    @Test
    void register() {
        CategoryDto category = new CategoryDto("potato");
        categoryService.register(category);
        System.out.println(categoryService.findAll().get(0).getId());
    }

    @Test
    void remove() {
        CategoryDto category = new CategoryDto("potato");
        categoryService.register(category);
        categoryService.remove(1);
    }

    @Test
    void findAll() {
        CategoryDto category1 = new CategoryDto("potato");
        categoryService.register(category1);
        CategoryDto category2 = new CategoryDto("yellow");
        categoryService.register(category2);
        System.out.println(categoryService.findAll().size());
    }
}