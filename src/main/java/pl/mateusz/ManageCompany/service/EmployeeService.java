package pl.mateusz.ManageCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mateusz.ManageCompany.model.Employees.Employee;
import pl.mateusz.ManageCompany.model.Employees.EmployeeRole;
import pl.mateusz.ManageCompany.model.Employees.EmployeeStatus;
import pl.mateusz.ManageCompany.model.Project.CreateProject;
import pl.mateusz.ManageCompany.model.Project.Project;
import pl.mateusz.ManageCompany.model.Project.ProjectStatus;
import pl.mateusz.ManageCompany.repository.EmployeeRepository;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee findEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }

    public Set<Employee> findAllEmployes() {
        Iterable<Employee> iterable = employeeRepository.findAll();

        Set<Employee> result = new HashSet<>();
        iterable.forEach(result::add);

        return result;
    }

    public Employee findEmployeeById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        Employee employee = null;
        if(optionalEmployee.isPresent()) {
            employee = optionalEmployee.get();
        } else {

        }

        return employee;
    }

    public void saveEmployee(Employee employee) {
        employee.setEmployeeStatus(EmployeeStatus.ACTIVED);
        employee.setEmployeeRole(EmployeeRole.ROLE_BASIC);
        employeeRepository.save(employee);
    }
}
