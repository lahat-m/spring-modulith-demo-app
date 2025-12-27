package com.lahat.springmodulith.domain;

import com.lahat.springmodulith.domain.dtos.EmployeeRequest;
import com.lahat.springmodulith.domain.dtos.EmployeeResponse;
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
    public EmployeeResponse createEmployee(EmployeeRequest response) {
        EmployeeEntity entity = EmployeeMapper.toEntity(response);
        return EmployeeMapper.toResponse(repository.save(entity));
    }
}
