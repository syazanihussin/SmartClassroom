package jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="attendance")
public class Attendance implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="attendanceID", unique = true)
	private int attendanceID;
	
	@Column(name="attendanceStatus")
	private AttendanceStatus attendanceStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentID", nullable = false)
    private Student studentA;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codeID", nullable = false)
    private AttendanceCode attendanceCodeA;
	
	public Attendance() {
		
	}

	public Attendance(AttendanceStatus attendanceStatus) {
		this.attendanceStatus = attendanceStatus;
	}

	public Attendance(AttendanceStatus attendanceStatus, Student studentA) {
		this.attendanceStatus = attendanceStatus;
		this.studentA = studentA;
	}
	
	public Attendance(AttendanceStatus attendanceStatus, AttendanceCode attendanceCodeA) {
		this.attendanceStatus = attendanceStatus;
		this.attendanceCodeA = attendanceCodeA;
	}

	public int getAttendanceID() {
		return attendanceID;
	}

	public void setAttendanceID(int attendanceID) {
		this.attendanceID = attendanceID;
	}

	public AttendanceStatus getAttendanceStatus() {
		return attendanceStatus;
	}

	public void setAttendanceStatus(AttendanceStatus attendanceStatus) {
		this.attendanceStatus = attendanceStatus;
	}

	public Student getStudentA() {
		return studentA;
	}

	public void setStudentA(Student studentA) {
		this.studentA = studentA;
	}

	public AttendanceCode getAttendanceCodeA() {
		return attendanceCodeA;
	}

	public void setAttendanceCodeA(AttendanceCode attendanceCodeA) {
		this.attendanceCodeA = attendanceCodeA;
	}

	@Override
	public String toString() {
		return "Attendance [attendanceID=" + attendanceID + ", attendanceStatus=" + attendanceStatus + "]";
	}

}


