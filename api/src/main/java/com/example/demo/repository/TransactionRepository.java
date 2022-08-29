package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.database.Bank;
import com.example.demo.database.Customer;
import com.example.demo.database.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long>{
	@Query("SELECT t.customerId.customerId,t.customerId.accountHolderName,SUM(t.inrAmount) AS s FROM Transaction AS t GROUP BY t.customerId.customerId ORDER BY s DESC")
	List<String> findTopCustomers();
	
	@Query("SELECT t.receiverBIC.bic,t.receiverBIC.bankName,SUM(t.inrAmount) AS s FROM Transaction AS t GROUP BY t.receiverBIC.bic ORDER BY s DESC")
	List<String> findTopBanks();
	
	@Query("SELECT t.messageCode.messageCode,t.messageCode.instruction,COUNT(t.messageCode.messageCode) AS s FROM Transaction AS t GROUP BY t.messageCode.messageCode ORDER BY s DESC")
	List<String> findTopMessageCodes();
	
	List<Transaction> findAllByCustomerId(Customer customerId);
}
