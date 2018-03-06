package com.mpc.demo.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mpc.demo.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    @Override
    void delete(User user);

}
