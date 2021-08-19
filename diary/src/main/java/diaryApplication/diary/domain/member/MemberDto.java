package diaryApplication.diary.domain.member;

import lombok.Getter;

@Getter
public class MemberDto {

    private Long id;
    private String nickname;
    private int categoryId;

    public MemberDto(Long id, String nickname, int categoryId) {
        this.id = id;
        this.nickname = nickname;
        this.categoryId = categoryId;
    }
}
