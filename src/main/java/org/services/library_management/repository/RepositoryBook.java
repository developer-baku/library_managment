package org.services.library_management.repository;

import org.services.library_management.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryBook  extends JpaRepository<Book,Long> {
}
