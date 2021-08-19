package diaryApplication.diary.domain.category;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CategoryDto {
    private String name;

    public CategoryDto(String name) {
        this.name = name;
    }

    public Category toEntity(){
        return Category.builder()
                .name(name)
                .build();
    }
}
