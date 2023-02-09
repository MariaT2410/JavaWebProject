package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Department;
import persistence.DAO;


@WebServlet(urlPatterns = {"/editDepartment"})
public class DepartmentServletEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO departmentDAO;
	

    public DepartmentServletEdit() {
        super();
        
    }


    @Override
	public void init(ServletConfig config) throws ServletException {
		departmentDAO = new DAO();
	}

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//request.getRequestDispatcher("/WEB-INF/views/department-form.jsp").forward(request, response);
    	
        try {
        	showEditForm(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}


    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
        try {
        	updateDepartment(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

    private void updateDepartment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        System.out.println(id);
        System.out.println(name);
        Department book = new Department(id, name);
        departmentDAO.updateDepartment(book);
        request.setAttribute("department", departmentDAO.updateDepartment(book));
        response.sendRedirect("department-list");
    }

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        System.out.println(departmentDAO.selectDepartment(id));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/department-form.jsp");
        request.setAttribute("department", departmentDAO.selectDepartment(id));
        dispatcher.forward(request, response);

    }
}
