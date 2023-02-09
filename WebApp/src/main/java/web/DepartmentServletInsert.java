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

import domain.Department;
import persistence.DAO;


@WebServlet("/insertDepartment")
public class DepartmentServletInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO departmentDAO;
       
    public DepartmentServletInsert() {
        super();
    }


	public void init(ServletConfig config) throws ServletException {
		departmentDAO = new DAO();
	}


	// Отобразить страницу создания продукта.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        	request.getRequestDispatcher("/WEB-INF/views/department-new-form.jsp").forward(request, response);
	
	}


	// Когда пользователь вводит информацию продукта, и нажимает Submit.
	// Этот метод будет вызван
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			insertDepartment1(request, response);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//doGet(request, response);
	}
	
	
	
    private void insertDepartment1(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ClassNotFoundException {
        String name = request.getParameter("name");
        Integer id = Integer.parseInt(request.getParameter("id"));
        departmentDAO.insertDepartment(id, name);
        response.sendRedirect("department-list");
    }
    


}
