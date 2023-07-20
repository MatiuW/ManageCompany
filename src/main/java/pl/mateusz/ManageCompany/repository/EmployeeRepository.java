package pl.mateusz.ManageCompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.mateusz.ManageCompany.model.Employees.Employee;
import pl.mateusz.ManageCompany.model.Project.Project;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    @Query(value = "SELECT * FROM employee WHERE name = :name", nativeQuery = true)
//    Optional<Employee> findByNameTwo(String name);

    Optional<Employee> findByLogin(String login);


}
