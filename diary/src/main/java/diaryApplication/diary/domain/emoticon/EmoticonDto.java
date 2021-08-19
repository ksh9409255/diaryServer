package diaryApplication.diary.domain.emoticon;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EmoticonDto {
    private String name;
    private int categoryId;
    private String description;

    public EmoticonDto(String name, int categoryId, String description) {
        this.name = name;
        this.categoryId = categoryId;
        this.description = description;
    }
}
