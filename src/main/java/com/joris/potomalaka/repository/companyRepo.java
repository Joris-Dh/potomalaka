package com.joris.potomalaka.repository;

import com.joris.potomalaka.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface companyRepo extends JpaRepository<Company, Long> {
}
