package Repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class FoodRepository {

    @PersistenceContext
    private EntityManager em;

    em.persist

    em.find
}
