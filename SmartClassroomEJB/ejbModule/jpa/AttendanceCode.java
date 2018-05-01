package jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="attendancecode")
public class AttendanceCode implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codeID", unique = true)
	private int codeID;
		
	@Column(name="code")
	private String code;
	
	@Column(name="codeDate")
	private int codeDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseID", nullable = false)
    private Course course;
	
	@OneToMany(cascade =  CascadeType.ALL, mappedBy = "attendanceCodeA")
    private List<Attendance> attendance = new ArrayList<>();
	
	public AttendanceCode() {
		super();
	}

	public AttendanceCode(String code, int codeDate) {
		super();
		this.code = code;
		this.codeDate = codeDate;
	}

	public AttendanceCode(String code, int codeDate, Course course) {
		super();
		this.code = code;
		this.codeDate = codeDate;
		this.course = course;
	}

	public int getCodeID() {
		return codeID;
	}

	public void setCodeID(int codeID) {
		this.codeID = codeID;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCodeDate() {
		return codeDate;
	}

	public void setCodeDate(int codeDate) {
		this.codeDate = codeDate;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Attendance> getAttendance() {
		return attendance;
	}

	public void setAttendance(List<Attendance> attendance) {
		this.attendance = attendance;
	}

	@Override
	public String toString() {
		return "AttendanceCode [codeID=" + codeID + ", code=" + code + ", codeDate=" + codeDate + "]";
	}

}


