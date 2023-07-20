package pl.mateusz.ManageCompany.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.mateusz.ManageCompany.exceptions.AppException;
import pl.mateusz.ManageCompany.model.Employees.*;
import pl.mateusz.ManageCompany.model.Project.CreateProject;
import pl.mateusz.ManageCompany.model.Project.Project;
import pl.mateusz.ManageCompany.model.Project.ProjectStatus;
import pl.mateusz.ManageCompany.repository.EmployeeRepository;

import java.nio.CharBuffer;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final PasswordEncoder passwordEncoder;

//    public Employee findEmployeeByName(String name) {
//        return employeeRepository.findByName(name);
//    }
//
//    public Set<Employee> findAllEmployes() {
//        Iterable<Employee> iterable = employeeRepository.findAll();
//
//        Set<Employee> result = new HashSet<>();
//        iterable.forEach(result::add);
//
//        return result;
//    }
//
//    public Employee findEmployeeById(Long id) {
//        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
//        Employee employee = null;
//        if(optionalEmployee.isPresent()) {
//            employee = optionalEmployee.get();
//        } else {
//
//        }
//
//        return employee;
//    }
//
//    public void saveEmployee(Employee employee) {
//        employee.setEmployeeStatus(EmployeeStatus.ACTIVED);
//        employee.setEmployeeRole(EmployeeRole.ROLE_BASIC);
//        employeeRepository.save(employee);
//    }

    //nowe

    public EmployeeDto findByLogin(String login) {
        Employee employee = employeeRepository.findByLogin(login)
                .orElseThrow(() -> new AppException("unknown user", HttpStatus.NOT_FOUND));

        return employeeMapper.toEmployeeDto(employee);
    }

    public EmployeeDto login(CredentialsDto credentialsDto) throws Exception {
        Employee employee = employeeRepository.findByLogin(credentialsDto.getLogin())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if(passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), employee.getPassword())) {
            return employeeMapper.toEmployeeDto(employee);
        }

        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public EmployeeDto register(SignUpDto employeeDto) throws Exception {
        Optional<Employee> optionalEmployee = employeeRepository.findByLogin(employeeDto.getLogin());

        if(optionalEmployee.isPresent()) {
            throw new AppException("login already exists", HttpStatus.BAD_REQUEST);
        }


        Employee employee = employeeMapper.signUpToEmployee(employeeDto);//tutaj
        System.out.println("employee: " + employee);

        employee.setPassword(passwordEncoder.encode(CharBuffer.wrap(employeeDto.getPassword())));

        Employee savedEmployee = employeeRepository.save(employee);



        return employeeMapper.toEmployeeDto(savedEmployee);
    }
}
