package com.main.TeamTask.model;

import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@Table(name = "groupss")
public class GroupBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int group_id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private JobTypeBean job;

    @OneToMany(mappedBy = "group")
    private List<TaskBean> tasks;

    public List<TaskBean> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskBean> tasks) {
        this.tasks = tasks;
    }

    
    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JobTypeBean getJob() {
        return job;
    }

    public void setJob(JobTypeBean job) {
        this.job = job;
    }

}
