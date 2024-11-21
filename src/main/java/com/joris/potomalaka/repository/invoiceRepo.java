package com.joris.potomalaka.repository;

import com.joris.potomalaka.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface invoiceRepo extends JpaRepository<Invoice, Long> {
}
