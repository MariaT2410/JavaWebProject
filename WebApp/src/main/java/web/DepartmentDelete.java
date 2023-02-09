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


@WebServlet(urlPatterns = {"/deleteDepartment"})
public class DepartmentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO departmentDAO;
       

    public DepartmentDelete() {
        super();
       
    }


	public void init(ServletConfig config) throws ServletException {
		departmentDAO = new DAO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		deleteDepartment(request, response);
		} catch (SQLException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	

    private void deleteDepartment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        departmentDAO.deleteDepartment(id);
        response.sendRedirect("department-list");
    }


}
