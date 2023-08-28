package com.main.TeamTask.controller;

import com.main.TeamTask.model.EmployeeBean;
import com.main.TeamTask.model.GroupBean;
import com.main.TeamTask.model.StatusBean;
import com.main.TeamTask.model.TaskBean;
import com.main.TeamTask.repository.EmployeeRepository;
import com.main.TeamTask.repository.GroupRepository;
import com.main.TeamTask.repository.StatusRepository;
import com.main.TeamTask.repository.TaskRepository;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {

    // Call Repository's
    private TaskRepository taskRepository;
    private EmployeeRepository employeeRepository;
    private GroupRepository groupRepository;
    private StatusRepository statusRepository;

    // Repositories declared and indexed
    @Autowired
    public TaskController(TaskRepository taskRepository, EmployeeRepository employeeRepository, GroupRepository groupRepository, StatusRepository statusRepository) {
        this.taskRepository = taskRepository;
        this.employeeRepository = employeeRepository;
        this.statusRepository = statusRepository;
        this.groupRepository = groupRepository;
    }

    // IN THESE METHODS DONT RECYCLE METHODS BECAUSE WE USING DIFERENT ROLES, BUT IT IS POSSIBLE TO USE
    // CRUD AdminTask
    // Table Task Admin
    @GetMapping("/admin/adminTasks")
    public String tableTaskAdmin(Model model, TaskBean task) {
        List<TaskBean> taskList = taskRepository.findAll();
        model.addAttribute("allTask", taskList);
        return "/admin/tableTasksAdmin";
    }

    // Create Task Admin
    @GetMapping("/admin/createTaskAdmin")
    public String showTaskCreateAdmin(Model model) {
        TaskBean task = new TaskBean();
        model.addAttribute("task", task);

        List<StatusBean> statusList = statusRepository.findAll();
        model.addAttribute("status", statusList);

        List<EmployeeBean> leaderList = employeeRepository.findAll();
        model.addAttribute("employee", leaderList);

        List<GroupBean> groupList = groupRepository.findAll();
        model.addAttribute("group", groupList);

        return "/admin/createTaskAdmin";
    }

    @RequestMapping(value = "/admin/createTaskAdmin", method = RequestMethod.POST)
    public String createTaskAdmin(TaskBean task) {
        taskRepository.save(task);
        return "redirect:/admin/adminTasks";
    }

    // See Task Admin
    @GetMapping("/admin/seeTaskAdmin/{id}")
    public String seeTaskAdminId(@PathVariable("id") int id, Model model) {
        TaskBean task = taskRepository.findById(id);
        model.addAttribute("taskSee", task);
        return "/admin/seeTaskAdmin";
    }

    // See Update Task Admin
    @GetMapping("/admin/seeUpTaskAdmin/{id}")
    public String seeUpTaskAdmin(@PathVariable("id") int id, Model model) {

        List<StatusBean> statusList = statusRepository.findAll();
        model.addAttribute("status", statusList);

        List<EmployeeBean> leaderList = employeeRepository.findAll();
        model.addAttribute("employee", leaderList);

        List<GroupBean> groupList = groupRepository.findAll();
        model.addAttribute("group", groupList);

        TaskBean task = taskRepository.findById(id);
        model.addAttribute("taskUp", task);

        return "/admin/updateTaskAdmin";
    }

    //Update Task Admin
    @PostMapping("/admin/updateAdminTask")
    public String updateAdminTask(@ModelAttribute TaskBean taskBean) {
        taskRepository.save(taskBean);
        return "redirect:/admin/adminTasks";
    }
    
    // Update Task Status Admin
    @GetMapping("/admin/updateTaskStatusAdmin/{id}")
    public String updateTaskStatusAdmin(@PathVariable int id, @RequestParam int statusId) {
        TaskBean task = taskRepository.findById(id);
        StatusBean newStatus = new StatusBean();
        newStatus.setStatus_id(statusId);
        task.setStatus(newStatus);
        taskRepository.save(task);
        return "redirect:/admin/adminTasks";
    }

    // Delete Task Admin
    @RequestMapping(value = "/admin/delTaskAdmin/{id}", method = RequestMethod.GET)
    public String delTaskAdminId(@PathVariable("id") int id) {
        taskRepository.deleteById(id);
        return "redirect:/admin/adminTasks";
    }

    // CRUD BossTask
    // Table Task Boss
    @GetMapping("/boss/bossTasks")
    public String tableTaskBoss(Model model, TaskBean task, Principal principal) {
        String username = principal.getName();
        EmployeeBean employee = employeeRepository.findByUsername(username);
        List<TaskBean> taskList = employee.getGroup().getTasks();
        model.addAttribute("allTask", taskList);
        return "/boss/tableTasksBoss";
    }

    // Create Task Boss
    @GetMapping("/boss/createTaskBoss")
    public String showTaskCreateBoss(Model model) {
        TaskBean task = new TaskBean();
        model.addAttribute("task", task);

        List<StatusBean> statusList = statusRepository.findAll();
        model.addAttribute("status", statusList);

        List<EmployeeBean> leaderList = employeeRepository.findAll();
        model.addAttribute("employee", leaderList);

        List<GroupBean> groupList = groupRepository.findAll();
        model.addAttribute("group", groupList);

        return "/boss/createTaskBoss";
    }

    @RequestMapping(value = "/boss/createTaskBoss", method = RequestMethod.POST)
    public String createEmployee(TaskBean task) {
        taskRepository.save(task);
        return "redirect:/boss/bossTasks";
    }

    // See Task Boss
    @GetMapping("/boss/seeTaskBoss/{id}")
    public String seeTaskBossId(@PathVariable("id") int id, Model model) {
        TaskBean task = taskRepository.findById(id);
        model.addAttribute("taskSee", task);
        return "/boss/seeTaskBoss";
    }

    // See Update Task Boss
    @GetMapping("/boss/seeUpTaskBoss/{id}")
    public String seeUpTaskBoss(@PathVariable("id") int id, Model model) {

        List<StatusBean> statusList = statusRepository.findAll();
        model.addAttribute("status", statusList);

        List<EmployeeBean> leaderList = employeeRepository.findAll();
        model.addAttribute("employee", leaderList);

        List<GroupBean> groupList = groupRepository.findAll();
        model.addAttribute("group", groupList);

        TaskBean task = taskRepository.findById(id);
        model.addAttribute("taskUp", task);

        return "/boss/updateTaskBoss";
    }

    //Update Task Boss
    @PostMapping("/boss/updateBossTask")
    public String updateBossTask(@ModelAttribute TaskBean taskBean) {
        taskRepository.save(taskBean);
        return "redirect:/boss/bossTasks";
    }
    
    // Update Task Status Boss
    @GetMapping("/boss/updateTaskStatusBoss/{id}")
    public String updateTaskStatusBoss(@PathVariable int id, @RequestParam int statusId) {
        TaskBean task = taskRepository.findById(id);
        StatusBean newStatus = new StatusBean();
        newStatus.setStatus_id(statusId);
        task.setStatus(newStatus);
        taskRepository.save(task);
        return "redirect:/boss/bossTasks";
    }
    
    // Delete Task Boss
    @RequestMapping(value = "/boss/delTaskBoss/{id}", method = RequestMethod.GET)
    public String delTaskBossId(@PathVariable("id") int id) {
        taskRepository.deleteById(id);
        return "redirect:/boss/bossTasks";
    }
    

    // CRUD EmployeeTask
    // Table Task Employee
    @GetMapping("/employee/employeeTasks")
    public String tableTaskEmployee(Model model, TaskBean task, Principal principal) {
        String username = principal.getName();
        EmployeeBean employee = employeeRepository.findByUsername(username);
        List<TaskBean> taskList = employee.getGroup().getTasks();
        model.addAttribute("allTask", taskList);
        return "/employee/tableTasksEmployee";
    }

    // See Task Employee
    @GetMapping("/employee/seeTaskEmployee/{id}")
    public String seeTaskEmployeeId(@PathVariable("id") int id, Model model) {
        TaskBean task = taskRepository.findById(id);
        model.addAttribute("taskSee", task);
        return "/employee/seeTaskEmployee";
    }
    
    // Update Task Status Employee
    @GetMapping("/employee/updateTaskStatusEmployee/{id}")
    public String updateTaskStatusEmployee(@PathVariable int id, @RequestParam int statusId) {
        TaskBean task = taskRepository.findById(id);
        StatusBean newStatus = new StatusBean();
        newStatus.setStatus_id(statusId);
        task.setStatus(newStatus);
        taskRepository.save(task);
        return "redirect:/employee/employeeTasks";
    }
}
