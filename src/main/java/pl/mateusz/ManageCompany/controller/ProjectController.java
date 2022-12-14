package pl.mateusz.ManageCompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mateusz.ManageCompany.model.Employees.Employee;
import pl.mateusz.ManageCompany.model.Project.CreateProject;
import pl.mateusz.ManageCompany.model.Project.Project;
import pl.mateusz.ManageCompany.repository.EmployeeRepository;
import pl.mateusz.ManageCompany.repository.ProjectRepository;
import pl.mateusz.ManageCompany.service.EmployeeService;
import pl.mateusz.ManageCompany.service.ProjectService;

import java.util.Optional;
import java.util.Set;

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

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

//    @GetMapping("/createProject")
//    public String createProject() {
//        return "myfront/createProject";
//    }

    @PostMapping("/createProject")
    public String createProject(@ModelAttribute(value="createProject") CreateProject createProject) {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user instanceof UserDetails){
            projectService.saveProject(createProject, employeeService.findEmployeeByName(((UserDetails) user).getUsername()));
        }else {

        }

        return "myfront/index2";
    }

    @GetMapping("yourProjects")
    public String yourProjects(Model model) {


        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user instanceof UserDetails) {
            Employee employee = employeeService.findEmployeeByName(((UserDetails) user).getUsername());
            Set<Project> projects = employee.getProjects();

            model.addAttribute("projects", projects);
        }else {}

        return "myfront/yourProjects";
    }

    @GetMapping("/project{id}")
    public String yourProjects(@PathVariable Long id, Model model) {

        model.addAttribute("project", projectService.findProjectById(id));

        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user instanceof UserDetails) {
            Employee employee = employeeService.findEmployeeByName(((UserDetails) user).getUsername());

            if(projectService.findProjectById(id).getProjectOwnerId().equals(employee.getId())) {//jesli jest wlascicielem projektu
                model.addAttribute("employees", projectService.findProjectById(id).getEmployees());

                return "myfront/yourProjectDetails";
            } else {//jesli nie jest

            }
        }else {}

        return "myfront/projectDetails";
    }

    @GetMapping("addEmployee")
    public String addEmployee() {
        return "myfront/addEmployeeToProject";
    }
}
