package com.mango.productservice.services.impl;

import com.mango.productservice.dto.request.EmployeeRequest;
import com.mango.productservice.dto.response.EmployeeResponse;
import com.mango.productservice.entities.EmployeeEntity;
import com.mango.productservice.mappers.EmployeeMapper;
import com.mango.productservice.repositories.EmployeeRepository;
import com.mango.productservice.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeImplement implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.getAllEmployees()
                .stream()
                .map(employeeMapper::mapToEmployeeResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponse getEmployeeById(int id) {
        return employeeMapper
                .mapToEmployeeResponse(employeeRepository
                        .getEmployeeById(id));
    }

    @Override
    public EmployeeRequest saveEmployee(EmployeeRequest request) {
        EmployeeEntity entity = employeeMapper.mapToEmployeeEntity(request);
        entity.setId(employeeRepository.getNextId());
        employeeRepository.saveEmployee(entity);
        request.setId(entity.getId());
        return request;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteEmployee(id);
    }

    @Override
    public EmployeeRequest updateEmployee(int id, EmployeeRequest request) {
        EmployeeEntity entity = employeeMapper.mapToEmployeeEntity(request);
        EmployeeEntity updated = employeeRepository.updateEmployee(id, entity);
        request.setId(updated.getId());
        return request;
    }
}
