package com.joris.potomalaka.repo;

import com.joris.potomalaka.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface companyRepo extends JpaRepository<Company, Long> {
}
