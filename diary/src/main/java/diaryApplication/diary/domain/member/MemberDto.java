package diaryApplication.diary.domain.member;

import lombok.Getter;

@Getter
public class MemberDto {

    private String nickname;
    private int categoryId;

    public MemberDto(String nickname, int categoryId) {
        this.nickname = nickname;
        this.categoryId = categoryId;
    }
}
