package diaryApplication.diary.domain.mem_stic_rel;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "mem_stic_rel")
@Getter
public class Relation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mem_stic_rel_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") // JoinColumn은 FK 이름
    @Column(name = "member_id")
    private Long memberId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sticker_id")
    @Column(name = "sticker_id")
    private Long stickerId;
}
