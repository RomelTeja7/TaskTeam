package com.main.TeamTask.repository;

import com.main.TeamTask.model.TaskBean;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskBean, Integer> {
    public TaskBean findById(int id);
}
