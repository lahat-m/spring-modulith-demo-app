package com.lahat.springmodulith.domain.dtos;

public record EmployeeRequest(
        String name,
        String email,
        String phoneNumber,
        String address
) {
}
