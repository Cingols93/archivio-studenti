package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Department;
import model.Student;
import utils.ConnectionUtil;

public class DepartmentDao extends ConnectionUtil {

	private static final String SELECT_ALL_DEPARTMENTS = "SELECT * FROM department";

	private static final String SELECT_DEPARTMENT_BY_ID = "select * from department where id = ?";

	// Get department by Id
	public Department getDepartmentById(int id) throws SQLException {
		Department department = null;

		try (Connection connection = getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DEPARTMENT_BY_ID)) {
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name");
				String address = rs.getString("address");
				String postalCode = rs.getString("postal_code");

				department = new Department(id, name, address, postalCode);
			}
		}
		return department;

	}

	// Get department
	public List<Department> selectAllDepartments() throws SQLException {
		List<Department> departments = new ArrayList<Department>();

		try (Connection connection = getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DEPARTMENTS)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String postalCode = rs.getString("postal_code");

				departments.add(new Department(id, name, address, postalCode));
			}
		}
		return departments;

	}

}
