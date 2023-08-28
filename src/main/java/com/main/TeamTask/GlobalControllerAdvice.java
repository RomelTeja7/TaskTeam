package com.main.TeamTask;

import com.main.TeamTask.model.EmployeeBean;
import com.main.TeamTask.repository.EmployeeRepository;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    // Call Repository's
    private EmployeeRepository employeeRepository;

    // Repositories declared and indexed
    @Autowired
    public GlobalControllerAdvice(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @ModelAttribute
    public void addCommonAttributes(Model model, Principal principal) {
        if (principal != null) {
            String username = principal.getName();
            EmployeeBean employee = employeeRepository.findByUsername(username);

            if (employee != null) {
                int groupId = employee.getGroup().getGroup_id();
                String roleName = employee.getRole().getName_role();
                String groupName = employee.getGroup().getName();
                String jobType = employee.getJob().getJob_type();

                model.addAttribute("username", username);
                model.addAttribute("groupName", groupName);
                model.addAttribute("groupId", groupId);
                model.addAttribute("roleName", roleName);
                model.addAttribute("jobType", jobType);
            }
        }
    }
}
