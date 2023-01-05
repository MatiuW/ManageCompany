package pl.mateusz.ManageCompany.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.mateusz.ManageCompany.model.Employees.Employee;
import pl.mateusz.ManageCompany.model.Project.Project;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    List<Project> findEmployeeById(Long id);


//    Optional<Project> findById(Long id);
}