package pl.mateusz.ManageCompany.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.mateusz.ManageCompany.model.Employees.Employee;
import pl.mateusz.ManageCompany.repository.EmployeeRepository;

import java.util.Optional;

@Service("employeeDetailsService")
public class MyEmployeeDetailsService implements UserDetailsService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<Employee> users = employeeRepository.findByNameTwo(s);
        users.orElseThrow(() -> new UsernameNotFoundException("Not found: " + s));

        return users.map(MyEmployeeDetails::new).get();
    }
}
