package pl.mateusz.ManageCompany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.mateusz.ManageCompany.model.Employees.Employee;
import pl.mateusz.ManageCompany.model.Project.AddEmployeeToProject;

@Controller
public class EmployeeController {

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
        System.out.println(employee.getName() + employee.getSurname());
        return "redirect:/login";
    }
}
