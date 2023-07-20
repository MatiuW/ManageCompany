package pl.mateusz.ManageCompany.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.mateusz.ManageCompany.model.Employees.CredentialsDto;
import pl.mateusz.ManageCompany.model.Employees.Employee;
import pl.mateusz.ManageCompany.model.Employees.EmployeeDto;
import pl.mateusz.ManageCompany.model.Employees.SignUpDto;
import pl.mateusz.ManageCompany.model.Project.AddEmployeeToProject;
import pl.mateusz.ManageCompany.security.EmployeeAuthProvider;
import pl.mateusz.ManageCompany.service.EmployeeService;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

//    @Autowired
//    private EmployeeService employeeService;

//    @PostMapping("/login")
//    public void login(@RequestBody LoginCredentials loginCredentials){
//        System.out.println("username: " + loginCredentials.getUsername());
//        System.out.println("password:" + loginCredentials.getPassword());
//    }

    private final EmployeeService employeeService;
    private final EmployeeAuthProvider employeeAuthProvider;

    @PostMapping("/login")
    public ResponseEntity<EmployeeDto> login(@RequestBody CredentialsDto credentialsDto) throws Exception {
        EmployeeDto employee = employeeService.login(credentialsDto);
        employee.setToken(employeeAuthProvider.createToken(employee.getLogin()));

        return ResponseEntity.ok(employee);
    }

    @PostMapping("/register")
    public ResponseEntity<EmployeeDto> register(@RequestBody SignUpDto signUpDto) throws Exception {
        EmployeeDto employee = employeeService.register(signUpDto);
        employee.setToken(employeeAuthProvider.createToken(employee.getLogin()));

        return ResponseEntity.created(URI.create("/employees/" + employee.getId()))
                .body(employee);
    }


//    @GetMapping("/messages")
//    public ResponseEntity<List<String>> messages() {
//        return ResponseEntity.ok(Arrays.asList("first", "second"));
//    }
//
//    @GetMapping("/registration")
//    public String registration() {
//        return "myfront/registration";
//    }

//    @PostMapping("registration")
//    public String employeeRegistration(@ModelAttribute(value = "employee") Employee employee) {
//        employeeService.saveEmployee(employee);
//        return "redirect:/login";
//    }

    //react

//    @RequestMapping(value = "/login", method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public String login(){
//        return "{xd}";
//    }
//    @ResponseBody
//    @RequestMapping(value = "/login", method = RequestMethod.POST,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public String postLogin(@RequestParam String username, @RequestParam String password) {
//        System.out.println(username + " " + password);
//        return "ok";
//    }
}
