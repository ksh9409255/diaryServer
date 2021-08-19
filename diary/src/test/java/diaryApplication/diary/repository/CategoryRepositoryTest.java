package diaryApplication.diary.repository;

import diaryApplication.diary.domain.category.CategoryDto;
import diaryApplication.diary.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepositoryTest {

    @Autowired
    CategoryService categoryService;

    @Test
    void findAll() {
        CategoryDto category = new CategoryDto(1,"potato");
        categoryService.register(category);
        categoryService.findAll();
    }
}