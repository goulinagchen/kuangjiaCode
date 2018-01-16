package hebernate.bean;

public class Student {

	private Integer studentId;
	private String studentName;
	private Integer studentAge;
	private String studentEmail;
	
	public Student(String studentName, Integer studentAge, String studentEmail) {
		super();
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.studentEmail = studentEmail;
	}

	public Student() {
		super();
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(Integer studentAge) {
		this.studentAge = studentAge;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAge=" + studentAge
				+ ", studentEmail=" + studentEmail + "]";
	}

}
