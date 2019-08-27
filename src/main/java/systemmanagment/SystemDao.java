package systemmanagment;
 
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
 
@Component
public class SystemDao {
    // Injected database connection:
    @PersistenceContext private EntityManager em;
 
    // Stores a new guest:
    @Transactional
    public void persist(SystemEntity systemEntity) {
        em.persist(systemEntity);
    }
 
    // Retrieves all the guests:
    public List<SystemEntity> getAllGuests() {
    	TypedQuery<SystemEntity> query = em.createQuery(
            "SELECT g FROM SystemEntity g ORDER BY g.id", SystemEntity.class);
    	return query.getResultList();
    }
}