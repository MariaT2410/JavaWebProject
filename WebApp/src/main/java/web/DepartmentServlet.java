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

import domain.Department;
import persistence.DAO;


@WebServlet(urlPatterns = { "/department-list"})
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO departmentDAO;
       

    public DepartmentServlet() {  super(); }
    
    public void init() 
    { departmentDAO = new DAO();}


    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		System.out.println(action);

        try {
            switch (action) {
            /*
                case "/newDepartment":
                    showNewForm(request, response);
                    break;
                    
                case "/insertDepartment":
                    insertDepartment(request, response);
                    break;
                    */
                //case "/deleteDepartment":
                  //  deleteDepartment(request, response);
                 //   break;
                    
                //case "/editDepartment":
                  //  showEditForm(request, response);
                  //  break;
                //case "/updateDepartment":
                  //  updateDepartment(request, response);
                  //  break;
                default:
                    listDepartment(request, response);
                    break;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
	}


    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

    private void listDepartment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ClassNotFoundException {
        List <Department> listDepartment = departmentDAO.queryDepartment();
        request.setAttribute("listDepartment", listDepartment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/department-list.jsp");
        dispatcher.forward(request, response);
    }
    /*

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/department-form.jsp");
        dispatcher.forward(request, response);
    }
    
    
    
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        Department existingUser = departmentDAO.selectDepartment(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/department-form.jsp");
        request.setAttribute("department", existingUser);
        dispatcher.forward(request, response);
        

   // }

    private void insertDepartment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ClassNotFoundException {
        String name = request.getParameter("name");
        Integer id = request.getIntHeader("id");
        departmentDAO.insertDepartment(id, name);
        response.sendRedirect("department-list");
    }
   

    private void updateDepartment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        Department book = new Department(id, name);
        departmentDAO.updateDepartment(book);
        response.sendRedirect("department-list");
    }

  
    private void deleteDepartment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        departmentDAO.deleteDepartment(id);
        response.sendRedirect("department-list");

    }
    */

}
