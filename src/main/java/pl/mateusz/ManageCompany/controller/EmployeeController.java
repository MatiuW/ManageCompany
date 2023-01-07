package pl.mateusz.ManageCompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.mateusz.ManageCompany.model.Employees.Employee;
import pl.mateusz.ManageCompany.model.Project.AddEmployeeToProject;
import pl.mateusz.ManageCompany.service.EmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/login")
    public String login(){
        return "myfront/login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "myfront/registration";
    }

    @PostMapping("registration")
    public String employeeRegistration(@ModelAttribute(value = "employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/login";
    }
}
