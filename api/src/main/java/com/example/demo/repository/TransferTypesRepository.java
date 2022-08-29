package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.database.TransferTypes;

@Repository
public interface TransferTypesRepository extends JpaRepository<TransferTypes,String>{

}
