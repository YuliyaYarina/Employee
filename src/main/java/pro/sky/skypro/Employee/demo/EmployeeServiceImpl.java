package pro.sky.skypro.Employee.demo;
import org.springframework.stereotype.Service;
import pro.sky.skypro.Employee.demo.exception.EmployeeAlreadyAddedException;
import pro.sky.skypro.Employee.demo.exception.EmployeeNotFoundException;
import pro.sky.skypro.Employee.demo.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;




@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final int STORAGE_SIZE = 5;
    private final List<Employee> employees = new ArrayList<>();

@Override
    public Employee addEmployee(String fName, String lName) {
    Employee employee = new Employee(fName, lName);

    if (employees.size() == STORAGE_SIZE) {
        throw new EmployeeStorageIsFullException();
    }

    if (employees.contains(employee)) {
        throw new EmployeeAlreadyAddedException("уже есть такой сотрудник в хранилище");
    }

    employees.add(employee);
    return employee;
}

    @Override
    public void removeEmployee(String fName, String lName){
        Employee employee = new Employee(fName,lName);

        if (employees.contains(employee)) {
            throw new EmployeeNotFoundException("Такого сотрудника нет в хранилище");
        }

        employees.remove(employee);
    }

    @Override
    public Employee findEmployee(String fName, String lName) {
        Employee employeeToFind = new Employee(fName, lName);

        if (!employees.contains(employeeToFind)) {
            throw new EmployeeNotFoundException("Такого работника нет");
        }

        for (Employee employee : employees) {
            if (employee.equals(employeeToFind)) {
                return employee;
            }
        }

        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

}