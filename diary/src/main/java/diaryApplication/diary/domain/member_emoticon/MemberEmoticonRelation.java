package diaryApplication.diary.domain.member_emoticon;

import diaryApplication.diary.domain.emoticon.Emoticon;
import diaryApplication.diary.domain.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "member_emoticon")
@Getter
@NoArgsConstructor
public class MemberEmoticonRelation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member memberId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emoticon_id")
    private Emoticon emoticonId;

    public MemberEmoticonRelation(Member member, Emoticon emoticon){
        this.memberId=member;
        this.emoticonId = emoticon;
    }
}
