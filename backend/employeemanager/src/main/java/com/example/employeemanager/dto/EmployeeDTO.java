package com.example.employeemanager.dto;

/**
 * @author mariana
 * @Project: employeemanager
 */
public record EmployeeDTO (
        Long id,
        String Name,
        String joBTitle,
        String email,
        String imageUrl,
        String employeeCode,
        String phone) {

}
