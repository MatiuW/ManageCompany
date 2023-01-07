package pl.mateusz.ManageCompany.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.mateusz.ManageCompany.model.Project.Project;

import java.util.List;

public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {

    List<Project> findEmployeeById(Long id);

    long count();

//    Optional<Project> findById(Long id);
}