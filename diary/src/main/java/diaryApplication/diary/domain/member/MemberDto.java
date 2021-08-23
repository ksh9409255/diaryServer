package diaryApplication.diary.domain.member;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberDto {

    private Long id;
    private String nickname;
    private int categoryId;

    public MemberDto(Long id, String nickname, int categoryId) {
        this.id = id;
        this.nickname = nickname;
        this.categoryId = categoryId;
    }

    public Member toEntity(){
        return Member.builder()
                .id(id)
                .nickname(nickname)
                .categoryId(categoryId)
                .build();
    }
}
