package pl.mateusz.ManageCompany.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.mateusz.ManageCompany.model.Employees.Employee;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query(value = "SELECT * FROM employee WHERE name = :name", nativeQuery = true)
    Optional<Employee> findByNameTwo(String name);

    Employee findByName(String name);

}
