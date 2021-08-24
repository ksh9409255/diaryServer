package diaryApplication.diary.domain.member;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberDto {

    private Long id;
    private String nickName;
    private int categoryId;

    public MemberDto(Long id, String nickName, int categoryId) {
        this.id = id;
        this.nickName = nickName;
        this.categoryId = categoryId;
    }

    public Member toEntity(){
        return Member.builder()
                .id(id)
                .nickname(nickName)
                .categoryId(categoryId)
                .build();
    }
}
