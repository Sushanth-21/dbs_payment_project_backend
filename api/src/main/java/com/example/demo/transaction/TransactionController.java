package com.example.demo.transaction;

import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.database.Bank;
import com.example.demo.database.Customer;
import com.example.demo.database.Message;
import com.example.demo.database.Transaction;
import com.example.demo.database.TransferTypes;
import com.example.demo.repository.BankRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.MessageRepository;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.repository.TransferTypesRepository;

@RestController
public class TransactionController {
	@Autowired
	private TransactionRepository transactionrepository;
	@Autowired
	private CustomerRepository customerrepository;
	@Autowired
	private MessageRepository messagerepository;
	@Autowired 
	private TransferTypesRepository transfertypesrepository;
	@Autowired
	private BankRepository bankrepository;
	
	@GetMapping("/transaction/get_sender_details/{id}")
	public ResponseEntity<Object> getSenderDetails(@PathVariable String id){
		Optional<Customer> customer=customerrepository.findById(id);
		JSONObject msg=new JSONObject();
		if(customer.isEmpty())
		{
			msg.put("message", "Invalid customer id");
			return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
		}
		
		msg.put("accountholdername", customer.get().getAccountHolderName());
		msg.put("clearbalance", customer.get().getClearBalance());
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@GetMapping("/transaction/get_message_codes/")
	public ResponseEntity<Object> getMessageCodes() {
		JSONObject msg=new JSONObject();
//		List<String> codes=messagerepository.findAllMessageCodes();
		List<Message> messages=messagerepository.findAll();
//		msg.put("message_codes", codes);
		msg.put("message_codes", messages);
		return new ResponseEntity<>(msg,HttpStatus.OK);
		
	}
	
	@GetMapping("/transaction/get_transfer_types/")
	public ResponseEntity<Object> getTransferTypes() {
		JSONObject msg=new JSONObject();
//		List<String> codes=messagerepository.findAllMessageCodes();
		List<TransferTypes> transferTypes=transfertypesrepository.findAll();
//		msg.put("message_codes", codes);
		msg.put("message_codes", transferTypes);
		return new ResponseEntity<>(msg,HttpStatus.OK);
		
	}
	@PostMapping("/transaction/intiate/")
	public ResponseEntity<Object> intiateTransaction(@RequestBody JSONObject request){
		Optional<Customer> customer=customerrepository.findById(String.valueOf(request.get("customerId")));
		JSONObject msg=new JSONObject();
		if(customer.isEmpty())
		{
			msg.put("message", "Invalid customer id");
			return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
		}
		if((int)request.get("clear_balance")<0)
		{
			if(customer.get().getOverdraftflag()==0)
			{
				msg.put("message", "Insufficient funds");
				return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
			}
		}
		Optional<Bank> bank=bankrepository.findById(String.valueOf(request.get("receiverBic")));
		if(bank.isEmpty())
		{
			msg.put("message", "Invalid receiver bic");
			return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
		}
		Optional<Message> message=messagerepository.findById(String.valueOf(request.get("messageCode")));
		Optional<TransferTypes> transfertypes=transfertypesrepository.findById(String.valueOf(request.get("transferTypeCode")));
		Transaction transaction=new Transaction();
		transaction.setCustomerId(customer.get());
		transaction.setReceiverBIC(bank.get());
		transaction.setMessageCode(message.get());
		transaction.setTransferTypeCode(transfertypes.get());
		transaction.setReceiverAccountHolderName(String.valueOf(request.get("receiverAccountHolderName")));
		transaction.setReceiverAccountHolderNumber(String.valueOf(request.get("receiverAccountHolderNumber")));
		customer.get().setClearBalance((Long)request.get("clearBalance"));
		msg.put("customer", customerrepository.save(customer.get()));
		msg.put("transaction", transactionrepository.save(transaction));
		return new ResponseEntity<>(msg,HttpStatus.OK);
		
		
			
			
	
	}

}
