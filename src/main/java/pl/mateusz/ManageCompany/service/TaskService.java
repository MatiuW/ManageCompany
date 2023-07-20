package pl.mateusz.ManageCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.mateusz.ManageCompany.model.Comment.AddCommentToTask;
import pl.mateusz.ManageCompany.model.Comment.Comment;
import pl.mateusz.ManageCompany.model.Comment.CommentEvent;
import pl.mateusz.ManageCompany.model.Employees.Employee;
import pl.mateusz.ManageCompany.model.Project.CreateProject;
import pl.mateusz.ManageCompany.model.Project.Project;
import pl.mateusz.ManageCompany.model.Project.ProjectStatus;
import pl.mateusz.ManageCompany.model.Task.AddTaskToProject;
import pl.mateusz.ManageCompany.model.Task.Task;
import pl.mateusz.ManageCompany.model.Task.TaskStatus;
import pl.mateusz.ManageCompany.repository.CommentRepository;
import pl.mateusz.ManageCompany.repository.EmployeeRepository;
import pl.mateusz.ManageCompany.repository.ProjectRepository;
import pl.mateusz.ManageCompany.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TaskService {

//    @Autowired
//    private TaskRepository taskRepository;
//
//    @Autowired
//    private ProjectRepository projectRepository;
//
//    @Autowired
//    private ProjectService projectService;
//
//    @Autowired
//    private CommentRepository commentRepository;
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    @Autowired
//    private EmployeeRepository employeeRepository;

//    public void saveTask(AddTaskToProject addTaskToProject) {
//        Task task = new Task();
//        task.setTitle(addTaskToProject.getTitle());
//        task.setDescription(addTaskToProject.getDescription());
//        task.setProject(projectService.findProjectById(addTaskToProject.getProjectId()));
//        task.setTaskStatus(TaskStatus.INPROGRESS);
//        task.setOwnerId(addTaskToProject.getOwnerId());
//        if(addTaskToProject.getIsImportance().equals("true")) {
//            task.setImportance(true);
//        }else if(addTaskToProject.getIsImportance().equals("false")) {
//            task.setImportance(false);
//        }
//
//
//        taskRepository.save(task);
//
//        Project project = projectService.findProjectById(addTaskToProject.getProjectId());
//        project.addTask(task);
//        projectRepository.save(project);
//    }

//    public Task findTaskById(Long id) {
//        Optional<Task> optionalTask = taskRepository.findById(id);
//        Task task = null;
//        if(optionalTask.isPresent()) {
//            task = optionalTask.get();
//        } else {
//
//        }
//
//        return task;
//    }

//    public void addCommentToTask(AddCommentToTask addCommentToTask) {
//        Task task = findTaskById(addCommentToTask.getTaskId());
//
//        Comment comment = new Comment();
//        comment.setOwnerId(addCommentToTask.getOwnerId());
//        comment.setContent(addCommentToTask.getContent());
//        comment.setCommentEvent(CommentEvent.SIMPLEMESSAGE);
//        comment.setDate(LocalDateTime.now());
//        commentRepository.save(comment);
//
//        task.addComment(comment);
//        taskRepository.save(task);
//    }

//    public Set<Comment> findAllCommentsInTask(Long taskId) {
//        return findTaskById(taskId).getComments();
//    }

//    public void changeTaskStatus(Long taskId, String taskStatus) {
//        Task task = findTaskById(taskId);
//        if(taskStatus.equals("DONE")) {
//            task.setTaskStatus(TaskStatus.DONE);
//        }
//
//        if(taskStatus.equals("INPROGRESS")) {
//            task.setTaskStatus(TaskStatus.INPROGRESS);
//        }
//
//        if(taskStatus.equals("CANCELLED")) {
//            task.setTaskStatus(TaskStatus.CANCELLED);
//        }
//
//        taskRepository.save(task);
//    }

//    public Set<Employee> findAllEmployeesOutsideProject(Long taskId) {
//        Set<Employee> employeeSet = new HashSet<>();
//
//        Task task = findTaskById(taskId);
//        Project project = projectService.findProjectById(task.getProject().getId());
//
//        return checkEmployeesOutsideTask(task.getEmployees(), project.getEmployees());
//    }

//    public Set<Employee> checkEmployeesOutsideTask(Set<Employee> employeesInsideTask, Set<Employee> employeesInsideProject) {
//        Set<Employee> employeesOutsideProject = new HashSet<>();
//
//        for(Employee allE: employeesInsideProject) {
//            if(!employeesInsideTask.contains(allE)) {
//                employeesOutsideProject.add(allE);
//            }
//        }
//
//        return employeesOutsideProject;
//    }

//    public void addEmployeeToTask(Long employeeId, Long taskId) {
//        Task task = findTaskById(taskId);
//        Employee employee = employeeService.findEmployeeById(employeeId);
//
//        employee.addTask(task);
//        employeeRepository.save(employee);
//
////        taskRepository.findById(taskId, PageRequest.of(1,2))
//    }

//    public Set<Employee> findAllEmployeesInsideProject(Long taskId) {
//        return findTaskById(taskId).getEmployees();
//    }
}
