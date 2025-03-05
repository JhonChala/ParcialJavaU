// This interface is a repository for the Employees entity, used to interact with the database.
// It extends JpaRepository, providing CRUD operations (Create, Read, Update, Delete) and
// support for pagination and sorting.

package com.universidad.parcial.repository;

import com.universidad.parcial.Model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Marks this interface as a Spring component, enabling database interaction through JPA.
public interface EmployeeRepository extends JpaRepository<Employees, Long> {
    // JpaRepository includes methods like save(), findById(), findAll(), and deleteById().
}
