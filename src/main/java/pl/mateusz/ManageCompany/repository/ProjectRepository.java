package pl.mateusz.ManageCompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.mateusz.ManageCompany.model.Project.Project;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long>
{

//    List<Project> findEmployeeById(Long id);
//
//    long count();
//
    List<Project> findByprojectOwnerId(Long projectOwnerId);

//    Optional<Project> findById(Long id);
}