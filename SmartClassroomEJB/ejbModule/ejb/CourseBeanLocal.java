package ejb;

import javax.ejb.Local;
import jpa.Course;

@Local
public interface CourseBeanLocal {
	
	void saveCourse(Course course);
	Course retrieveCourse(int Id);
	void updateCourse(Course course);
	void deleteCourse(int Id);
	
}
