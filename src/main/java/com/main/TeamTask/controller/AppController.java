package com.main.TeamTask.controller;

import com.main.TeamTask.model.EmployeeBean;
import com.main.TeamTask.repository.EmployeeRepository;
import com.main.TeamTask.repository.GroupRepository;
import com.main.TeamTask.repository.JobTypeRepository;
import com.main.TeamTask.repository.RoleRepository;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    // Call Repository's
    private EmployeeRepository employeeRepository;
    private JobTypeRepository jobtypeRepository;
    private RoleRepository roleRepository;
    private GroupRepository groupRepository;

    // Repositories declared and indexed
    @Autowired
    public AppController(EmployeeRepository employeeRepository, JobTypeRepository jobtypeRepository, RoleRepository roleRepository, GroupRepository groupRepository) {
        this.employeeRepository = employeeRepository;
        this.roleRepository = roleRepository;
        this.jobtypeRepository = jobtypeRepository;
        this.groupRepository = groupRepository;
    }

    //Seguriy Patterns
    @GetMapping({"/", "/login"})
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/error404")
    public String ErrorPag() {
        return "404";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }

    @GetMapping("/logout")
    public String logoutPage() {
        return "logout";
    }
}
