package diaryApplication.diary.domain.diary;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class DiaryDto {


    private boolean open;
    private String title;
    private String content;
    private String date;
    private int emoticonId;
    private Long memberId;

    public DiaryDto(boolean open, String title, String content, String date, int emoticonId, Long memberId) {
        this.open = open;
        this.title = title;
        this.content = content;
        this.date = date;
        this.emoticonId = emoticonId;
        this.memberId = memberId;
    }
}
