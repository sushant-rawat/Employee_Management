package com.geekster.Employee.repository;

import com.geekster.Employee.model.Employee;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.Fetch;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends CrudRepository<Employee,Integer> {

}
