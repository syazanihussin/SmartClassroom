package ejb;

import javax.ejb.Local;
import jpa.Attendance;

@Local
public interface AttendanceBeanLocal {

	void saveAttendance(Attendance attendance);
	Attendance retrieveAttendance(int Id);
	void updateAttendance(Attendance attendance);
	void deleteAttendance(int Id);

}
