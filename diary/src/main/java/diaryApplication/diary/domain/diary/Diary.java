package diaryApplication.diary.domain.diary;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isPublic;

    @Column(nullable = false,length = 20) // 글자 수 20자 제한
    private String name;

    @Column(nullable = false,length = 1000)// 글자 수 1000자 제한
    private String content;
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "emoticon_id",nullable = false)
    @JoinColumn(name = "emoticon_id")
    private int emoticonId;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "member_id",nullable = false)
    @JoinColumn(name = "member_id")
    private Long memberId;
}
