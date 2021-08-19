package diaryApplication.diary.domain.member;


import diaryApplication.diary.domain.category.Category;
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

    @OneToMany(mappedBy = "category_id")
    private List<Category> categoryId = new ArrayList<>();

}
