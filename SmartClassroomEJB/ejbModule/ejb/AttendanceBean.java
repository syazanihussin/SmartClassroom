package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa.Attendance;

@Stateless(name = "AttendanceBean")
@LocalBean
public class AttendanceBean implements AttendanceBeanLocal, AttendanceBeanRemote {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Persistence_Unit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
    public AttendanceBean() {
        
    }

	@Override
	public void saveAttendance(Attendance attendance) {
		entityManager.getTransaction().begin();
		entityManager.persist(attendance); 
		entityManager.getTransaction().commit();
	}
	
	@Override
	public Attendance retrieveAttendance(int Id) {
		return (Attendance) entityManager.find(Attendance.class, Id);
    }

	@Override
    public void updateAttendance(Attendance attendance) {
		entityManager.getTransaction().begin();
		entityManager.merge(attendance); 
		entityManager.getTransaction().commit();
    }
	
	@Override
	public void deleteAttendance(int Id) {
		Attendance attendance = (Attendance) entityManager.find(Attendance.class, Id);
		entityManager.getTransaction().begin();
		entityManager.remove(attendance); 
		entityManager.getTransaction().commit();
    }
}
