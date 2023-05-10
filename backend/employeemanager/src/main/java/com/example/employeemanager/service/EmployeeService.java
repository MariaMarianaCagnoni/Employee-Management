package com.example.employeemanager.service;

import com.example.employeemanager.dto.EmployeeDTO;
import com.example.employeemanager.exeception.UserNotFoundException;
import com.example.employeemanager.mapper.EmployeeDTOMapper;
import com.example.employeemanager.model.Employee;
import com.example.employeemanager.repository.EmployeeRepository;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Log4j2
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private  final EmployeeDTOMapper employeeDTOMapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeDTOMapper employeeDTOMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeDTOMapper = employeeDTOMapper;
    }

    public List<EmployeeDTO> findAllEmployees() {

        return this.employeeRepository.findAll()
                .stream()
                .map(employeeDTOMapper)
                .collect(Collectors.toList());
    }


    public Employee addEmployee(@NotNull Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return this.employeeRepository.save(employee);

    }

    public Employee findEmployeeById(Long id) {
        return this.employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }


    public Employee updateEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        this.employeeRepository.deleteById(id);

    }
}
