package com.mpc.demo.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mpc.demo.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

    @Override
    void delete(Role role);

}
