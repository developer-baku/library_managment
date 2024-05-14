package org.services.library_management.repository;

import org.services.library_management.entities.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPatron extends JpaRepository<Patron,Long> {
}
