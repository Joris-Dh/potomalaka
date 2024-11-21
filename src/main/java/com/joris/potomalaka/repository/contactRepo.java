package com.joris.potomalaka.repository;

import com.joris.potomalaka.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface contactRepo extends JpaRepository<Contact, Long> {
}
