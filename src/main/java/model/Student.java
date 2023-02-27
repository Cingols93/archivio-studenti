package model;

public class Student {
	private int id;
	private String name;
	private String surname;
	private String address;
	private String studentId;
	private String dateOfBirth;
	private String idDepartment;
	private String departmentName;

	public Student() {
		super();
	}

	public Student(String name, String surname, String address, String studentId, String dateOfBirth,
			String idDepartment) {
		super();
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.studentId = studentId;
		this.dateOfBirth = dateOfBirth;
		this.idDepartment = idDepartment;
	}

	public Student(int id, String name, String surname, String address, String studentId, String dateOfBirth,
			String idDepartment) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.studentId = studentId;
		this.dateOfBirth = dateOfBirth;
		this.idDepartment = idDepartment;
	}

	public Student(int id, String name, String surname, String address, String studentId, String dateOfBirth,
			String idDepartment, String departmentName) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.studentId = studentId;
		this.dateOfBirth = dateOfBirth;
		this.idDepartment = idDepartment;
		this.departmentName = departmentName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getIdDepartment() {
		return idDepartment;
	}

	public void setIdDepartment(String idDepartment) {
		this.idDepartment = idDepartment;
	}

}
