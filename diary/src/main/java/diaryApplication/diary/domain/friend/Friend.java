package diaryApplication.diary.domain.friend;

import diaryApplication.diary.repository.FriendRepository;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Friend {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long memberId_1;
    private Long memberId_2;
    private Long targetId;
    private boolean accept;

    public void save(Long memberId_1, Long memberId_2, Long targetId) {
        this.memberId_1 = memberId_1;
        this.memberId_2 = memberId_2;
        this.targetId = targetId;
        this.accept = false;
    }

}
