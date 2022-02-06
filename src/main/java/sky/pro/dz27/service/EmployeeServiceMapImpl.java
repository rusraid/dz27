package sky.pro.dz27.service;


import org.springframework.stereotype.Service;
import sky.pro.dz27.Employee;
import sky.pro.dz27.exceptions.EmployeeExistException;
import sky.pro.dz27.exceptions.EmployeeNotFoundException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceMapImpl implements EmployeeMapService {

    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {

        Employee addingEmployee = new Employee(firstName, lastName);

        String key = firstName + lastName;
        if (employees.containsKey(key)) {
            throw new EmployeeExistException("This employee has been already added");
        }
        employees.put(key, addingEmployee);
        return addingEmployee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        String key = firstName + lastName;
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("This employee can't be found");
        }
        return employees.remove(key);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String key = firstName + lastName;
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("This employee can't be found");
        }
        return employees.get(key);
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
