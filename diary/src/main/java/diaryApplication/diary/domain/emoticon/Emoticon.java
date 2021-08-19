package diaryApplication.diary.domain.emoticon;

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
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private int categoryId;
    private String description;

    @Builder
    public Emoticon(Long id, String name, int categoryId, String description) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.description = description;
    }

    public Emoticon toEntity(EmoticonDto emoticonDto){
        return Emoticon.builder()
                .id(this.id)
                .name(emoticonDto.getName())
                .categoryId(emoticonDto.getCategoryId())
                .description(emoticonDto.getDescription())
                .build();
    }
}
