package com.main.TeamTask.repository;

import com.main.TeamTask.model.GroupBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository  extends JpaRepository<GroupBean, Integer>{
    
}
