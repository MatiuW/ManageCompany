package pl.mateusz.ManageCompany.model.Project;

import jakarta.persistence.*;
import pl.mateusz.ManageCompany.model.Employees.Employee;
import pl.mateusz.ManageCompany.model.Task.Task;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Project {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectTitle;
    private String startDate;
    private String endDate;
    @Enumerated(EnumType.STRING)
    private ProjectStatus status;
    private Long projectOwnerId;
    private String tags;
    private String description;
//
    @ManyToMany(mappedBy = "projects", fetch = FetchType.LAZY)
    private Set<Employee> employees = new HashSet<>();

//    @OneToMany
//    @JoinColumn(name = "project_id")
//    private Set<Task> tasks;

//    public Set<Task> getTasks() {
//        return tasks;
//    }
//
//    public void setTasks(Set<Task> tasks) {
//        this.tasks = tasks;
//    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public Long getProjectOwnerId() {
        return projectOwnerId;
    }

    public void setProjectOwnerId(Long projectOwnerId) {
        this.projectOwnerId = projectOwnerId;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

//    public void addTask(Task task) {
//        this.tasks.add(task);
//    }

//    public void addBook(Book book) {
//        this.books.add(book);
//        book.getAuthors().add(this);
//    }
//
//    public void removeBook(Book book) {
//        this.books.remove(book);
//        book.getAuthors().remove(this);
//    }
}
