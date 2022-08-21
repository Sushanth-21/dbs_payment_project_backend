package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	
	@PostMapping("/auth/login/")
	public Object login(@RequestBody JSONObject data) {
		JSONObject msg=new JSONObject();
		Optional<CustomerUser> customer=customeruserrepository.findByUsername(String.valueOf(data.get("username")));
		if(customer.isEmpty())
		{
			Optional<Employee> employee=employeerepository.findByEmployeeName(String.valueOf(data.get("username")));
			if(employee.isEmpty())
			{
			msg.put("message", "invalid username");
			return msg;
			}
			if(employee.get().isActive())
			{
				msg.put("message","user already logged in");
				return msg;
			}
			if(employee.get().getEmployeePassword().equals(data.get("password")))
			{
				employee.get().setActive(true);
				return employeerepository.save(employee.get());
			}
			else
			{
				msg.put("message","incorrect password");
				return msg;
			}
			
		}
		
		if(customer.get().getPassword().equals(data.get("password")))
		{
			CustomerUser customeruser=customer.get();
			customeruser.setActive(true);
			return customeruserrepository.save(customeruser);
		}
		else
		{
			msg.put("message", "invalid password");
			return msg;
		}
		
	}
	
	@PostMapping("/auth/logout/{id}")
	public Object logout(@PathVariable int id)
	{
		JSONObject msg=new JSONObject();
		Optional<CustomerUser> customer=customeruserrepository.findByUserId(id);
		if(customer.isEmpty())
		{
			msg.put("message","user not found");
		}
		else if(!customer.get().isActive())
		{
			msg.put("message","user not logged in");
		}
		else
		{
			CustomerUser customeruser=customer.get();
			customeruser.setActive(false);
			customeruser=customeruserrepository.save(customeruser);
			msg.put("message","logout successful");
		}
		return msg;
	}

}
