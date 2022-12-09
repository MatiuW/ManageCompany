package pl.mateusz.ManageCompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.mateusz.ManageCompany.model.Employees.Employee;
import pl.mateusz.ManageCompany.model.Project.CreateProject;
import pl.mateusz.ManageCompany.service.EmployeeService;
import pl.mateusz.ManageCompany.service.ProjectService;

@Controller
public class ProjectController {

//    @PostMapping("/createProject")
//    public String createProject(@ModelAttribute String projectTitle) {
//        System.out.println("Stworzono projekt o nazwie: " + projectTitle);
//        return "myfront/index2";
//    }
    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/createProject", method = RequestMethod.POST)
    public String createProject(@ModelAttribute(value="createProject") CreateProject createProject) {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user instanceof UserDetails){
            projectService.saveProject(createProject, employeeService.findEmployeeByName(((UserDetails) user).getUsername()));
        }else {

        }

        return "myfront/index2";
    }
}
