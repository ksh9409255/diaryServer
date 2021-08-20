package diaryApplication.diary.repository;

import diaryApplication.diary.domain.emoticon.Emoticon;
import diaryApplication.diary.domain.emoticon.EmoticonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmoticonRepository {
    private final EntityManager em;

    public void save(Emoticon emoticon){
        em.persist(emoticon);
    }

    public Emoticon findById(int id){
        return em.find(Emoticon.class,id);
    }
}
