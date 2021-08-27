package diaryApplication.diary.domain.diary;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DiaryFindDto {

    private Long id; // 다이어리 id
    private boolean open;
    private String title;
    private String date;
    private int emoticonId;

    public DiaryFindDto(Long id, boolean open, String title, String date, int emoticonId) {
        this.id = id;
        this.open = open;
        this.title = title;
        this.date = date;
        this.emoticonId = emoticonId;
    }
}
