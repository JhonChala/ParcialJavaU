// This interface is a repository for the Distributors entity, used to interact with the database.
// It extends JpaRepository, inheriting methods for CRUD operations (Create, Read, Update, Delete)
// along with additional support for pagination and sorting.

package com.universidad.parcial.repository;

import com.universidad.parcial.Model.Distributors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Marks this interface as a Spring component, enabling dependency injection and database interaction.
public interface DistributorRepository extends JpaRepository<Distributors, Long> {
    // JpaRepository already provides basic methods like save(), findById(), findAll(), and deleteById().
}
