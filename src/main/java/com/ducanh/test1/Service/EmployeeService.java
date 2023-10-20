package com.ducanh.test1.Service;

import com.ducanh.test1.DTO.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO findEmployeeById(int id);

    List<EmployeeDTO> findEmployees();

    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO deleteEmployee(int id);
}
