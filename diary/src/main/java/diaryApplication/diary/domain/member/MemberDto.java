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

    /**
     * FriendRepository에서 findAll()에서 사용되는 메서드로,
     * 반환할 memberDto의 값을 set해주는 메서드
     */
    public void findMemberDtos(Member member) {
        this.id = member.getId();
        this.nickName = member.getNickname();
        this.categoryId = member.getCategoryId();
    }
}
