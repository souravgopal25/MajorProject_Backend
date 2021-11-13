package com.sourav.majorProject.dao;

import com.sourav.majorProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUid(String uid);
}
