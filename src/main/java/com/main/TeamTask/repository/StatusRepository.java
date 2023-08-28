package com.main.TeamTask.repository;

import com.main.TeamTask.model.StatusBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<StatusBean, Integer>{
    
}
