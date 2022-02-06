package sky.pro.dz27.service;

import sky.pro.dz27.Employee;

import java.util.Collection;

public interface EmployeeMapService {

    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> getAllEmployees();
}
