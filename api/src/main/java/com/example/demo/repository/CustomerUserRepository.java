package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.database.CustomerUser;

import java.util.Optional;

@Repository
public interface CustomerUserRepository extends JpaRepository<CustomerUser,Long>{
	Optional<CustomerUser> findByUserId(int userId);
	Optional<CustomerUser> findByUsername(String username);

}
