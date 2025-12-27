package com.lahat.springmodulith.domain;

import com.lahat.springmodulith.domain.dtos.EmployeeRequest;
import com.lahat.springmodulith.domain.dtos.EmployeeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<EmployeeResponse> getAllEmployees() {
        return repository.findAllBy();
    }

    public Optional<EmployeeResponse> getEmployeeById(Long id) {
        return repository.findById(id)
                .map(EmployeeMapper::toResponse);
    }
    public EmployeeResponse createEmployee(EmployeeRequest request) {
        EmployeeEntity entity = EmployeeMapper.toEntity(request);
        return EmployeeMapper.toResponse(repository.save(entity));
    }


    public Optional<EmployeeResponse> updateEmployee(Long id, EmployeeRequest request) {
        return repository.findById(id)
                .map(employee -> {
                    employee.setName(request.name());
                    employee.setEmail(request.email());
                    employee.setPhoneNumber(request.phoneNumber());
                    employee.setAddress(request.address());
                    EmployeeEntity savedEmployee = repository.save(employee);
                    return EmployeeMapper.toResponse(savedEmployee);
                });
    }
}
