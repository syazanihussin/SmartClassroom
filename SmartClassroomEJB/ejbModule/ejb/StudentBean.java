package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa.Student;

@Stateless(name = "StudentBean")
@LocalBean
public class StudentBean implements StudentBeanLocal, StudentBeanRemote {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Persistence_Unit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
    
    public StudentBean() {
        
    }
   
	@Override
	public void saveStudent(Student student) {
		entityManager.getTransaction().begin();
		entityManager.persist(student); 
		entityManager.getTransaction().commit();
	}
	
	@Override
	public Student retrieveStudent(int Id) {
		return (Student) entityManager.find(Student.class, Id);
    }

	@Override
    public void updateStudent(Student student) {
		entityManager.getTransaction().begin();
		entityManager.merge(student); 
		entityManager.getTransaction().commit();
    }
		
	@Override
	public void deleteStudent(int Id) {
		Student houseOwner = (Student) entityManager.find(Student.class, Id);
		entityManager.getTransaction().begin();
		entityManager.remove(houseOwner); 
		entityManager.getTransaction().commit();
    }

}
