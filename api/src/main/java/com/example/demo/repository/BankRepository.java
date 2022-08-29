package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.database.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank,String>{

}
