package domain;

public class Employee {
	
	 private int id;
	    private String name;
	    private int age;
	    private int wage;
	    private int idDepartment;

	    public Employee(){};
	    public Employee(int id, String name, int age, int wage, int idDepartment)
	    {
	        this.id = id;
	        this.name=name;
	        this.age=age;
	        this.wage=wage;
	        this.idDepartment = idDepartment;
	    }

	    public int getIdDepartment() { return idDepartment; }

	    public void setIdDepartment(int idDepartment){this.idDepartment = idDepartment;}

	    public String getName() { return name; }

	    public int getAge() { return age; }

	    public int getWage(){ return wage; }

	    public void setName(String name)
	    {
	        this.name = name;
	    }

	    public void setAge(int age)
	    {
	        this.age = age;
	    }

	    public void setWage(int wage)
	    {
	        this.wage = wage;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public int getId() {return id; }

	    @Override
	    public String toString() {
	        return "Employees{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", age=" + age +
	                ", wage=" + wage +
	                ", idDepartment =" + idDepartment +
	                '}';
	    }

}
