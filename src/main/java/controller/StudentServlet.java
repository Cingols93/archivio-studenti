package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DepartmentDao;
import dao.StudentDao;
import model.Department;
import model.Student;

/**
 * Servlet implementation class StudenteServlet
 */
@WebServlet("/")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentDao studentDao = new StudentDao();
	
	private DepartmentDao departmentDao = new DepartmentDao();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new": {
				showNewForm(request, response);
				break;
			}
			case "/insert": {
				insertStudent(request, response);
				break;
			}
			case "/delete": {
				deleteStudent(request, response);
				break;
			}
			case "/edit": {
				showEditForm(request, response);
				break;
			}
			case "/update": {
				updateStudent(request, response);
				break;
			}
			default:
				listStudent(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		List<Student> listStudent = studentDao.selectAllStudents();
		
		
		request.setAttribute("listStudent", listStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("studentList.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("studentForm.jsp");
		List<Department> listOfDepartment = departmentDao.selectAllDepartments();
		request.setAttribute("listOfDepartment", listOfDepartment);
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		Student existingStudent = studentDao.getStudentById(id);
		List<Department> listOfDepartment = departmentDao.selectAllDepartments();
		RequestDispatcher dispatcher = request.getRequestDispatcher("studentForm.jsp");
		request.setAttribute("student", existingStudent);
		request.setAttribute("listOfDepartment", listOfDepartment);
		dispatcher.forward(request, response);
	}

	private void insertStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String address = request.getParameter("address");
		String studentId = request.getParameter("studentId");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String idDepartment = request.getParameter("idDepartment");
		
		Student student = new Student(name, surname, address, studentId, dateOfBirth, idDepartment);
		studentDao.createStudent(student);
		response.sendRedirect("list");
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String address = request.getParameter("address");
		String studentId = request.getParameter("studentId");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String idDepartment = request.getParameter("idDepartment");
		
		Student student = new Student(id,name, surname, address, studentId, dateOfBirth, idDepartment);
		studentDao.updateStudent(student);
		response.sendRedirect("list");
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		studentDao.deleteStudent(id);
		response.sendRedirect("list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
