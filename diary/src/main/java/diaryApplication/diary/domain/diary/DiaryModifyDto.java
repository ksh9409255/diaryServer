package diaryApplication.diary.domain.diary;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DiaryModifyDto {

    private Long id; // 일기 id
    private boolean open;
    private String title;
    private String content;
    private int emoticonId;

    public DiaryModifyDto(Long id, boolean open, String title, String content, int emoticonId) {
        this.id = id;
        this.open = open;
        this.title = title;
        this.content = content;
        this.emoticonId = emoticonId;
    }
}
