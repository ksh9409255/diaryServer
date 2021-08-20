package diaryApplication.diary.domain.diary;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class DiaryDto {

    private boolean isPublic;
    private String title;
    private String content;
    private Date date;
    private int emoticonId;
    private Long memberId;

    public DiaryDto(boolean isPublic, String title, String content, Date date, int emoticonId, Long memberId) {
        this.isPublic = isPublic;
        this.title = title;
        this.content = content;
        this.date = date;
        this.emoticonId = emoticonId;
        this.memberId = memberId;
    }
}
