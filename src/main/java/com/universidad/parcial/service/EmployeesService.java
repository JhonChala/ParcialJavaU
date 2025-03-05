// This service class manages business logic for handling employee operations.

package com.universidad.parcial.service;

import com.universidad.parcial.Model.Employees;
import com.universidad.parcial.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marks this class as a Spring service component.
public class EmployeesService {

    private final EmployeeRepository employeesRepository;

    // Constructor-based dependency injection for EmployeeRepository.
    @Autowired
    public EmployeesService(EmployeeRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    // Retrieves all employees from the database.
    public List<Employees> getAllEmployees() {
        return employeesRepository.findAll();
    }

    // Finds an employee by ID, wrapped in an Optional to handle null cases.
    public Optional<Employees> getEmployeeById(Long id) {
        return employeesRepository.findById(id);
    }

    // Saves a new employee or updates an existing employee in the database.
    public Employees saveEmployee(Employees employee) {
        return employeesRepository.save(employee);
    }

    // Updates employee details if the employee exists.
    public Employees updateEmployee(Long id, Employees employeeDetails) {
        return employeesRepository.findById(id).map(employee -> {
            employee.setName(employeeDetails.getName());
            employee.setEmail(employeeDetails.getEmail());
            employee.setAddress(employeeDetails.getAddress());
            employee.setCellphone(employeeDetails.getCellphone());
            employee.setActive(employeeDetails.getActive());
            return employeesRepository.save(employee); // Saves the updated employee.
        }).orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    // Deletes an employee by their ID.
    public void deleteEmployee(Long id) {
        employeesRepository.deleteById(id);
    }
}
