package com.lahat.springmodulith.domain.dtos;


public record EmployeeResponse(
        Long id,
        String name,
        String email,
        String phoneNumber,
        String address
) {
}
