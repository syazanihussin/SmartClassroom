package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa.Course;

@Stateless(name = "CourseBean")
@LocalBean
public class CourseBean implements CourseBeanLocal, CourseBeanRemote {
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Persistence_Unit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
    
    public CourseBean() {
        
    }
	
	@Override
	public void saveCourse(Course course) {
		entityManager.getTransaction().begin();
		entityManager.persist(course); 
		entityManager.getTransaction().commit();
	}
		
	@Override
	public Course retrieveCourse(int Id) {
		return (Course) entityManager.find(Course.class, Id);
    }
 
	@Override
    public void updateCourse(Course course) {
		entityManager.getTransaction().begin();
		entityManager.merge(course); 
		entityManager.getTransaction().commit();
    }
	
	@Override
	public void deleteCourse(int Id) {
		Course course = (Course) entityManager.find(Course.class, Id);
		entityManager.getTransaction().begin();
		entityManager.remove(course); 
		entityManager.getTransaction().commit();
    }

}
