package diaryApplication.diary.domain.emoticon;

import diaryApplication.diary.domain.category.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Emoticon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emoticon_id")
    private int id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category categoryId;
    private String description;

    @Builder
    public Emoticon(String name, Category categoryId, String description) {
        this.name = name;
        this.categoryId = categoryId;
        this.description = description;
    }
}
