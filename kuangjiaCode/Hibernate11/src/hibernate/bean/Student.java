package hibernate.bean;

public class Student {

	private Integer id;
	private String name;
	private Integer age;
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + "]";
	}

	public Student(String name, Integer age, String email) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
	}

	public Student() {
		super();
	}
}
