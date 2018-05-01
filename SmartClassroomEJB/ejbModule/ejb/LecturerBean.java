package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa.Lecturer;

@Stateless(name = "LecturerBean")
@LocalBean
public class LecturerBean implements LecturerBeanLocal, LecturerBeanRemote {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Persistence_Unit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public LecturerBean() {
		
	}
	
	@Override
	public void saveLecturer(Lecturer lecturer) {
		entityManager.getTransaction().begin();
		entityManager.persist(lecturer); 
		entityManager.getTransaction().commit();
	}
	
	@Override
	public Lecturer retrieveLecturer(int Id) {
		return (Lecturer) entityManager.find(Lecturer.class, Id);
    }

	@Override
    public void updateLecturer(Lecturer lecturer) {
		entityManager.getTransaction().begin();
		entityManager.merge(lecturer); 
		entityManager.getTransaction().commit();
    }
	
	@Override
	public void deleteLecturer(int Id) {
		Lecturer lecturer = (Lecturer) entityManager.find(Lecturer.class, Id);
		entityManager.getTransaction().begin();
		entityManager.remove(lecturer); 
		entityManager.getTransaction().commit();
    }

}
