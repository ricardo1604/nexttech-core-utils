package com.nexttech.utils.nexttech_core_utils.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexttech.utils.nexttech_core_utils.model.User;

public interface UserRepositorio extends JpaRepository<User, Long>{
    Optional<User> findByUsuario(String usuario);
    Optional<User> findByEmail(String email);
    boolean existsByUsuario(String usuario);
    boolean existsByEmail(String email);
}
