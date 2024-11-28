package com.joris.potomalaka.repo;

import com.joris.potomalaka.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepo extends JpaRepository<User, Long>{
    User findByUsername(String username);
}

