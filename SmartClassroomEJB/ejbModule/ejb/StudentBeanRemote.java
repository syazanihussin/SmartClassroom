package ejb;

import javax.ejb.Remote;
import jpa.Student;

@Remote
public interface StudentBeanRemote {

	void saveStudent(Student student);
	Student retrieveStudent(int Id);
	void updateStudent(Student student);
	void deleteStudent(int Id);
	
}
