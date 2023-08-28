package com.main.TeamTask.repository;

import com.main.TeamTask.model.EmployeeBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeBean, Integer> {

    public EmployeeBean findById(int employee_id);

    public EmployeeBean findByUsername(String username);

}