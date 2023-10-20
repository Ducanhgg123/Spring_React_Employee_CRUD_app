package com.ducanh.test1.Transfer;

import com.ducanh.test1.DAO.EmployeeDAO;
import com.ducanh.test1.DTO.EmployeeDTO;
import com.ducanh.test1.Entity.EmployeeEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeTransfer {
    public EmployeeEntity toEntity(EmployeeDTO employeeDTO){
        EmployeeEntity employeeEntity=new EmployeeEntity();
        if (employeeDTO.getId()==null){
            employeeDTO.setId(0);
        }

        employeeEntity.setId(employeeDTO.getId());
        employeeEntity.setFirstName(employeeDTO.getFirstName());
        employeeEntity.setLastName(employeeDTO.getLastName());
        employeeEntity.setEmail(employeeDTO.getEmail());

        return employeeEntity;
    }

    public EmployeeDTO toDTO(EmployeeEntity employeeEntity){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employeeEntity.getId());
        employeeDTO.setFirstName(employeeEntity.getFirstName());
        employeeDTO.setLastName(employeeEntity.getLastName());
        employeeDTO.setEmail(employeeEntity.getEmail());

        return employeeDTO;
    }
}
