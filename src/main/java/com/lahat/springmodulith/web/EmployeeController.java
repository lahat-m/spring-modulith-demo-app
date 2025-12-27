package com.lahat.springmodulith.web;

import com.lahat.springmodulith.domain.EmployeeService;
import com.lahat.springmodulith.domain.dtos.EmployeeRequest;
import com.lahat.springmodulith.domain.dtos.EmployeeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
class EmployeeController {

    private final EmployeeService service;

    EmployeeController(EmployeeService service) {
        this.service = service;
    }

    //create API endpoint to retrieve employee list
    @GetMapping
    List<EmployeeResponse> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    Optional<EmployeeResponse> getEmployeeById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest request) {
        EmployeeResponse response = service.createEmployee(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequest request) {
        return service.updateEmployee(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
