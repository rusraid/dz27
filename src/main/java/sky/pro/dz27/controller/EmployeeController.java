package sky.pro.dz27.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.dz27.Employee;
import sky.pro.dz27.service.EmployeeMapService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeMapService employeeService;

    public EmployeeController(EmployeeMapService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String greetEmployee() {
        return "Hello employess!";
    }
    @GetMapping("/add")
    public Employee addEmployee(@RequestParam ("firstName") String firstname,
                                @RequestParam ("lastName") String lastname) {
        return employeeService.addEmployee(firstname, lastname);
    }
    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam ("firstName") String firstname,
                                   @RequestParam ("lastName") String lastname) {
        return employeeService.removeEmployee(firstname, lastname);
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam ("firstName") String firstname,
                                 @RequestParam ("lastName") String lastname) {
        return employeeService.findEmployee(firstname, lastname);
    }

    @GetMapping("/getAllEmployees")
    public Collection<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
