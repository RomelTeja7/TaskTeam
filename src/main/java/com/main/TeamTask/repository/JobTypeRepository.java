package com.main.TeamTask.repository;

import com.main.TeamTask.model.JobTypeBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTypeRepository extends JpaRepository<JobTypeBean, Integer>{
    
}
