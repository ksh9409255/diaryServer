package diaryApplication.diary.domain.diary;

import diaryApplication.diary.domain.emoticon.Emoticon;
import diaryApplication.diary.domain.member.Member;
import diaryApplication.diary.repository.DiaryRepository;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
public class Diary {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean open;

    @Column(nullable = false,length = 20) // 글자 수 20자 제한
    private String title;

    @Column(nullable = false,length = 1000)// 글자 수 1000자 제한
    private String content;
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emoticon_id")
    private Emoticon emoticonId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member memberId;

    public void save(DiaryDto diaryDto, Emoticon emoticon, Member member) {
        this.open = diaryDto.isOpen();
        this.title = diaryDto.getTitle();
        this.content = diaryDto.getContent();
        this.date = diaryDto.getDate();
        this.emoticonId = emoticon;
        this.memberId = member;
    }

    public void modify(Diary diary, DiaryModifyDto diaryModifyDtoDto, Emoticon emoticon) {
        diary.open = diaryModifyDtoDto.isOpen();
        diary.title = diaryModifyDtoDto.getTitle();
        diary.content = diaryModifyDtoDto.getContent();;
        diary.emoticonId = emoticon;
    }
}
