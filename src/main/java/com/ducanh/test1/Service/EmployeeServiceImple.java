package com.ducanh.test1.Service;

import com.ducanh.test1.DAO.EmployeeDAO;
import com.ducanh.test1.DTO.EmployeeDTO;
import com.ducanh.test1.Entity.EmployeeEntity;
import com.ducanh.test1.Transfer.EmployeeTransfer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImple implements EmployeeService{
    private EmployeeTransfer employeeTransfer;
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImple(EmployeeTransfer employeeTransfer, EmployeeDAO employeeDAO) {
        this.employeeTransfer = employeeTransfer;
        this.employeeDAO = employeeDAO;
    }

    @Override
    public EmployeeDTO findEmployeeById(int id) {
        EmployeeEntity employeeEntity = employeeDAO.findEmployeeById(id);
        EmployeeDTO employeeDTO = employeeTransfer.toDTO(employeeEntity);
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> findEmployees() {
        List<EmployeeEntity> employeeEntities = employeeDAO.findEmployees();
        List<EmployeeDTO> employeeDTOS = employeeEntities.stream().map(e -> employeeTransfer.toDTO(e)).toList();
        return employeeDTOS;
    }

    @Transactional
    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = employeeTransfer.toEntity(employeeDTO);
        employeeEntity = employeeDAO.saveEmployee(employeeEntity);
        employeeDTO = employeeTransfer.toDTO(employeeEntity);
        return employeeDTO;
    }

    @Transactional
    @Override
    public EmployeeDTO deleteEmployee(int id) {
        EmployeeEntity employeeEntity = employeeDAO.deleteEmployee(id);
        EmployeeDTO employeeDTO = employeeTransfer.toDTO(employeeEntity);
        return employeeDTO;
    }
}
