package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa.Feedback;

@Stateless(name = "FeedbackBean")
@LocalBean
public class FeedbackBean implements FeedbackBeanLocal, FeedbackBeanRemote {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Persistence_Unit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();	
    
    public FeedbackBean() {
        
    }
    
	@Override
	public void saveFeedback(Feedback feedback) {
		entityManager.getTransaction().begin();
		entityManager.persist(feedback); 
		entityManager.getTransaction().commit();
	}
	
	@Override
	public Feedback retrieveFeedback(int Id) {
		return (Feedback) entityManager.find(Feedback.class, Id);
    }

	@Override
    public void updateFeedback(Feedback feedback) {
		entityManager.getTransaction().begin();
		entityManager.merge(feedback); 
		entityManager.getTransaction().commit();
    }
	
	@Override
	public void deleteFeedback(int Id) {
		Feedback feedback = (Feedback) entityManager.find(Feedback.class, Id);
		entityManager.getTransaction().begin();
		entityManager.remove(feedback); 
		entityManager.getTransaction().commit();
    }

}
