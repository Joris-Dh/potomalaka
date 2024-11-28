package com.joris.potomalaka.repo;

import com.joris.potomalaka.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface contactRepo extends JpaRepository<Contact, Long> {
}
