package jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="courseID", unique = true)
	private String courseID;
	
	@Column(name="courseName")
	private String courseName;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecturerID", nullable = false)
    private Lecturer lecturerC;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "studentcourse", joinColumns = @JoinColumn(name = "courseID", referencedColumnName = "courseID"), inverseJoinColumns = @JoinColumn(name = "studentID", referencedColumnName = "studentID"))
	private List<Student> studentC = new ArrayList<>();
		
	@OneToMany(cascade =  CascadeType.ALL, mappedBy = "courseAC")
    private List<AttendanceCode> code = new ArrayList<>();

	@OneToMany(cascade =  CascadeType.ALL, mappedBy = "courseF")
    private List<Feedback> feedback = new ArrayList<>();
	
	public Course() {
		
	}
	
	public Course(String courseID, String courseName) {
		this.courseName = courseName;
	}

	public Course(String courseID, String courseName, Lecturer lecturerC) {
		this.courseName = courseName;
		this.lecturerC = lecturerC;
	}
	
	public Course(String courseID, String courseName, List<Student> studentC) {
		this.courseName = courseName;
		this.studentC = studentC;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Lecturer getLecturerC() {
		return lecturerC;
	}

	public void setLecturerC(Lecturer lecturerC) {
		this.lecturerC = lecturerC;
	}

	public List<Student> getStudentC() {
		return studentC;
	}

	public void setStudentC(List<Student> studentC) {
		this.studentC = studentC;
	}

	public List<AttendanceCode> getCode() {
		return code;
	}

	public void setCode(List<AttendanceCode> code) {
		this.code = code;
	}
	
	public List<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Course [courseID=" + courseID + ", courseName=" + courseName + "]";
	}
	
}


