package ejb;

import javax.ejb.Remote;
import jpa.Attendance;

@Remote
public interface AttendanceBeanRemote {

	void saveAttendance(Attendance attendance);
	Attendance retrieveAttendance(int Id);
	void updateAttendance(Attendance attendance);
	void deleteAttendance(int Id);

}
