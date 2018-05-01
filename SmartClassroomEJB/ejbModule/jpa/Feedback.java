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
@Table(name="feedback")
public class Feedback implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="feedbackID", unique = true)
	private int feedbackID;
	
	@Column(name="question")
	private String question;
	
	@Column(name="counter")
	private int counter;
	
	@Column(name="questionDate")
	private int questionDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseID", nullable = false)
    private Course courseF;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentID", nullable = false)
    private Student studentF;
	
	public Feedback() {
		
	}

	public Feedback(String question, int counter, int questionDate) {
		super();
		this.question = question;
		this.counter = counter;
		this.questionDate = questionDate;
	}

	public Feedback(String question, int counter, int questionDate, Course courseF) {
		this.question = question;
		this.counter = counter;
		this.questionDate = questionDate;
		this.courseF = courseF;
	}

	public Feedback(String question, int counter, int questionDate, Student studentF) {
		this.question = question;
		this.counter = counter;
		this.questionDate = questionDate;
		this.studentF = studentF;
	}

	public int getFeedbackID() {
		return feedbackID;
	}

	public void setFeedbackID(int feedbackID) {
		this.feedbackID = feedbackID;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getQuestionDate() {
		return questionDate;
	}

	public void setQuestionDate(int questionDate) {
		this.questionDate = questionDate;
	}

	public Course getCourseF() {
		return courseF;
	}

	public void setCourseF(Course courseF) {
		this.courseF = courseF;
	}

	public Student getStudentF() {
		return studentF;
	}

	public void setStudentF(Student studentF) {
		this.studentF = studentF;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackID=" + feedbackID + ", question=" + question + ", counter=" + counter
				+ ", questionDate=" + questionDate + "]";
	}
	
}


