package ejb;

import javax.ejb.Local;
import jpa.AttendanceCode;

@Local
public interface AttendanceCodeBeanLocal {

	void saveAttendanceCode(AttendanceCode attendanceCode);
	AttendanceCode retrieveAttendanceCode(int Id);
	void updateAttendanceCode(AttendanceCode attendanceCode);
	void deleteAttendanceCode(int Id);

}
