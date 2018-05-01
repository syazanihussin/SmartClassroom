package ejb;

import javax.ejb.Remote;
import jpa.Lecturer;

@Remote
public interface LecturerBeanRemote {

	void saveLecturer(Lecturer lecturer);
	Lecturer retrieveLecturer(int Id);
	void updateLecturer(Lecturer lecturer);
	void deleteLecturer(int Id);

}
