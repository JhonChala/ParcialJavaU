// This interface is a repository for the Client entity, used to interact with the database.
// It extends JpaRepository, which provides standard CRUD operations (Create, Read, Update, Delete)
// and additional features such as pagination and sorting.

package com.universidad.parcial.repository;

import com.universidad.parcial.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Marks this interface as a Spring Data repository, so it's recognized as a bean.
public interface ClientRepository extends JpaRepository<Client, Long> {
    // JpaRepository provides methods like save(), findById(), findAll(), deleteById(), etc.
}
