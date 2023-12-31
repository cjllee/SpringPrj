package food;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FoodRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Food food) {
        em.persist(food);
    }

    public Food findOne(Long id) {
        return em.find(Food.class, id);
    }

    public List<Food> findAll() {
        return em.createQuery("select f from Food f", Food.class).getResultList();
    }

    public void delete(Long id) {
        Food food = findOne(id);
        em.remove(food);
    }
}