package diaryApplication.diary.domain.friend;

import diaryApplication.diary.domain.member.Member;
import diaryApplication.diary.domain.member.MemberDto;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Friend {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long memberId_1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member memberId_2;
    private Long targetId;
    private boolean accept;

    public void add(Member memberId_1, Member memberId_2, Long targetId) {
        this.memberId_1 = memberId_1.getId();
        this.memberId_2 = memberId_2;
        this.targetId = targetId;
        this.accept = false;
    }

    public void isAccept(boolean accept) {
        this.accept = accept;
    }

}
