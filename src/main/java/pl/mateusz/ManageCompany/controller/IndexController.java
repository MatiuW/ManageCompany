package pl.mateusz.ManageCompany.controller;

import jdk.jshell.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mateusz.ManageCompany.model.Employees.Employee;
import pl.mateusz.ManageCompany.model.Project.Project;
import pl.mateusz.ManageCompany.repository.EmployeeRepository;
import pl.mateusz.ManageCompany.repository.ProjectRepository;
import pl.mateusz.ManageCompany.service.EmployeeService;
import pl.mateusz.ManageCompany.service.NotificationService;
import pl.mateusz.ManageCompany.service.ProjectService;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@RestController
public class IndexController {

    @GetMapping("/messages")
    public ResponseEntity<List<String>> messages() {
        return ResponseEntity.ok(Arrays.asList("first", "second"));
    }

//    @Autowired
//    private EmployeeService employeeService;
//
//    @Autowired
//    private ProjectRepository projectRepository;
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    @Autowired
//    private ProjectService projectService;
//
//    @Autowired
//    private NotificationService notificationService;

//    @GetMapping("/index2")
//    public String login(Model model) {
//        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if(user instanceof UserDetails){
//            Employee employee = employeeService.findEmployeeByName(((UserDetails) user).getUsername());
//            model.addAttribute("name", employee.getName());
//            model.addAttribute("surname", employee.getSurname());
//            model.addAttribute("fullname", employee.getName() + " " + employee.getSurname());
//
//            model.addAttribute("notifications", notificationService.findAllNotifications(employee.getId()));
//            if(notificationService.numberOfEmployeeNotifications(employee.getId()) >= 1) {
//                model.addAttribute("numberOfNotification", notificationService.numberOfEmployeeNotifications(employee.getId()));
//            }else {
//                model.addAttribute("numberOfNotification", 0);
//            }
//
//        }else {
//            //To-Do
//        }
//
//        return "myfront/index2";
//    }

//    @GetMapping("/_layout")
//    public String widget() {
//        return "_layout";
//    }

//    @GetMapping("/profile")
//    public String userProfile(Model model) {
//        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if(user instanceof UserDetails){
//            Employee employee = employeeService.findEmployeeByName(((UserDetails) user).getUsername());
//            model.addAttribute("name", employee.getName());
//            model.addAttribute("surname", employee.getSurname());
//            model.addAttribute("fullname", employee.getName() + " " + employee.getSurname());
//            model.addAttribute("job", employee.getEmployeeJob().toString());
//            model.addAttribute("country", employee.getCountry());
//            model.addAttribute("address", employee.getAddress());
//            model.addAttribute("phone", employee.getPhone());
//            model.addAttribute("email", employee.getEmail());
//            model.addAttribute("description", employee.getDescription());
//
//            model.addAttribute("notifications", notificationService.findAllNotifications(employee.getId()));
//            if(notificationService.numberOfEmployeeNotifications(employee.getId()) >= 1) {
//                model.addAttribute("numberOfNotification", notificationService.numberOfEmployeeNotifications(employee.getId()));
//            }else {
//                model.addAttribute("numberOfNotification", 0);
//            }
//        }else {
//            //To-Do
//        }
//        return "myfront/profile";
//    }

//    @GetMapping("createProject")
//    public HttpStatus createProject() {
//        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if(user instanceof UserDetails){
//            Employee employee = employeeService.findEmployeeByName(((UserDetails) user).getUsername());
//            model.addAttribute("notifications", notificationService.findAllNotifications(employee.getId()));
//            if(notificationService.numberOfEmployeeNotifications(employee.getId()) >= 1) {
//                model.addAttribute("numberOfNotification", notificationService.numberOfEmployeeNotifications(employee.getId()));
//            }else {
//                model.addAttribute("numberOfNotification", 0);
//            }
//        }

//        return HttpStatus.OK;
//    }


//    @GetMapping("/checkProjects{number}")
//    public String checkProjects(Model model, @RequestParam int number) {//Pageable pageable
//
//        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if(user instanceof UserDetails){
//            Employee employee = employeeService.findEmployeeByName(((UserDetails) user).getUsername());
//            model.addAttribute("notifications", notificationService.findAllNotifications(employee.getId()));
//            if(notificationService.numberOfEmployeeNotifications(employee.getId()) >= 1) {
//                model.addAttribute("numberOfNotification", notificationService.numberOfEmployeeNotifications(employee.getId()));
//            }else {
//                model.addAttribute("numberOfNotification", 0);
//            }
//        }
//
//        //paginacja i sortowanie- mozliwosc wylaczenia przejscia na kolejna karte lub poprzedia
//        //wyroznienie karty ktora zostala wybrana
//
//        System.out.println(number);//pobieram 0 1 2
//
//        if(projectRepository.count() %2==0) {//parzyste
//            if(number > (projectRepository.count()/2)-1) {
//
//                Page<Project> projects = projectRepository.findAll(PageRequest.of((int) ((projectRepository.count()/2) - 1), 2));
//                model.addAttribute("projects", projects);
//
//                model.addAttribute("numberOfPages", (projectRepository.count()/2)-1);
//                model.addAttribute("actualPage", (projectRepository.count()/2) - 1);
//            } else if(number < 0) {
//                Page<Project> projects = projectRepository.findAll(PageRequest.of(0, 2));
//                model.addAttribute("projects", projects);
//
//                model.addAttribute("numberOfPages", (projectRepository.count()/2)-1);
//                model.addAttribute("actualPage", 0);
//            } else {
//                Page<Project> projects = projectRepository.findAll(PageRequest.of(number, 2));
//                model.addAttribute("projects", projects);
//
//                model.addAttribute("numberOfPages", (projectRepository.count()/2)-1);
//                model.addAttribute("actualPage", number);
//            }
//        }
//
//        if(projectRepository.count() %2!=0) {//np
//
//            if(number > ((projectRepository.count()+1)/2)-1) {
//                Page<Project> projects = projectRepository.findAll(PageRequest.of((int) ((projectRepository.count()/2) ), 2));
//                model.addAttribute("projects", projects);
//
//                model.addAttribute("numberOfPages", ((projectRepository.count()+1)/2)-1);
//                model.addAttribute("actualPage", ((projectRepository.count()+1)/2)-1);
//
//            } else if(number < 0) {
//                Page<Project> projects = projectRepository.findAll(PageRequest.of(0, 2));
//                model.addAttribute("projects", projects);
//
//                model.addAttribute("numberOfPages", ((projectRepository.count()+1)/2)-1);
//                model.addAttribute("actualPage", 0);
//            } else {
//                Page<Project> projects = projectRepository.findAll(PageRequest.of(number, 2));
//                model.addAttribute("projects", projects);
//
//                model.addAttribute("numberOfPages", ((projectRepository.count()+1)/2)-1);
//                model.addAttribute("actualPage", number);
//            }
//
//        }
//
//        return "myfront/checkProjects";
//    }
}
