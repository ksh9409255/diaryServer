package diaryApplication.diary.domain.emoticon;

import diaryApplication.diary.domain.category.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EmoticonDto {
    private String name;
    private Category categoryId;
    private String description;

    public EmoticonDto(String name, Category categoryId, String description) {
        this.name = name;
        this.categoryId = categoryId;
        this.description = description;
    }
}
