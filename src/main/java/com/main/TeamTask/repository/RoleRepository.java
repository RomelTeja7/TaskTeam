package com.main.TeamTask.repository;

import com.main.TeamTask.model.RoleBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleBean, Integer>{
    
}
