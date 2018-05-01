package jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="studentID", unique = true)
	private int studentID;
	
	@Column(name="studentName")
	private String studentName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="studentEmail")
	private String studentEmail;
	
	@OneToMany(cascade =  CascadeType.ALL, mappedBy = "studentA")
    private List<Attendance> attendance = new ArrayList<>();
	
	@OneToMany(cascade =  CascadeType.ALL, mappedBy = "studentF")
    private List<Feedback> feedback = new ArrayList<>();
	
	@ManyToMany(mappedBy = "studentC")
    private List<Course> course = new ArrayList<>();
	
	public Student() {
		
	}

	public Student(String studentName, String password, String studentEmail) {
		this.studentName = studentName;
		this.password = password;
		this.studentEmail = studentEmail;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public List<Attendance> getAttendance() {
		return attendance;
	}

	public void setAttendance(List<Attendance> attendance) {
		this.attendance = attendance;
	}

	public List<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", studentName=" + studentName + ", password=" + password
				+ ", studentEmail=" + studentEmail + "]";
	}
	
}


