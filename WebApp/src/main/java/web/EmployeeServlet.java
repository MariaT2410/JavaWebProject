package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Employee;
import persistence.DAO;

@WebServlet(urlPatterns = { "/employee-list"})
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO departmentDAO;
       
    public EmployeeServlet() {  super();}
    public void init() { departmentDAO = new DAO();}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getServletPath();

        try {
            switch (action) {
                default:
                    listEmployee(request, response);
                    break;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	 private void listEmployee(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException, ClassNotFoundException {
	        List <Employee> listEmployee = departmentDAO.queryEmployee();
	        request.setAttribute("listEmployee", listEmployee);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/employee-list.jsp");
	        dispatcher.forward(request, response);
	    }

	 /*
	    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/employee-form.jsp");
	        dispatcher.forward(request, response);
	    }

	    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, ServletException, IOException, ClassNotFoundException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Employee existingUser = departmentDAO.selectEmployee(id);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
	        request.setAttribute("employee", existingUser);
	        dispatcher.forward(request, response);

	    }

	    private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ClassNotFoundException {
	        String name = request.getParameter("name");
	        int id = request.getIntHeader("id");
	        int age = request.getIntHeader("age");
	        int wage = request.getIntHeader("wage");
	        int idDepartment = request.getIntHeader("idDepartment");
	        departmentDAO.insertEmployee(id, name, age,wage, idDepartment);
	        response.sendRedirect("list");
	    }

	    private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        String name = request.getParameter("name");
	        int age = request.getIntHeader("age");
	        int wage = request.getIntHeader("wage");
	        int idDepartment = request.getIntHeader("idDepartment");

	        Employee book = new Employee(id, name, age,wage, idDepartment);
	        departmentDAO.updateEmployee(book);
	        response.sendRedirect("list");
	    }

	    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ClassNotFoundException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        departmentDAO.deleteEmployee(id);
	        response.sendRedirect("list");

	    }
	    */

}
