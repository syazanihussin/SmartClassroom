package ejb;

import javax.ejb.Remote;
import jpa.AttendanceCode;

@Remote
public interface AttendanceCodeBeanRemote {
	
	void saveAttendanceCode(AttendanceCode attendanceCode);
	AttendanceCode retrieveAttendanceCode(int Id);
	void updateAttendanceCode(AttendanceCode attendanceCode);
	void deleteAttendanceCode(int Id);

}
