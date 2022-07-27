package com.khana.khazana.repository;

import com.khana.khazana.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByEmail(String email);

    Users findByUserId(Long userId);

    boolean existsByUserId(Long userId);
}
