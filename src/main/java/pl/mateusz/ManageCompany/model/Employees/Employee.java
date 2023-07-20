package pl.mateusz.ManageCompany.model.Employees;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Primary;
import pl.mateusz.ManageCompany.model.Comment.Comment;
import pl.mateusz.ManageCompany.model.Notification.Notification;
import pl.mateusz.ManageCompany.model.Project.Project;
import pl.mateusz.ManageCompany.model.Task.Task;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "app_user")
public class Employee {

//    @Id
//    @SequenceGenerator(name = "employee_generator", sequenceName = "employee_seq", allocationSize = 1)
//    private Long id;
//
//    private String name;
//
//    private String surname;
//
//    private String password;
//
//    private String country;
//
//    private String address;
//
//    private String phone;
//
//    private String email;
//
//    private String description;
//
//    @Enumerated(EnumType.STRING)
//    private EmployeeRole employeeRole;
//
//    @Enumerated(EnumType.STRING)
//    private EmployeeStatus employeeStatus;
//
//    @Enumerated(EnumType.STRING)
//    private EmployeeJob employeeJob;
//
////    @ManyToMany
////    @JoinTable(
////            name = "Employee_Task",
////            joinColumns = { @JoinColumn(name = "employee_id") },
////            inverseJoinColumns = { @JoinColumn(name = "task_id") }
////    )
////    private Set<Task> tasks = new HashSet<>();
//
    @ManyToMany
    @JoinTable(
            name = "Employee_Project",
            joinColumns = { @JoinColumn(name = "employee_id") },
            inverseJoinColumns = { @JoinColumn(name = "project_id") }
    )
    private Set<Project> projects = new HashSet<>();
//
////    @OneToMany
////    @JoinColumn(name = "employee_id")
////    private Set<Notification> notifications;
//
    public void addProject(Project project) {
        this.projects.add(project);
    }

    public void deleteProject(Project project) {
        this.projects.remove(project);
    }
//
////    public void addTask(Task task) {
////        this.tasks.add(task);
////    }
//
    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
//
//    public EmployeeStatus getEmployeeStatus() {
//        return employeeStatus;
//    }
//
//    public void setEmployeeStatus(EmployeeStatus employeeStatus) {
//        this.employeeStatus = employeeStatus;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public EmployeeRole getEmployeeRole() {
//        return employeeRole;
//    }
//
//    public void setEmployeeRole(EmployeeRole employeeRole) {
//        this.employeeRole = employeeRole;
//    }
//
//    public EmployeeJob getEmployeeJob() {
//        return employeeJob;
//    }
//
//    public void setEmployeeJob(EmployeeJob employeeJob) {
//        this.employeeJob = employeeJob;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }

//    public void setNotifications(Set<Notification> notifications) {
//        this.notifications = notifications;
//    }
//
//    public void addNotification(Notification notification) {
//        this.notifications.add(notification);
//    }
//
//    public Set<Notification> getNotifications() {
//        return notifications;
//    }

    //nowe

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;

    public Employee() {

    }

    public Employee(long id, String firstName, String lastName, String login, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
