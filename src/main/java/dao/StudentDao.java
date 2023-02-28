package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Student;

public class StudentDao {

	private String jdbcURL = "jdbc:mysql://localhost:3306/archivio_studenti?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
	private String jdbcUsername = "admin";
	private String jdbcPassword = "admin";

	private static final String INSERT_STUDENT_SQL = "INSERT INTO student"
			+ "(name, surname, address,student_id,date_of_birth,id_department) VALUES " + "( ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_ALL_STUDENTS = "SELECT student.id,student.name,student.surname,student.address,student.date_of_birth,student.student_id,student.id_department, department.name as department_name "
			+ "FROM student " + "INNER JOIN department on student.id_department = department.id;";
	private static final String SELECT_STUDENT_BY_ID = "select * from student where id = ?";
	private static final String DELETE_STUDENT_SQL = "delete from student where id = ?;";
	private static final String UPDATE_STUDENT_SQL = "update student set name = ?,surname = ?,address = ?,student_id = ?, date_of_birth = ?, id_department = ? where id = ?;";

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	// Register new student
	public boolean createStudent(Student studente) throws SQLException {
		boolean rowUpdated = false;

		try (Connection connection = getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
			preparedStatement.setString(1, studente.getName());
			preparedStatement.setString(2, studente.getSurname());
			preparedStatement.setString(3, studente.getAddress());
			preparedStatement.setString(4, studente.getStudentId());
			preparedStatement.setString(5, studente.getDateOfBirth());
			preparedStatement.setString(6, studente.getIdDepartment());

			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;

	}

	// Update new student
	public boolean updateStudent(Student studente) throws SQLException {
		boolean rowUpdated = false;

		try (Connection connection = getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_SQL)) {
			preparedStatement.setString(1, studente.getName());
			preparedStatement.setString(2, studente.getSurname());
			preparedStatement.setString(3, studente.getAddress());
			preparedStatement.setString(4, studente.getStudentId());
			preparedStatement.setString(5, studente.getDateOfBirth());
			preparedStatement.setString(6, studente.getIdDepartment());
			preparedStatement.setInt(7, studente.getId());

			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;

	}

	// Get studente by Id
	public Student getStudentById(int id) throws SQLException {
		Student studente = null;

		try (Connection connection = getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID)) {
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				String address = rs.getString("address");
				String studentId = rs.getString("student_id");
				String dateOfBirth = rs.getString("date_of_birth");
				String idDepartment = rs.getString("id_department");

				studente = new Student(id, name, surname, address, studentId, dateOfBirth, idDepartment);
			}
		}
		return studente;

	}


	// Get students
	public List<Student> selectAllStudents() throws SQLException {
		List<Student> students = new ArrayList<Student>();

		try (Connection connection = getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				String address = rs.getString("address");
				String studentId = rs.getString("student_id");
				String dateOfBirth = rs.getString("date_of_birth");
				String idDepartment = rs.getString("id_department");
				String departmentName = rs.getString("department_name");

				students.add(
						new Student(id, name, surname, address, studentId, dateOfBirth, idDepartment, departmentName));
			}
		}
		return students;

	}

	// delete student
	public boolean deleteStudent(int id) throws SQLException {
		boolean rowDeleted = false;

		try (Connection connection = getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT_SQL)) {
			preparedStatement.setInt(1, id);

			rowDeleted = preparedStatement.executeUpdate() > 0;
		}
		return rowDeleted;

	}
}
