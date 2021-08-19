package diaryApplication.diary.domain.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;
    private String name;

    public Category(String name) {
        this.name = name;
    }

    @Builder
    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
