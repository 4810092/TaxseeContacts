package ganikhodjaev.taxseecontacts.content;


import java.util.List;

/**
 * @author Khasan Ganikhodjaev
 */
public class Department {
    private String ID;
    private String Name;
    private List<Department> Departments;
    private List<Employee> Employees;


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public String getIdAndName() {
        return ID + " " + Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Department> getDepartments() {
        return Departments;
    }

    public void setDepartments(List<Department> departments) {
        Departments = departments;
    }

    public List<Employee> getEmployees() {
        return Employees;
    }

    public void setEmployees(List<Employee> employees) {
        Employees = employees;
    }
}

