package pro.sky.skypro.Employee.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skypro.Employee.demo.Employee;
import pro.sky.skypro.Employee.demo.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(
            @RequestParam("fname") String fName,
            @RequestParam("lname") String lName
    ){
       return employeeService.addEmployee(fName,lName);
    }

    @GetMapping(path = "/remove")
    public void removeEmployee(
            @RequestParam("name") String fName,
            @RequestParam("lname") String lName
    ){
        employeeService.removeEmployee(fName, lName);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(
            @RequestParam("name") String fName,
            @RequestParam("lname") String lName
    ){
       return employeeService.findEmployee(fName,lName);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }



}
