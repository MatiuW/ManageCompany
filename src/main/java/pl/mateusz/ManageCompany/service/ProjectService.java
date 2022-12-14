package pl.mateusz.ManageCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mateusz.ManageCompany.model.Employees.Employee;
import pl.mateusz.ManageCompany.model.Project.CreateProject;
import pl.mateusz.ManageCompany.model.Project.Project;
import pl.mateusz.ManageCompany.model.Project.ProjectStatus;
import pl.mateusz.ManageCompany.repository.EmployeeRepository;
import pl.mateusz.ManageCompany.repository.ProjectRepository;

import javax.persistence.EntityNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class ProjectService {

    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

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
}
