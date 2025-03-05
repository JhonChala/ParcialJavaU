// Defines the package for the controller class
package com.universidad.parcial.controller;

// Import necessary classes for Employees model and service
import com.universidad.parcial.Model.Employees;
import com.universidad.parcial.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Marks this class as a REST controller to handle HTTP requests
@RestController
// Base mapping for all endpoints in this controller
@RequestMapping("/employees")
public class EmployeesController {

    // Service layer dependency to handle business logic
    private final EmployeesService employeesService;

    // Constructor-based dependency injection
    @Autowired
    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    // HTTP GET request to fetch all employees
    @GetMapping
    public List<Employees> getAllEmployees() {
        return employeesService.getAllEmployees();
    }

    // HTTP GET request to fetch a single employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employees> getEmployeeById(@PathVariable Long id) {
        return employeesService.getEmployeeById(id)
                .map(ResponseEntity::ok) // Returns 200 OK if employee is found
                .orElse(ResponseEntity.notFound().build()); // Returns 404 if not found
    }

    // HTTP POST request to create a new employee
    @PostMapping
    public Employees createEmployee(@RequestBody Employees employee) {
        return employeesService.saveEmployee(employee);
    }

    // HTTP PUT request to update an existing employee by ID
    @PutMapping("/{id}")
    public ResponseEntity<Employees> updateEmployee(@PathVariable Long id, @RequestBody Employees employeeDetails) {
        try {
            Employees updatedEmployee = employeesService.updateEmployee(id, employeeDetails);
            return ResponseEntity.ok(updatedEmployee); // Returns 200 OK with the updated employee
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // Returns 404 if employee not found
        }
    }

    // HTTP DELETE request to remove an employee by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        employeesService.deleteEmployee(id);
        return ResponseEntity.ok().build(); // Returns 200 OK after deletion
    }
}
