package diaryApplication.diary.repository;

import diaryApplication.diary.domain.category.Category;
import diaryApplication.diary.domain.emoticon.Emoticon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class CategoryRepository {
    private final EntityManager em;

    public void save(Category category){
        em.persist(category);
    }

    public Category findById(Long id){
        return em.find(Category.class,id);
    }
}
