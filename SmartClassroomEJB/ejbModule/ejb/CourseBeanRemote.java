package ejb;

import javax.ejb.Remote;
import jpa.Course;

@Remote
public interface CourseBeanRemote {
	
	void saveCourse(Course course);
	Course retrieveCourse(int Id);
	void updateCourse(Course course);
	void deleteCourse(int Id);

}
