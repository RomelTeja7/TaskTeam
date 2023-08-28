package com.main.TeamTask.controller;

import com.main.TeamTask.model.EmployeeBean;
import com.main.TeamTask.model.GroupBean;
import com.main.TeamTask.model.JobTypeBean;
import com.main.TeamTask.model.RoleBean;
import com.main.TeamTask.repository.JobTypeRepository;
import com.main.TeamTask.repository.EmployeeRepository;
import com.main.TeamTask.repository.GroupRepository;
import com.main.TeamTask.repository.RoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
public class EmployeeController {

    // Call Repository's
    private EmployeeRepository employeeRepository;
    private JobTypeRepository jobtypeRepository;
    private RoleRepository roleRepository;
    private GroupRepository groupRepository;

    // Repositories declared and indexed
    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository, JobTypeRepository jobtypeRepository, RoleRepository roleRepository, GroupRepository groupRepository) {
        this.employeeRepository = employeeRepository;
        this.roleRepository = roleRepository;
        this.jobtypeRepository = jobtypeRepository;
        this.groupRepository = groupRepository;
    }

    //CRUD SHOW EMPLOYEES - ONLY ADMIN
    @GetMapping("/admin/createEmployee")
    public String showFormCreate(Model model) {
        EmployeeBean employee = new EmployeeBean();
        model.addAttribute("employee", employee);

        List<JobTypeBean> jobList = jobtypeRepository.findAll();
        model.addAttribute("job", jobList);

        List<RoleBean> rolList = roleRepository.findAll();
        model.addAttribute("role", rolList);

        List<GroupBean> groupList = groupRepository.findAll();
        model.addAttribute("group", groupList);

        return "/admin/createEmpl";
    }

    @RequestMapping(value = "/admin/createEmployee", method = RequestMethod.POST)
    public String createEmployee(@ModelAttribute EmployeeBean employee) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encPass = encoder.encode(employee.getPassword());
        employee.setPassword(encPass);
        employeeRepository.save(employee);
        return "redirect:/admin/employees";
    }


    @GetMapping("/admin/employees")
    public String showEmployeeList(Model model) {
        List<EmployeeBean> employeeList = employeeRepository.findAll();
        model.addAttribute("allEmpl", employeeList);
        return "/admin/tableEmpl";
    }

    @GetMapping("/admin/seeUpEmployee/{id}")
    public String seeUpdateDetails(@PathVariable("id") int id, Model model) {

        List<RoleBean> roleList = roleRepository.findAll();
        model.addAttribute("allRoles", roleList);

        List<JobTypeBean> jobList = jobtypeRepository.findAll();
        model.addAttribute("allJobs", jobList);

        List<GroupBean> groupList = groupRepository.findAll();
        model.addAttribute("allGroups", groupList);

        EmployeeBean emp = employeeRepository.findById(id);
        model.addAttribute("employeeUp", emp);

        return "/admin/updateEmpl";
    }
    
    @PostMapping("/admin/updateEmployee")
    public String updateEmployee(@ModelAttribute EmployeeBean employee) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encPass = encoder.encode(employee.getPassword());
        employee.setPassword(encPass);
        employeeRepository.save(employee);
        return "redirect:/admin/employees";
    }
    
    //Method to get data by id on the table employees
    @GetMapping("/admin/seeEmployee/{id}")
    public String seeEmployeeByID(@PathVariable("id") int id, Model model) {
        EmployeeBean emp = employeeRepository.findById(id);
        model.addAttribute("employeeSee", emp);
        return "/admin/seeEmpl";
    }

    @RequestMapping(value = "/admin/delEmployee/{id}", method = RequestMethod.GET)
    public String delEmployeeID(@PathVariable("id") int id) {
        employeeRepository.deleteById(id);
        return "redirect:/admin/employees";
    }

}
