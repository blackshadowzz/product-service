package com.mango.productservice.mappers;

import com.mango.productservice.dto.request.EmployeeRequest;
import com.mango.productservice.dto.response.EmployeeResponse;
import com.mango.productservice.entities.EmployeeEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public EmployeeEntity mapToEmployeeEntity(EmployeeRequest request) {
        return EmployeeEntity.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .gender(request.getGender())
                .phone(request.getPhone())
                .address(request.getAddress())
                .salary(request.getSalary())
                .build();
    }

    public EmployeeResponse mapToEmployeeResponse(EmployeeEntity entity) {
        return EmployeeResponse.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .gender(entity.getGender())
                .phone(entity.getPhone())
                .address(entity.getAddress())
                .salary(entity.getSalary())
                .build();
    }
}
