package diaryApplication.diary.domain.member;


import diaryApplication.diary.domain.category.Category;
import diaryApplication.diary.domain.mem_cate_rel.CateRelation;
import diaryApplication.diary.domain.mem_emot_rel.EmotiRelation;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String nickname;

    @OneToMany(mappedBy = "categoryId")
    private List<CateRelation> categoryId = new ArrayList<>();

    @OneToMany(mappedBy = "emoticonId")
    private List<EmotiRelation> emoticonId = new ArrayList<>();
}
