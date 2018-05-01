package ejb;

import javax.ejb.Local;
import jpa.Lecturer;

@Local
public interface LecturerBeanLocal {

	void saveLecturer(Lecturer lecturer);
	Lecturer retrieveLecturer(int Id);
	void updateLecturer(Lecturer lecturer);
	void deleteLecturer(int Id);
	
}
