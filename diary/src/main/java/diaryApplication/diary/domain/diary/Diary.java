package diaryApplication.diary.domain.diary;

import diaryApplication.diary.domain.emoticon.Emoticon;
import diaryApplication.diary.domain.member.Member;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
public class Diary {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isPublic;

    @Column(nullable = false,length = 20) // 글자 수 20자 제한
    private String name;

    @Column(nullable = false,length = 1000)// 글자 수 1000자 제한
    private String content;
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emoticon_id")
    private Emoticon emoticonId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member memberId;
}
