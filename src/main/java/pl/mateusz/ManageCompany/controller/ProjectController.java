package pl.mateusz.ManageCompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mateusz.ManageCompany.model.Employees.Employee;
import pl.mateusz.ManageCompany.model.Notification.NotificationType;
import pl.mateusz.ManageCompany.model.Project.AddEmployeeToProject;
import pl.mateusz.ManageCompany.model.Project.CreateProject;
import pl.mateusz.ManageCompany.model.Project.Project;
import pl.mateusz.ManageCompany.model.Task.AddTaskToProject;
import pl.mateusz.ManageCompany.model.Task.Task;
import pl.mateusz.ManageCompany.repository.EmployeeRepository;
import pl.mateusz.ManageCompany.repository.ProjectRepository;
import pl.mateusz.ManageCompany.service.EmployeeService;
import pl.mateusz.ManageCompany.service.NotificationService;
import pl.mateusz.ManageCompany.service.ProjectService;
import pl.mateusz.ManageCompany.service.TaskService;

import java.util.Optional;
import java.util.Set;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TaskService taskService;

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/createProject")
    public String createProject(@ModelAttribute(value="createProject") CreateProject createProject) {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user instanceof UserDetails){
            projectService.saveProject(createProject, employeeService.findEmployeeByName(((UserDetails) user).getUsername()));
        }else {

        }

        return "myfront/index2";
    }

    @RequestMapping(value = "/deleteEmployeeFromProject/{employeeId}/{projectId}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteEmployeeFromProject(@PathVariable Long employeeId, @PathVariable Long projectId , Model model) {

        //notyfikacja
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user instanceof UserDetails) {
            Employee employee = employeeService.findEmployeeByName(((UserDetails) user).getUsername());

            notificationService.saveNotification(employeeId, projectId, employee.getId(), NotificationType.DELETE_FROM_PROJECT);
        }

        projectService.deleteEmployeeFromProject(employeeId, projectId);
        model.addAttribute("project", projectService.findProjectById(projectId));
        model.addAttribute("employees", projectService.findProjectById(projectId).getEmployees());

        return "redirect:/project" + projectId;
    }

    @GetMapping("yourProjects")
    public String yourProjects(Model model) {


        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user instanceof UserDetails) {
            Employee employee = employeeService.findEmployeeByName(((UserDetails) user).getUsername());
            Set<Project> projects = employee.getProjects();

            model.addAttribute("projects", projects);

            model.addAttribute("notifications", notificationService.findAllNotifications(employee.getId()));
            if(notificationService.numberOfEmployeeNotifications(employee.getId()) >= 1) {
                model.addAttribute("numberOfNotification", notificationService.numberOfEmployeeNotifications(employee.getId()));
            }else {
                model.addAttribute("numberOfNotification", 0);
            }
        }else {}

        return "myfront/yourProjects";
    }

    @GetMapping("/project{id}")
    public String yourProjects(@PathVariable Long id, Model model) {

        //przekazac dane osoby ktora jest kierownikiem projektu zeby przypoadkiem jej nie usunac

        model.addAttribute("project", projectService.findProjectById(id));
        model.addAttribute("ownerId", projectService.findProjectById(id).getProjectOwnerId());

        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user instanceof UserDetails) {
            Employee employee = employeeService.findEmployeeByName(((UserDetails) user).getUsername());
            model.addAttribute("notifications", notificationService.findAllNotifications(employee.getId()));
            if(notificationService.numberOfEmployeeNotifications(employee.getId()) >= 1) {
                model.addAttribute("numberOfNotification", notificationService.numberOfEmployeeNotifications(employee.getId()));
            }else {
                model.addAttribute("numberOfNotification", 0);
            }

            if(projectService.findProjectById(id).getProjectOwnerId().equals(employee.getId())) {//jesli jest wlascicielem projektu
                model.addAttribute("employees", projectService.findProjectById(id).getEmployees());
                model.addAttribute("tasks", projectService.findProjectById(id).getTasks());
                model.addAttribute("projectCompleteValue", Math.round(projectService.getProjectCompleteValue(id) * 100));
                model.addAttribute("importantTasksCompleteValue", Math.round(projectService.getImportantTasksCompleteValue(id) * 100));
                model.addAttribute("otherTasksCompleteValue", Math.round(projectService.getOtherTasksCompleteValue(id) * 100));

                return "myfront/yourProjectDetails";
            }

            if(projectService.findProjectById(id).getEmployees().contains(employeeService.findEmployeeById(employee.getId()))) {//jesli nie jest wlascicielem ale uczestniczysz
                model.addAttribute("employees", projectService.findProjectById(id).getEmployees());
                model.addAttribute("tasks", projectService.findProjectById(id).getTasks());
                model.addAttribute("projectCompleteValue", Math.round(projectService.getProjectCompleteValue(id) * 100));
                model.addAttribute("importantTasksCompleteValue", Math.round(projectService.getImportantTasksCompleteValue(id) * 100));
                model.addAttribute("otherTasksCompleteValue", Math.round(projectService.getOtherTasksCompleteValue(id) * 100));

                return "myfront/projectDetails";
            }
        }

        return "myfront/yourProjects";//jesli patrzysz projekt w ktorym nie jestes uczestnikiem
    }

    @GetMapping("/addEmployeeToProject{projectId}")
    public String addEmployee(@PathVariable Long projectId, Model model) {

        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user instanceof UserDetails) {
            Employee employee = employeeService.findEmployeeByName(((UserDetails) user).getUsername());
            model.addAttribute("notifications", notificationService.findAllNotifications(employee.getId()));
            if(notificationService.numberOfEmployeeNotifications(employee.getId()) >= 1) {
                model.addAttribute("numberOfNotification", notificationService.numberOfEmployeeNotifications(employee.getId()));
            }else {
                model.addAttribute("numberOfNotification", 0);
            }

            if(projectService.findProjectById(projectId).getProjectOwnerId().equals(employee.getId())) {

                Set<Employee> employeesOutsideProject = projectService.findAllEmployeesInProject(projectId);
                model.addAttribute("projectId", projectId);
                model.addAttribute("employeesOutsideProject", employeesOutsideProject);
                model.addAttribute("projectId", projectId);

                return "myfront/addEmployeeToProject";
            }

            if(projectService.findProjectById(projectId).getEmployees().contains(employeeService.findEmployeeById(employee.getId()))) {//jesli jest uczestnikiem


                model.addAttribute("ownerId", projectService.findProjectById(projectId).getProjectOwnerId());

                model.addAttribute("project", projectService.findProjectById(projectId));
                model.addAttribute("employees", projectService.findProjectById(projectId).getEmployees());
                model.addAttribute("tasks", projectService.findProjectById(projectId).getTasks());
                model.addAttribute("projectCompleteValue", Math.round(projectService.getProjectCompleteValue(projectId) * 100));
                model.addAttribute("importantTasksCompleteValue", Math.round(projectService.getImportantTasksCompleteValue(projectId) * 100));
                model.addAttribute("otherTasksCompleteValue", Math.round(projectService.getOtherTasksCompleteValue(projectId) * 100));

                return "myfront/projectDetails";
            }
        }else {}

        return "myfront/yourProjects";
    }

    @PostMapping("/addEmployeeToProject")
    public String addEmployeeToProject(@ModelAttribute(value = "addEmployeeToProject") AddEmployeeToProject addEmployeeToProject, Model model) {

        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user instanceof UserDetails) {
            Employee employee = employeeService.findEmployeeByName(((UserDetails) user).getUsername());

            notificationService.saveNotification(addEmployeeToProject.getEmployeeId(), addEmployeeToProject.getProjectId(), employee.getId(), NotificationType.ADD_TO_PROJECT);
        }

//        System.out.println(addEmployeeToProject.getEmployeeId() + " " + addEmployeeToProject.getProjectId());
        projectService.addEmployeeToProject(addEmployeeToProject.getEmployeeId(), addEmployeeToProject.getProjectId());

        model.addAttribute("ownerId", projectService.findProjectById(addEmployeeToProject.getProjectId()).getProjectOwnerId());
        model.addAttribute("project", projectService.findProjectById(addEmployeeToProject.getProjectId()));
        model.addAttribute("employees", projectService.findProjectById(addEmployeeToProject.getProjectId()).getEmployees());
        model.addAttribute("tasks", projectService.findProjectById(addEmployeeToProject.getProjectId()).getTasks());

        model.addAttribute("projectCompleteValue", projectService.getProjectCompleteValue(addEmployeeToProject.getProjectId()));
        model.addAttribute("importantTasksCompleteValue", projectService.getImportantTasksCompleteValue(addEmployeeToProject.getProjectId()));
        model.addAttribute("otherTasksCompleteValue", projectService.getOtherTasksCompleteValue(addEmployeeToProject.getProjectId()));

        return "myfront/yourProjectDetails";
    }


}
