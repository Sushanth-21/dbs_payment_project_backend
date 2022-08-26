package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.database.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message,String>{
	@Query("SELECT messageCode FROM Message message")
	List<String> findAllMessageCodes();
}
