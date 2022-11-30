package pl.mateusz.ManageCompany.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.mateusz.ManageCompany.model.Employees.Employee;
import pl.mateusz.ManageCompany.model.Employees.EmployeeStatus;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class MyEmployeeDetails implements UserDetails {

    private Employee employee;

    public MyEmployeeDetails(Employee employee) {
        this.employee = employee;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(employee.getEmployeeRole().toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return employee.getPassword();
    }

    @Override
    public String getUsername() {
        return employee.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {

        if (employee.getEmployeeStatus().equals(EmployeeStatus.DISABLED)) {
            System.out.println("Konto zamknięte");
            return false;
        } else {
            return true;
        }
    }

    public Employee getUser() {
        return employee;
    }

    @Override
    public String toString() {
        return "CustomUserDetails [worker=" + employee + "]";
    }
}