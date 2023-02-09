package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.DAO;


@WebServlet("/insertEmployee")
public class EmployeeServletInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO departmentDAO;
       

    public EmployeeServletInsert() {
        super();
       
    }

    @Override
	public void init(ServletConfig config) throws ServletException {
		departmentDAO = new DAO();
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/employee-new-form.jsp").forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			insertEmployee(request, response);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//doGet(request, response);
	}
	
	
    private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ClassNotFoundException {
        String name = request.getParameter("name");
        int id = Integer.parseInt(request.getParameter("id"));
        int age = Integer.parseInt(request.getParameter("age"));
        int wage = Integer.parseInt(request.getParameter("wage"));
        int idDepartment = Integer.parseInt(request.getParameter("idDepartment"));
        System.out.println(id);
        System.out.println(age);
        System.out.println(wage);
        System.out.println(idDepartment);
        departmentDAO.insertEmployee(id, name, age,wage, idDepartment);
        response.sendRedirect("employee-list");
    }

}
