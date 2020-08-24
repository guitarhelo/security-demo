package com.smartcode.security.securitydemo.repository;
import com.smartcode.security.securitydemo.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "employee", path = "employee")
public interface EmployeeRepository extends CrudRepository<Employee, Integer>
{
    List<Employee> findByFirstname(String firstname);

    List<Employee> findByIdAndLastname(Integer id, String lastname);
}