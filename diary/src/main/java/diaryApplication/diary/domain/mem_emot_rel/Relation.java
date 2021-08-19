package diaryApplication.diary.domain.mem_emot_rel;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "mem_emot_rel")
@Getter
public class Relation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mem_emot_rel_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") // JoinColumn은 FK 이름
    private Long memberId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emoticon_id")
    private Long emoticonId;
}
