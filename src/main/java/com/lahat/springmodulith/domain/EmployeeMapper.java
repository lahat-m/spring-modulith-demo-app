package com.lahat.springmodulith.domain;

import com.lahat.springmodulith.domain.dtos.EmployeeRequest;
import com.lahat.springmodulith.domain.dtos.EmployeeResponse;

class EmployeeMapper {

    private EmployeeMapper() {}

    static EmployeeEntity toEntity(EmployeeRequest dto) {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setName(dto.name());
        entity.setEmail(dto.email());
        entity.setPhoneNumber(dto.phoneNumber());
        entity.setAddress(dto.address());
        return entity;
    }


    static EmployeeResponse toResponse(EmployeeEntity entity) {
        return new EmployeeResponse(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPhoneNumber(),
                entity.getAddress()
        );
    }
}
