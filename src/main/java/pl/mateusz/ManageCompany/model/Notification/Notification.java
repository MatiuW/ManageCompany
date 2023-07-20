package pl.mateusz.ManageCompany.model.Notification;

import jakarta.persistence.*;
import pl.mateusz.ManageCompany.model.Employees.Employee;
import pl.mateusz.ManageCompany.model.Task.Task;
import pl.mateusz.ManageCompany.service.NotificationService;

import java.time.LocalDateTime;

//@Entity
public class Notification {

//    @Id
//    @GeneratedValue(generator = "UUID")
//    private Long id;
//
//    private LocalDateTime date;
//
//    @Enumerated(EnumType.STRING)
//    private NotificationType notificationType;
//
//    @Enumerated(EnumType.STRING)
//    private NotificationStatus notificationStatus;
//
//    private String title;
//    private String description;
//
//    @ManyToOne
//    @JoinColumn(name="employee_id", insertable = false, updatable = false)
//    private Employee employee;
//
//    public Notification() {
//
//    }
//
//    public Notification(Long id, LocalDateTime date, NotificationType notificationType, NotificationStatus notificationStatus, String title, String description, Employee employee) {
//        this.id = id;
//        this.date = date;
//        this.notificationType = notificationType;
//        this.notificationStatus = notificationStatus;
//        this.title = title;
//        this.description = description;
//        this.employee = employee;
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
//    public LocalDateTime getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDateTime date) {
//        this.date = date;
//    }
//
//    public NotificationType getNotificationType() {
//        return notificationType;
//    }
//
//    public void setNotificationType(NotificationType notificationType) {
//        this.notificationType = notificationType;
//    }
//
//    public NotificationStatus getNotificationStatus() {
//        return notificationStatus;
//    }
//
//    public void setNotificationStatus(NotificationStatus notificationStatus) {
//        this.notificationStatus = notificationStatus;
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
//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
}
