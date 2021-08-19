package diaryApplication.diary.domain.emoticon;

import diaryApplication.diary.domain.category.Category;
import diaryApplication.diary.domain.category.CategoryDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EmoticonDto {
    private String name;
    private CategoryDto categoryId;
    private String description;

    public EmoticonDto(String name, CategoryDto categoryId, String description) {
        this.name = name;
        this.categoryId = categoryId;
        this.description = description;
    }

    public Emoticon toEntity(){
        return Emoticon.builder()
                .name(name)
                .categoryId(categoryId.toEntity())
                .description(description)
                .build();
    }
}
