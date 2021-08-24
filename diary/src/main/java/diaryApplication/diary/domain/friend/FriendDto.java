package diaryApplication.diary.domain.friend;

import diaryApplication.diary.domain.member.Member;
import diaryApplication.diary.domain.member.MemberDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FriendDto {

    private Member memberId_1;
    private Member memberId_2;

    public FriendDto(Member memberId_1, Member memberId_2) {
        this.memberId_1 = memberId_1;
        this.memberId_2 = memberId_2;
    }
}
