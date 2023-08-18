package pro.sky.skypro.Employee.demo;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(String fName, String lName);

    void removeEmployee(String fName, String lName);

    Employee findEmployee(String fName, String lName);
    List<Employee> getAllEmployees();
}
