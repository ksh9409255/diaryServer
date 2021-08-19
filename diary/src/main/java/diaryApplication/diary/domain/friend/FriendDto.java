package diaryApplication.diary.domain.friend;

import lombok.Getter;

@Getter
public class FriendDto {

    private Long memberId_1;
    private Long memberId_2;

    public FriendDto(Long memberId_1, Long memberId_2) {
        this.memberId_1 = memberId_1;
        this.memberId_2 = memberId_2;
    }
}
