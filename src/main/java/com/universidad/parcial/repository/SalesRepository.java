// This interface defines a repository for the Sales entity, allowing interaction with the database.
// It extends JpaRepository, providing basic CRUD operations (Create, Read, Update, Delete)
// as well as support for pagination and sorting.

package com.universidad.parcial.repository;

import com.universidad.parcial.Model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Marks this interface as a Spring-managed component, enabling database operations for Sales.
public interface SalesRepository extends JpaRepository<Sales, Long> {
    // JpaRepository comes with pre-built methods like save(), findById(), findAll(), and deleteById().
}
