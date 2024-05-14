package org.services.library_management.repository;

import org.services.library_management.entities.Records;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryRecords extends JpaRepository<Records,Long> {
}
