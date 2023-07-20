package pl.mateusz.ManageCompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mateusz.ManageCompany.dateFormatter.DateFormat;
import pl.mateusz.ManageCompany.model.Comment.Comment;
import pl.mateusz.ManageCompany.model.Comment.FrontDisplayComment;
import pl.mateusz.ManageCompany.model.Employees.Employee;
import pl.mateusz.ManageCompany.model.Task.AddTaskToProject;
import pl.mateusz.ManageCompany.model.Comment.AddCommentToTask;
import pl.mateusz.ManageCompany.repository.EmployeeRepository;
import pl.mateusz.ManageCompany.repository.ProjectRepository;
import pl.mateusz.ManageCompany.service.EmployeeService;
import pl.mateusz.ManageCompany.service.NotificationService;
import pl.mateusz.ManageCompany.service.ProjectService;
import pl.mateusz.ManageCompany.service.TaskService;

import java.util.*;

//@Controller
public class TaskController {

//    @Autowired
//    private ProjectService projectService;
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    @Autowired
//    private ProjectRepository projectRepository;
//
//    @Autowired
//    private TaskService taskService;
//
//    @Autowired
//    private NotificationService notificationService;

//    @GetMapping("/addTaskToProject{projectId}")
//    public String addTask(@PathVariable Long projectId, Model model) {
//        model.addAttribute("projectId", projectId);
//
//        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if(user instanceof UserDetails) {
//            Employee employee = employeeService.findEmployeeByName(((UserDetails) user).getUsername());
//            model.addAttribute("notifications", notificationService.findAllNotifications(employee.getId()));
//            if(notificationService.numberOfEmployeeNotifications(employee.getId()) >= 1) {
//                model.addAttribute("numberOfNotification", notificationService.numberOfEmployeeNotifications(employee.getId()));
//            }else {
//                model.addAttribute("numberOfNotification", 0);
//            }
//
//            if(projectService.findProjectById(projectId).getProjectOwnerId().equals(employee.getId())) {
//
//                model.addAttribute("ownerId", employee.getId());
//
//                return "myfront/addTaskToProject";
//            }
//
//            if(projectService.findProjectById(projectId).getEmployees().contains(employeeService.findEmployeeById(employee.getId()))) {//jesli nie jest wlascicielem ale uczestniczysz
//
//                model.addAttribute("ownerId", projectService.findProjectById(projectId).getProjectOwnerId());
//
//                model.addAttribute("project", projectService.findProjectById(projectId));
//                model.addAttribute("employees", projectService.findProjectById(projectId).getEmployees());
//                model.addAttribute("tasks", projectService.findProjectById(projectId).getTasks());
//                model.addAttribute("projectCompleteValue", Math.round(projectService.getProjectCompleteValue(projectId) * 100));
//                model.addAttribute("importantTasksCompleteValue", Math.round(projectService.getImportantTasksCompleteValue(projectId) * 100));
//                model.addAttribute("otherTasksCompleteValue", Math.round(projectService.getOtherTasksCompleteValue(projectId) * 100));
//
//                return "myfront/projectDetails";
//            }
//
//
//
//        }else {}
//
////        Set<Employee> employeesOutsideProject = projectService.findAllEmployeesInProject(projectId);
////        model.addAttribute("employeesOutsideProject", employeesOutsideProject);
////        model.addAttribute("projectId", projectId);
//
//        return "myfront/yourProjects";
////        return "myfront/addTaskToProject";
//    }

//    @PostMapping("/addTaskToProject")
//    public String addTaskToProject(@ModelAttribute(value = "addTaskToProject") AddTaskToProject addTaskToProject, Model model) {
//
//
//        taskService.saveTask(addTaskToProject);
//
//        model.addAttribute("ownerId", projectService.findProjectById(addTaskToProject.getProjectId()).getProjectOwnerId());
//
//        model.addAttribute("project", projectService.findProjectById(addTaskToProject.getProjectId()));
//        model.addAttribute("employees", projectService.findProjectById(addTaskToProject.getProjectId()).getEmployees());
//        model.addAttribute("tasks", projectService.findProjectById(addTaskToProject.getProjectId()).getTasks());
//
//        model.addAttribute("projectCompleteValue", projectService.getProjectCompleteValue(addTaskToProject.getProjectId()));
//        model.addAttribute("importantTasksCompleteValue", projectService.getImportantTasksCompleteValue(addTaskToProject.getProjectId()));
//        model.addAttribute("otherTasksCompleteValue", projectService.getOtherTasksCompleteValue(addTaskToProject.getProjectId()));
//
//        return "myfront/yourProjectDetails";
//    }

    //tutaj poprawic
//    @GetMapping("/task{taskId}")
//    public String checkTaskDetails(@PathVariable Long taskId, Model model) {
//
//        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if(user instanceof UserDetails) {
//            Employee employee = employeeService.findEmployeeByName(((UserDetails) user).getUsername());
//            model.addAttribute("notifications", notificationService.findAllNotifications(employee.getId()));
//            if(notificationService.numberOfEmployeeNotifications(employee.getId()) >= 1) {
//                model.addAttribute("numberOfNotification", notificationService.numberOfEmployeeNotifications(employee.getId()));
//            }else {
//                model.addAttribute("numberOfNotification", 0);
//            }
//
//            if(projectService.findProjectById(taskService.findTaskById(taskId).getProject().getId()).getEmployees().contains(employeeService.findEmployeeById(employee.getId()))) {//jesli nie jest wlascicielem ale uczestniczysz
//
//                model.addAttribute("task", taskService.findTaskById(taskId));
//
//                ArrayList<FrontDisplayComment> frontDisplayComment = new ArrayList<>();
//                Set<Comment> comments = taskService.findAllCommentsInTask(taskId);
//                for(Comment c: comments) {
//                    frontDisplayComment.add(new FrontDisplayComment(c.getContent(),
//                            employeeService.findEmployeeById(c.getOwnerId()).getName() + " " +
//                                    employeeService.findEmployeeById(c.getOwnerId()).getSurname(),
//                            new DateFormat().formatDate(c.getDate())));
//                }
//                frontDisplayComment.sort(Comparator.comparing(FrontDisplayComment::getDate));
//
//                model.addAttribute("frontDisplayComments", frontDisplayComment);
//                model.addAttribute("employeesOutsideTask", taskService.findAllEmployeesOutsideProject(taskId));
//                model.addAttribute("employeesInsideTask", taskService.findAllEmployeesInsideProject(taskId));
//
//                return "myfront/yourTaskDetails";
//            }
//        }
//
//        return "myfront/yourProjects";
//    }

//    @PostMapping("/addCommentToTask")
//    public String addCommentToTask(@ModelAttribute(value = "addCommentToTask")AddCommentToTask addCommentToTask, Model model) {
//
//        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if(user instanceof UserDetails) {
//            Employee employee = employeeService.findEmployeeByName(((UserDetails) user).getUsername());
//
//            addCommentToTask.setOwnerId(employee.getId());
//
//        }else {}
//
//        taskService.addCommentToTask(addCommentToTask);
//
//        return "redirect:/task" + addCommentToTask.getTaskId();
//    }

//    @PostMapping("/addEmployeeToTask")
//    public String addEmployeeToTask(@RequestParam("taskId") Long taskId, @RequestParam("employeeId") Long employeeId, Model model) {
//
//
////        System.out.println("add: " + taskId + " " + employeeId);
//        taskService.addEmployeeToTask(employeeId, taskId);
//
//        return "redirect:/task" + taskId;
//    }

//    @PostMapping("/getTaskEmployees")
//    public String getTaskEmployees() {
//        return "";
//    }

//    @PostMapping("/changeTaskStatus")
//    public String changeTaskStatus(@RequestParam("taskId") Long taskId, @RequestParam("taskStatus") String taskStatus) {
////        System.out.println("taskId: " + taskId + " isImportance: " + isImportance);
//        taskService.changeTaskStatus(taskId, taskStatus);
//        return "redirect:/task" + taskId;
//    }
}
