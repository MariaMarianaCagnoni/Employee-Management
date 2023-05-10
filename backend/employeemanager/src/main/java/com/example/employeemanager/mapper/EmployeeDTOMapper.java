package com.example.employeemanager.mapper;

import com.example.employeemanager.dto.EmployeeDTO;
import com.example.employeemanager.model.Employee;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * @author mariana
 * @Project: employeemanager
 */
@Service
public class EmployeeDTOMapper implements Function<Employee, EmployeeDTO> {

    @Override
    public EmployeeDTO apply(Employee employee) {
        return new EmployeeDTO(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getJobTitle(),
                employee.getPhone(),
                employee.getImageUrl(),
                employee.getEmployeeCode()

        );
    }
}
