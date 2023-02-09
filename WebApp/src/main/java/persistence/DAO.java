package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Department;
import domain.Employee;

public class DAO {
	private static final String HOSTNAME = "localhost";
    private static final String DBNAME = "mysqlidea";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "mary";
    private static final String URL = "jdbc:mysql://" + HOSTNAME + ":3306/" + DBNAME + "?verifyServerCertificate=false" +
            "&userSSL=false" + "requireSSL=false" +
            "&amp" + "&serverTimezone=UTC";

    public static Connection getMySQLConnection(String hostName, String dbName,
                                                String userName, String password) throws SQLException,
            ClassNotFoundException {

        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName + "?verifyServerCertificate=false" + "&userSSL=false" + "requireSSL=false" +
                "&amp" + "&serverTimezone=UTC";
                
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        return conn;
    }

    // Statement меТоды для SELECT набор данных
    private static <T> List<T> getResult(String query, Mapping<T> mapping) throws SQLException, ClassNotFoundException {
        List<T> result = new ArrayList<>();
        try (Connection conn = getMySQLConnection(HOSTNAME, DBNAME, USERNAME, PASSWORD);
             PreparedStatement pstm = conn.prepareStatement(query);
             ResultSet rs = pstm.executeQuery()){

            while (rs.next()) {
                T item = mapping.map(rs);
                result.add(item);
            }
            //conn.close();
            //pstm.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        return result;
    }


    // Statement меТоды для UPDATE, INSERT и DROP 
    private boolean Query(String query) {
        try (Connection conn = getMySQLConnection(HOSTNAME, DBNAME, USERNAME, PASSWORD);
             PreparedStatement pstm = conn.prepareStatement(query)){
            int result = pstm.executeUpdate();
            if (result > 0) {
                return true;
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

        //GET DEPARTMENT
    public List<Department> queryDepartment() throws SQLException, ClassNotFoundException {
        String query = "Select * from mysqlidea.department";
        Mapping<Department> mapping = rs -> {
            try {
                int id = rs.getInt("Id");
                String name = rs.getString("Name");
                return new Department(id, name);

            }catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        };
        return getResult(query, mapping);
    }

    public List<Department> selectDepartment(int id) throws SQLException, ClassNotFoundException {
        String query = "Select id, name from mysqlidea.department where id =" + id;
        //Department department = null;

        
        Mapping<Department> mapping = rs -> {
            try {
                String name = rs.getString("name");
                return new Department(id, name);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        };
        System.out.println("HIIIIIIIIIIIIIIIII");
        System.out.println(query);
        System.out.println(mapping);
        
        return  getResult(query, mapping);


    }
    public List<Employee> selectEmployee(int id) throws SQLException, ClassNotFoundException {
        String query = "Select id, name, age, wage, idDepartment from mysqlidea.employee where id =" + id;
        //Department department = null;
        Mapping<Employee> mapping = rs -> {
            try {
                String name = rs.getString("name");
                Integer age = rs.getInt("age");
                Integer wage = rs.getInt("wage");
                Integer idDepartment = rs.getInt("idDepartment");
                return new Employee(id, name, age, wage, idDepartment);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        };
        System.out.println(query);
        return  getResult(query, mapping);


    }

    //GET DEPARTMENT
    public List<Employee> queryEmployee() throws SQLException, ClassNotFoundException {
        String query = "Select * from mysqlidea.employee";

        Mapping<Employee> mapping = rs -> {
            try {
                int id = rs.getInt("Id");
                String name = rs.getString("Name");
                int age = rs.getInt("Age");
                int wage = rs.getInt("Wage");
                int idDepartment = rs.getInt("idDepartment");
                return new Employee(id, name, age, wage, idDepartment);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        };
        return getResult(query, mapping);
    }

    //INSERT
    public boolean insertEmployee(int id, String name, int age, int wage, int idDepartment) throws SQLException, ClassNotFoundException {
        String query = "Insert into mysqlidea.employee(id, name, age, wage, idDepartment) values ('"+ id + "', '"+ name +  "', '" + age +  "', '" + wage + "', '"+ idDepartment + "')";
        System.out.println(query);
        return Query(query);
    }


    //DELETE
    public boolean deleteEmployee( int id) throws SQLException, ClassNotFoundException {
        String query = "Delete From mysqlidea.employee where id=" + id;
        return Query(query);
    }
    public boolean updateEmployee(Employee employee)   {
        String query = " Update employee set name =?, age =?, wage =?, idDepartment =? where id =?;";
    	try (Connection conn = getMySQLConnection(HOSTNAME, DBNAME, USERNAME, PASSWORD);
    			PreparedStatement pstm = conn.prepareStatement(query)){
    	        pstm.setString(1, employee.getName());
    	        pstm.setLong(2, employee.getAge());
    	        pstm.setLong(3, employee.getWage());
    	        pstm.setLong(4, employee.getIdDepartment());
    	        pstm.setLong(5, employee.getId());
    	        System.out.println(pstm);
                int result = pstm.executeUpdate();
                if (result > 0) {
                    return true;}
    	        } catch (ClassNotFoundException e) {
    	        	e.printStackTrace();
    			} catch (SQLException e) {
    				e.printStackTrace();
    				}
    				
            							
            System.out.println(query);
            return false;


    }

    //INSERT
    public boolean insertDepartment(int id, String name) throws SQLException, ClassNotFoundException {
        String query = "Insert into mysqlidea.department(id, name) values ('"+ id + "', '"+ name + "')";
        //System.out.println(query);
        return Query(query);
    }


    //DELETE
    public boolean deleteDepartment(int id) throws SQLException, ClassNotFoundException {
        String query = "Delete From mysqlidea.department where id=" + id;
        return Query(query);
    }

   
    public boolean updateDepartment(Department department)   {
        String query = " Update department set name =? where id =?;";
        
		try (Connection conn = getMySQLConnection(HOSTNAME, DBNAME, USERNAME, PASSWORD);
			PreparedStatement pstm = conn.prepareStatement(query)){
	        pstm.setString(1, department.getName());
	        pstm.setLong(2, department.getId());
            int result = pstm.executeUpdate();
            if (result > 0) {
                return true;}
	        } catch (ClassNotFoundException e) {
	        	e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
				}
				
        							
        System.out.println(query);
        return false;
    }
   

}
