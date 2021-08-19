package diaryApplication.diary.controller;

import diaryApplication.diary.domain.category.CategoryDto;
import diaryApplication.diary.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity categoryRegister(@RequestBody CategoryDto categoryDto){
        categoryService.register(categoryDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
