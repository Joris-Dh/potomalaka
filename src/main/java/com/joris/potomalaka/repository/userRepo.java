package com.joris.potomalaka.repository;

import com.joris.potomalaka.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepo extends JpaRepository<User, Long>{
}

