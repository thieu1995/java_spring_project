package com.thieunv.data.repository;

import com.thieunv.data.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by thieunv on 05/06/2017.
 */

public interface RoleRepository extends JpaRepository<Role, Integer>{
    Role findByRole(String role);
}