package pl.mateusz.ManageCompany.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import pl.mateusz.ManageCompany.model.Project.Project;
import pl.mateusz.ManageCompany.model.Task.Task;

import java.util.List;

public interface TaskRepository //extends CrudRepository<Task, Long>
{

//    void findById(Long taskId, Pageable pageable);
}