package com.capgemini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.entities.Employee;
import com.capgemini.repository.EmployeeRepository;

@SpringBootApplication
public class Project3SpringJpaApplication implements CommandLineRunner{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Project3SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Create / Update / Delete / read
		
		// create();
		// read();
		// update();
		delete();
	}
	
	public void delete() {
		
		// first find
		Employee dbEmployee =  employeeRepository.findById(1).get();
		
		if(dbEmployee != null) {
			employeeRepository.deleteById(1);
		}
	}
	
	
	public void update() {
		// first find
		Employee dbEmployee =  employeeRepository.findById(1).get();

		if(dbEmployee != null) {
			dbEmployee.setName("rahul adhikari");
			dbEmployee.setEmail("rahula@gmail.com");
			
			// update
			employeeRepository.save(dbEmployee);
		}
	}
	
	public void read() {
		Employee employee = employeeRepository.findById(1).get();
		System.out.println(employee);
	}
	
	public void create() {
		Employee employee = new Employee();
		employee.setName("rahul");
		employee.setEmail("rahul@gmail.com");
		employee.setMobile("11223344");
		
		employeeRepository.save(employee);
	}

}
