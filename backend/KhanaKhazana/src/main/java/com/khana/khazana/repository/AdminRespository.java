package com.khana.khazana.repository;

import com.khana.khazana.model.Restaurant;
import com.khana.khazana.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminRespository extends JpaRepository<Users, Long> {

    //@Query(value = "select * from userinfo where role = ?1")
    List<Users> findAllByRole(String role);

    Users findById(long id);

    void deleteById(long id);

}
