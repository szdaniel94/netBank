package facades;

import entities.Transaction;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Daniel Szabo
 */
@Stateless
public class TransactionFacade extends AbstractFacade<Transaction> implements TransactionFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_NetBank-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransactionFacade() {
        super(Transaction.class);
    }
    
    public List<Transaction> specifyTransaction(Long id){
        Query q = em.createNamedQuery("getSpecifyTransaction", Transaction.class); 
        q.setParameter("rId", id);
        return q.getResultList();
    }
    
}
