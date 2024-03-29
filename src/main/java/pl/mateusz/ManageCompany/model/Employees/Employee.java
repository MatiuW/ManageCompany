package pl.mateusz.ManageCompany.model.Employees;

import pl.mateusz.ManageCompany.model.Comment.Comment;
import pl.mateusz.ManageCompany.model.Notification.Notification;
import pl.mateusz.ManageCompany.model.Project.Project;
import pl.mateusz.ManageCompany.model.Task.Task;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(generator = "UUID")
    private Long id;

    private String name;

    private String surname;

    private String password;

    private String country;

    private String address;

    private String phone;

    private String email;

    private String description;

    @Enumerated(EnumType.STRING)
    private EmployeeRole employeeRole;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus employeeStatus;

    @Enumerated(EnumType.STRING)
    private EmployeeJob employeeJob;

    @ManyToMany
    @JoinTable(
            name = "Employee_Task",
            joinColumns = { @JoinColumn(name = "employee_id") },
            inverseJoinColumns = { @JoinColumn(name = "task_id") }
    )
    private Set<Task> tasks = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "Employee_Project",
            joinColumns = { @JoinColumn(name = "employee_id") },
            inverseJoinColumns = { @JoinColumn(name = "project_id") }
    )
    private Set<Project> projects = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "employee_id")
    private Set<Notification> notifications;

    public void addProject(Project project) {
        this.projects.add(project);
    }

    public void deleteProject(Project project) {
        this.projects.remove(project);
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public EmployeeStatus getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(EmployeeStatus employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmployeeRole getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;
    }

    public EmployeeJob getEmployeeJob() {
        return employeeJob;
    }

    public void setEmployeeJob(EmployeeJob employeeJob) {
        this.employeeJob = employeeJob;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNotifications(Set<Notification> notifications) {
        this.notifications = notifications;
    }

    public void addNotification(Notification notification) {
        this.notifications.add(notification);
    }

    public Set<Notification> getNotifications() {
        return notifications;
    }
}
