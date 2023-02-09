package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Employee;
import persistence.DAO;

@WebServlet("/editEmployee")
public class EmployeeServletEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO employeeDAO;
       

    public EmployeeServletEdit() {
        super();
       
    }

    @Override
	public void init(ServletConfig config) throws ServletException {
		employeeDAO = new DAO();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			showEditForm(request,response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		 try {
	        	updateEmployee(request,response);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}
	
	
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        //Employee existingUser = employeeDAO.selectEmployee(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/employee-form.jsp");
        request.setAttribute("employee", employeeDAO.selectEmployee(id));
        dispatcher.forward(request, response);

    }
    private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        int wage = Integer.parseInt(request.getParameter("wage"));
        int idDepartment = Integer.parseInt(request.getParameter("idDepartment"));

        Employee book = new Employee(id, name, age,wage, idDepartment);
        employeeDAO.updateEmployee(book);
        request.setAttribute("employee", employeeDAO.updateEmployee(book));
        response.sendRedirect("employee-list");
    }

}
