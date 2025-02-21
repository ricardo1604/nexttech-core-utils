package com.nexttech.utils.nexttech_core_utils.repo;

import com.nexttech.utils.nexttech_core_utils.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioJpa extends JpaRepository<User, Long>{

}
