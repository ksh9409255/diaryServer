package diaryApplication.diary.domain.emoticon;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Emoticon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emoticon_id",nullable = false,unique = true)
    private int id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "category_id",nullable = false)
    @JoinColumn(name = "category_id")
    private int categoryId;
    private String description;
}
