package pl.mateusz.ManageCompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mateusz.ManageCompany.model.Employees.Employee;
import pl.mateusz.ManageCompany.model.Project.Project;
import pl.mateusz.ManageCompany.repository.EmployeeRepository;
import pl.mateusz.ManageCompany.repository.ProjectRepository;
import pl.mateusz.ManageCompany.service.EmployeeService;

import java.util.List;
import java.util.Set;

@Controller
public class IndexController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/index2")
    public String login(Model model) {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user instanceof UserDetails){
            Employee employee = employeeService.findEmployeeByName(((UserDetails) user).getUsername());
            model.addAttribute("name", employee.getName());
            model.addAttribute("surname", employee.getSurname());
            model.addAttribute("fullname", employee.getName() + " " + employee.getSurname());

        }else {
            //To-Do
        }

        return "myfront/index2";
    }

    @GetMapping("/_layout")
    public String widget() {
        return "_layout";
    }

    @GetMapping("/profile")
    public String userProfile(Model model) {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user instanceof UserDetails){
            Employee employee = employeeService.findEmployeeByName(((UserDetails) user).getUsername());
            model.addAttribute("name", employee.getName());
            model.addAttribute("surname", employee.getSurname());
            model.addAttribute("fullname", employee.getName() + " " + employee.getSurname());
            model.addAttribute("job", employee.getEmployeeJob().toString());
            model.addAttribute("country", employee.getCountry());
            model.addAttribute("address", employee.getAddress());
            model.addAttribute("phone", employee.getPhone());
            model.addAttribute("email", employee.getEmail());
            model.addAttribute("description", employee.getDescription());
        }else {
            //To-Do
        }
        return "myfront/profile";
    }
    @GetMapping("/createProject")
    public String createProject() {
        return "myfront/createProject";
    }

    @GetMapping("/yourProjects")
    public String yourProjects(Model model) {
        System.out.println("tutaj");
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user instanceof UserDetails){
            Employee employee = employeeService.findEmployeeByName(((UserDetails) user).getUsername());
            Set<Project> projects = employee.getProjects();


            for(Project proj: projects) {
                System.out.println("opius projektu: " + proj.getDescription());
            }
        }else {
            //To-Do
        }



        return "myfront/yourProjects";
    }

    @GetMapping("/checkProjects")
    public String checkProjects() {
        return "myfront/checkProjects";
    }
}
