package io.swagger.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.swagger.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	
	
	Employee findByUsername(String employeename);

}
