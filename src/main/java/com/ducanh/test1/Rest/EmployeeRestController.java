package com.ducanh.test1.Rest;

import com.ducanh.test1.DTO.EmployeeDTO;
import com.ducanh.test1.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/{id}")
    public EmployeeDTO findEmployeeById(@PathVariable(name = "id") int id){
        EmployeeDTO employeeDTO = employeeService.findEmployeeById(id);
        return employeeDTO;
    }

    @GetMapping("/employees")
    public List<EmployeeDTO> findEmployess(){
        return employeeService.findEmployees();
    }

    @PostMapping("/employees")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO employeeDTOTmp = employeeService.saveEmployee(employeeDTO);
        return employeeDTOTmp;
    }

    @PutMapping("/employees")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO employeeDTOTmp = employeeService.saveEmployee(employeeDTO);
        return employeeDTOTmp;
    }

    @DeleteMapping("/employees/{id}")
    public EmployeeDTO deleteEmployee(@PathVariable(name = "id") int id){
        EmployeeDTO employeeDTO = employeeService.deleteEmployee(id);
        return employeeDTO;
    }
}
