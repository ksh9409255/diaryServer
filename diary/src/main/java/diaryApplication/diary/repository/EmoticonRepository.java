package diaryApplication.diary.repository;

import diaryApplication.diary.domain.emoticon.Emoticon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class EmoticonRepository {
    private final EntityManager em;

    public void save(Emoticon emoticon){
        em.persist(emoticon);
    }
}
