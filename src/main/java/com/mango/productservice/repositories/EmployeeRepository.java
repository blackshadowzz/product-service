package com.mango.productservice.repositories;

import com.mango.productservice.entities.EmployeeEntity;
import com.mango.productservice.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EmployeeRepository {
    private final List<EmployeeEntity> employees = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(3);

    public EmployeeRepository() {
        employees.add(new EmployeeEntity(1, "John", "Doe", "john.doe@example.com", "Male", "555-1001", "123 Main St", 55000.0));
        employees.add(new EmployeeEntity(2, "Jane", "Smith", "jane.smith@example.com", "Female", "555-1002", "456 Oak Ave", 62000.0));
    }

    public int getNextId() {
        return idCounter.getAndIncrement();
    }

    public List<EmployeeEntity> getAllEmployees() {
        return employees;
    }

    public EmployeeEntity getEmployeeById(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + id + " not found"));
    }

    public void saveEmployee(EmployeeEntity employee) {
        employees.add(employee);
    }

    public void deleteEmployee(int id) {
        boolean removed = employees
                .removeIf(employee -> employee.getId() == id);
        if (!removed) {
            throw new EmployeeNotFoundException("Employee with id " + id + " not found");
        }
    }

    public EmployeeEntity updateEmployee(int id, EmployeeEntity employee) {
        EmployeeEntity existing = getEmployeeById(id);
        existing.setFirstName(employee.getFirstName());
        existing.setLastName(employee.getLastName());
        existing.setEmail(employee.getEmail());
        existing.setGender(employee.getGender());
        existing.setPhone(employee.getPhone());
        existing.setAddress(employee.getAddress());
        existing.setSalary(employee.getSalary());
        return existing;
    }
}
