package com.joris.potomalaka.repo;

import com.joris.potomalaka.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface invoiceRepo extends JpaRepository<Invoice, Long> {
}
