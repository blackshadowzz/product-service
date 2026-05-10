package com.mango.productservice.services;

import com.mango.productservice.dto.request.EmployeeRequest;
import com.mango.productservice.dto.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponse> getAllEmployees();
    EmployeeResponse getEmployeeById(int id);
    EmployeeRequest saveEmployee(EmployeeRequest request);
    void deleteEmployee(int id);
    EmployeeRequest updateEmployee(int id, EmployeeRequest request);
}
