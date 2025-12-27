package com.lahat.springmodulith.domain;

import com.lahat.springmodulith.domain.dtos.EmployeeResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    List<EmployeeResponse> findAllBy();
}
