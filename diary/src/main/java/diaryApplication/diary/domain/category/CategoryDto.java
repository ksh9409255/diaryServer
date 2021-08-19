package diaryApplication.diary.domain.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private int id;
    private String name;

    public CategoryDto(String name) {
        this.name = name;
    }

    public Category toEntity(){
        return Category.builder()
                .id(id)
                .name(name)
                .build();
    }
}
