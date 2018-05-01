package ejb;

import javax.ejb.Local;
import jpa.Student;

@Local
public interface StudentBeanLocal {

	void saveStudent(Student student);
	Student retrieveStudent(int Id);
	void updateStudent(Student student);
	void deleteStudent(int Id);

}
