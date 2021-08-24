package diaryApplication.diary.domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @Column(name = "member_id")
    private Long id;
    private String nickname;
    private int categoryId; // 대표 캐릭터 아이디 값

    public void diaryMemberIdSet(Long id) {
        this.id = id;
    }

    @Builder
    public Member(Long id, String nickname, int categoryId) {
        this.id = id;
        this.nickname = nickname;
        this.categoryId = categoryId;
    }

    public void updateMember(String nickname, int categoryId){
        this.nickname = nickname;
        this.categoryId = categoryId;
    }
}
