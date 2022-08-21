package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.database.Logger;

@Repository
public interface LoggerRepository extends JpaRepository<Logger,Long>{

}
