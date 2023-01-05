package pl.mateusz.ManageCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mateusz.ManageCompany.model.Employees.Employee;
import pl.mateusz.ManageCompany.model.Project.CreateProject;
import pl.mateusz.ManageCompany.model.Project.Project;
import pl.mateusz.ManageCompany.model.Project.ProjectStatus;
import pl.mateusz.ManageCompany.model.Task.AddTaskToProject;
import pl.mateusz.ManageCompany.model.Task.Task;
import pl.mateusz.ManageCompany.model.Task.TaskStatus;
import pl.mateusz.ManageCompany.repository.EmployeeRepository;
import pl.mateusz.ManageCompany.repository.ProjectRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ProjectService {

    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TaskService taskService;

    public void saveProject(CreateProject createProject, Employee employee) {
        Project project = new Project();
        project.setProjectTitle(createProject.getTitle());
        project.setDescription(createProject.getDescription());
        project.setTags(createProject.getTags());
        project.setStartDate(formatter.format(new Date()));
        project.setStatus(ProjectStatus.STARTED);
        project.setEndDate(formatter.format(new Date()));
        project.setProjectOwnerId(employee.getId());
//        project.addEmployee(employee);


        projectRepository.save(project);

        employee.addProject(project);
        employeeRepository.save(employee);
    }

    public Project findProjectById(Long id) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        Project project = null;
        if(optionalProject.isPresent()) {
            project = optionalProject.get();
        } else {

        }

        return project;
    }

    public Set<Employee> findAllEmployeesInProject(Long projectId) {
//        Project project = findProjectById(projectId);
//        Set<Employee> employeesInsideProject = project.getEmployees();
//        for(Employee em: employeesInsideProject) {
//            System.out.println(em.getId());
//        }
        return checkEmployeesOutsideProject(findProjectById(projectId).getEmployees(), employeeService.findAllEmployes());
    }

    public Set<Employee> checkEmployeesOutsideProject(Set<Employee> employeesInsideProject, Set<Employee> allEmployees) {
        Set<Employee> employeesOutsideProject = new HashSet<>();

        for(Employee allE: allEmployees) {
            if(!employeesInsideProject.contains(allE)) {
                employeesOutsideProject.add(allE);
            }
        }

        return employeesOutsideProject;
    }

    public void addEmployeeToProject(Long employeeId, Long projectId) {
        //sprawdzic czy uzytkownik istnieje
        Employee employee = employeeService.findEmployeeById(employeeId);
        Project project = findProjectById(projectId);

        employee.addProject(project);
        employeeRepository.save(employee);
    }

    public void deleteEmployeeFromProject(Long employeeId, Long projectId) {
        Employee employee = employeeService.findEmployeeById(employeeId);
        Project project = findProjectById(projectId);

        employee.deleteProject(project);
        employeeRepository.save(employee);
    }

    //zrobic obliczenia za pomoca streamow
    public double getProjectCompleteValue(Long projectId) {
        Project project = findProjectById(projectId);
        Set<Task> tasks = project.getTasks();

        double numberOfCompleteTasks = 0.0;
        for(Task t: tasks) {
            if(t.getTaskStatus().equals(TaskStatus.DONE)) {
                numberOfCompleteTasks+=1;
            }
        }

        if(tasks.size() != 0.0 ) {
            return numberOfCompleteTasks/tasks.size();
        }

        return 100.0;
    }

    public double getImportantTasksCompleteValue(Long projectId) {
        Project project = findProjectById(projectId);
        Set<Task> tasks = project.getTasks();

        double numberOfCompleteImportantTasks = 0.0;
        double numberOfImportantTasks = 0.0;
        for(Task t: tasks) {
            if(t.getTaskStatus().equals(TaskStatus.DONE) && t.isImportance()) {
                numberOfCompleteImportantTasks+=1;
            }

            if(t.isImportance()) {
                numberOfImportantTasks+=1;
            }
        }

//        System.out.println("getImportantTasksCompleteValue" + " " + numberOfCompleteImportantTasks + " " + numberOfImportantTasks);

        if(numberOfImportantTasks != 0.0) {
            return numberOfCompleteImportantTasks/numberOfImportantTasks;
        }

        return 100.0;
    }

    public double getOtherTasksCompleteValue(Long projectId) {
        Project project = findProjectById(projectId);
        Set<Task> tasks = project.getTasks();

        double numberOfCompleteNotImportantTasks = 0.0;
        double numberOfNotImportantTasks = 0.0;
        for(Task t: tasks) {
            if(t.getTaskStatus().equals(TaskStatus.DONE) && !t.isImportance()) {
                numberOfCompleteNotImportantTasks+=1;
            }

            if(!t.isImportance()) {
                numberOfNotImportantTasks+=1;
            }
        }

//        System.out.println("getOtherTasksCompleteValue" + " " + numberOfCompleteNotImportantTasks + " " + numberOfNotImportantTasks);


        if(numberOfNotImportantTasks != 0.0) {
            return numberOfCompleteNotImportantTasks/numberOfNotImportantTasks;
        }

        return 100.0;
    }

}
