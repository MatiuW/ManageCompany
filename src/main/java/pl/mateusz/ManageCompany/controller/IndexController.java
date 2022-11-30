package pl.mateusz.ManageCompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mateusz.ManageCompany.model.Employees.Employee;
import pl.mateusz.ManageCompany.service.EmployeeService;

@Controller
public class IndexController {

    @Autowired
    private EmployeeService employeeService;

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
    public String yourProjects() {
        return "myfront/yourProjects";
    }

    @GetMapping("/checkProjects")
    public String checkProjects() {
        return "myfront/checkProjects";
    }
}
