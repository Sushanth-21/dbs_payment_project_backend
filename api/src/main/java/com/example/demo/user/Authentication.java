package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.CustomerUserRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.database.*;
import java.util.Optional;

import org.json.simple.JSONObject;

@RestController
public class Authentication {
	
	@Autowired
	private CustomerUserRepository customeruserrepository;
	@Autowired
	private EmployeeRepository employeerepository;
	@Autowired
	private CustomerRepository customerrepository;
	
	@PostMapping("/auth/login/")
	public ResponseEntity<Object> login(@RequestBody JSONObject data) {
		JSONObject msg=new JSONObject();
		Optional<CustomerUser> customer=customeruserrepository.findByUsername(String.valueOf(data.get("username")));
		if(customer.isEmpty())
		{
			Optional<Employee> employee=employeerepository.findByEmployeeName(String.valueOf(data.get("username")));
			if(employee.isEmpty())
			{
			msg.put("message", "invalid username");
			return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
			}
			if(employee.get().isActive())
			{
				msg.put("message","user already logged in");
				return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
			}
			if(employee.get().getEmployeePassword().equals(data.get("password")))
			{
				employee.get().setActive(true);
				return new ResponseEntity<>(employeerepository.save(employee.get()),HttpStatus.OK);
			}
			else
			{
				msg.put("message","incorrect password");
				return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
			}
			
		}
		
		if(customer.get().getPassword().equals(data.get("password")))
		{
			CustomerUser customeruser=customer.get();
			customeruser.setActive(true);
			return new ResponseEntity<>(customeruserrepository.save(customeruser),HttpStatus.OK);
		}
		else
		{
			msg.put("message", "invalid password");
			return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/auth/logout/{id}")
	public ResponseEntity<Object> logout(@PathVariable long id)
	{
		JSONObject msg=new JSONObject();
		Optional<CustomerUser> customer=customeruserrepository.findByUserId(id);
		if(customer.isEmpty())
		{
			Optional<Employee> employee=employeerepository.findByEmployeeId(id);
			if(employee.isEmpty())
			{
				msg.put("message","user not found");
				return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
			}
			else if(!employee.get().isActive())
			{
				msg.put("message","user not logged in");
				return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
			}
			else
			{
				Employee employeeuser=employee.get();
				employeeuser.setActive(false);
				employeeuser=employeerepository.save(employeeuser);
				msg.put("message","logout successful");
				return new ResponseEntity<>(msg,HttpStatus.OK);
			}
			
		}
		if(customer.isEmpty())
		{
			msg.put("message","user not found");
			return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
		}
		else if(!customer.get().isActive())
		{
			msg.put("message","user not logged in");
			return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
		}
		else
		{
			CustomerUser customeruser=customer.get();
			customeruser.setActive(false);
			customeruser=customeruserrepository.save(customeruser);
			msg.put("message","logout successful");
			return new ResponseEntity<>(msg,HttpStatus.OK);
		}
	}
	
	@PostMapping("/auth/set_customer_credentials/")
	public ResponseEntity<Object> setCustomerCredentials(@RequestBody JSONObject request){
		JSONObject msg=new JSONObject();
		Optional<Customer> customer=customerrepository.findById(String.valueOf(request.get("customerId")));
		if(customer.isEmpty())
		{
			msg.put("message","Invalid customer id.");
			return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
		}
		CustomerUser customeruser=new CustomerUser();
		customeruser.setCustomer(customer.get());
		customeruser.setUsername(String.valueOf(request.get("username")));
		customeruser.setPassword(String.valueOf(request.get("password")));
		customeruser=customeruserrepository.save(customeruser);
		msg.put("message", "credentials set for customer - "+customer.get().getCustomerId());
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}

}
