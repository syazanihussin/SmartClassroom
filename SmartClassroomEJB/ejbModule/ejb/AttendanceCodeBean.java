package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa.AttendanceCode;

@Stateless(name = "AttendanceCodeBean")
@LocalBean
public class AttendanceCodeBean implements AttendanceCodeBeanLocal, AttendanceCodeBeanRemote {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Persistence_Unit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
    
    public AttendanceCodeBean() {
        
    }
	
	@Override
	public void saveAttendanceCode(AttendanceCode attendanceCode) {
		entityManager.getTransaction().begin();
		entityManager.persist(attendanceCode); 
		entityManager.getTransaction().commit();
	}
	
	@Override
	public AttendanceCode retrieveAttendanceCode(int Id) {
		return (AttendanceCode) entityManager.find(AttendanceCode.class, Id);
    }

	@Override
    public void updateAttendanceCode(AttendanceCode attendanceCode) {
		entityManager.getTransaction().begin();
		entityManager.merge(attendanceCode); 
		entityManager.getTransaction().commit();
    }
	
	@Override
	public void deleteAttendanceCode(int Id) {
		AttendanceCode attendanceCode = (AttendanceCode) entityManager.find(AttendanceCode.class, Id);
		entityManager.getTransaction().begin();
		entityManager.remove(attendanceCode); 
		entityManager.getTransaction().commit();
    }
}
