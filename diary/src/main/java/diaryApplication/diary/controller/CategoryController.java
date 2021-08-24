package diaryApplication.diary.controller;

import diaryApplication.diary.domain.category.CategoryDto;
import diaryApplication.diary.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping
    public ResponseEntity categoryDelete(@RequestParam("id") int id){
        categoryService.remove(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<CategoryDto>> findAll(){
        return new ResponseEntity(categoryService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/member/list")
    public ResponseEntity<List<CategoryDto>> findByMemberId(@RequestParam("id") Long id){
        return new ResponseEntity(categoryService.findMemberCategory(id),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateCategory(@RequestParam("changeId") int id, @RequestParam("name") String name){
        categoryService.updateCategory(id,name);
        return new ResponseEntity(HttpStatus.OK);
    }
}
