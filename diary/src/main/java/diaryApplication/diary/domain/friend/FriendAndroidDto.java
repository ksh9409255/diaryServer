package diaryApplication.diary.domain.friend;

import diaryApplication.diary.domain.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FriendAndroidDto {

    private Member memberId_1;
    private String memberId_2_nickname;

    public FriendAndroidDto(Member memberId_1, String memberId_2_nickname) {
        this.memberId_1 = memberId_1;
        this.memberId_2_nickname = memberId_2_nickname;
    }
}
