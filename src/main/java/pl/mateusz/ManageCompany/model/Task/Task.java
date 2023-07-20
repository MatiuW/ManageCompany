package pl.mateusz.ManageCompany.model.Task;

import jakarta.persistence.*;
import pl.mateusz.ManageCompany.model.Comment.Comment;
import pl.mateusz.ManageCompany.model.Employees.Employee;
import pl.mateusz.ManageCompany.model.Project.Project;

import java.util.HashSet;
import java.util.Set;

//@Entity
public class Task {

//    @Id
//    @GeneratedValue(generator = "UUID")
//    private Long id;
//
//    @ManyToMany(mappedBy = "tasks", fetch = FetchType.LAZY)
//    private Set<Employee> employees = new HashSet<>();
//
//    //it's a good practice to mark the many-to-one side as the owning side.
//    @ManyToOne
//    @JoinColumn(name="project_id", insertable = false, updatable = false)
//    private Project project;
//
//    @OneToMany
//    @JoinColumn(name = "task_id")
//    private Set<Comment> comments;
//
//    private Long ownerId;
//    @Enumerated(EnumType.STRING)
//    private TaskStatus taskStatus;
//    private String title;
//    private String description;
//
//    @Column(nullable=false, columnDefinition = "BOOLEAN DEFAULT FALSE")
//    private boolean isImportance;
//
//    public boolean isImportance() {
//        return isImportance;
//    }
//
//    public void setImportance(boolean importance) {
//        isImportance = importance;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
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
//    public Project getProject() {
//        return project;
//    }
//
//    public void setProject(Project project) {
//        this.project = project;
//    }
//
//    public Long getOwnerId() {
//        return ownerId;
//    }
//
//    public void setOwnerId(Long ownerId) {
//        this.ownerId = ownerId;
//    }
//
//    public Set<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(Set<Employee> employees) {
//        this.employees = employees;
//    }
//
//    public TaskStatus getTaskStatus() {
//        return taskStatus;
//    }
//
//    public void setTaskStatus(TaskStatus taskStatus) {
//        this.taskStatus = taskStatus;
//    }
//
//    public Set<Comment> getComments() {
//        return comments;
//    }
//
//    public void setComments(Set<Comment> comments) {
//        this.comments = comments;
//    }
//
//    public void addComment(Comment comment) {
//        this.comments.add(comment);
//    }
}
