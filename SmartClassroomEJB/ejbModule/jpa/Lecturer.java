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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="lecturer")
public class Lecturer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="lecturerID", unique = true)
	private int lecturerID;
	
	@Column(name="name")
	private String name;
	
	@Column(name="password")
	private String password;
	
	@Column(name="ICNo")
	private String ICNo;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phoneNo")
	private String phoneNo;
	
	@Column(name="address")
	private String address;
	
	@OneToMany(cascade =  CascadeType.ALL, mappedBy = "lecturerC")
    private List<Course> course = new ArrayList<>();
	
	public Lecturer() {
		
	}
	
	
	public Lecturer(String name, String password, String iCNo, String email, String phoneNo, String address) {
		this.name = name;
		this.password = password;
		ICNo = iCNo;
		this.email = email;
		this.phoneNo = phoneNo;
		this.address = address;
	}

	public int getLecturerID() {
		return lecturerID;
	}

	public void setLecturerID(int lecturerID) {
		this.lecturerID = lecturerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getICNo() {
		return ICNo;
	}

	public void setICNo(String iCNo) {
		ICNo = iCNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Lecturer [lecturerID=" + lecturerID + ", name=" + name + ", password=" + password + ", ICNo=" + ICNo
				+ ", email=" + email + ", phoneNo=" + phoneNo + ", address=" + address + "]";
	}
	
}


