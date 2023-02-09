package domain;

public class Department {

	 private String name;
	    private int id;

	    public Department(){};
	    public Department(int id, String name)
	    {
	        this.id = id;
	        this.name = name;
	    }
	    public Department(String name)
	    {
	        this.name = name;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }


	    public String getName() { return name; }

	    public void setName(String name)
	    {
	        this.name=name;
	    }



	    @Override
	    public String toString() {
	        return "Department{" +
	                "nameDepartment='" + name + '\''
	                + ", id=" + id +
	                '}';
	    }
}
