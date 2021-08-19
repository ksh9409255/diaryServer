package diaryApplication.diary.domain.member;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String nickname;

    @OneToMany(mappedBy = "category_id")
    @Column(name = "category_id")
    private int categoryId;
}
