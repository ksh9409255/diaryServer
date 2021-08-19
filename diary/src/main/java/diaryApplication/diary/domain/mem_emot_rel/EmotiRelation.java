package diaryApplication.diary.domain.mem_emot_rel;

import diaryApplication.diary.domain.emoticon.Emoticon;
import diaryApplication.diary.domain.member.Member;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "mem_emoti_rel")
@Getter
public class EmotiRelation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mem_emoti_rel_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") // JoinColumn은 FK 이름
    private Member memberId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emoticon_id")
    private Emoticon emoticonId;
}
