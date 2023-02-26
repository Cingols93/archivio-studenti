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

	private static final String INSERT_STUDENT_SQL = "INSERT INTO studente"
			+ "(nome, cognome, indirizzo,matricola,data_di_nascita,id_dipartimento) VALUES " + "( ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_ALL_STUDENTS = "select * from studente";
	private static final String SELECT_STUDENT_BY_ID = "select * from studente where id = ?";
	private static final String DELETE_STUDENT_SQL = "delete from studente where id = ?;";
	private static final String UPDATE_STUDENT_SQL = "update studente set nome = ?,cognome = ?,indirizzo = ?,matricola = ?, data_di_nascita = ?, id_dipartimento = ? where id = ?;";

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
			preparedStatement.setString(1, studente.getNome());
			preparedStatement.setString(2, studente.getCognome());
			preparedStatement.setString(3, studente.getIndirizzo());
			preparedStatement.setString(4, studente.getMatricola());
			preparedStatement.setString(5, studente.getDataDiNascita());
			preparedStatement.setString(6, studente.getIdDipartimento());

			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;

	}

	// Update new student
	public boolean updateStudent(Student studente) throws SQLException {
		boolean rowUpdated = false;

		try (Connection connection = getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_SQL)) {
			preparedStatement.setString(1, studente.getNome());
			preparedStatement.setString(2, studente.getCognome());
			preparedStatement.setString(3, studente.getIndirizzo());
			preparedStatement.setString(4, studente.getMatricola());
			preparedStatement.setString(5, studente.getDataDiNascita());
			preparedStatement.setString(6, studente.getIdDipartimento());
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
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String indirizzo = rs.getString("indirizzo");
				String matricola = rs.getString("matricola");
				String dataDiNascita = rs.getString("data_di_nascita");
				String idDipartimento = rs.getString("id_dipartimento");

				studente = new Student(nome, cognome, indirizzo, matricola, dataDiNascita, idDipartimento);
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
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String indirizzo = rs.getString("indirizzo");
				String matricola = rs.getString("matricola");
				String dataDiNascita = rs.getString("data_di_nascita");
				String idDipartimento = rs.getString("id_dipartimento");

				students.add(new Student(id,nome, cognome, indirizzo, matricola, dataDiNascita, idDipartimento));
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
