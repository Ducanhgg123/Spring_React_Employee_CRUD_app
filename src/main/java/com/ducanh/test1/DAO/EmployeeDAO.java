package com.ducanh.test1.DAO;

import com.ducanh.test1.DTO.EmployeeDTO;
import com.ducanh.test1.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface EmployeeDAO {
    EmployeeEntity findEmployeeById(int id);

    List<EmployeeEntity> findEmployees();

    EmployeeEntity deleteEmployee(int id);

    EmployeeEntity saveEmployee(EmployeeEntity employeeEntity);


}
