package pl.mateusz.ManageCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mateusz.ManageCompany.dateFormatter.DateFormat;
import pl.mateusz.ManageCompany.model.Comment.Comment;
import pl.mateusz.ManageCompany.model.Comment.CommentEvent;
import pl.mateusz.ManageCompany.model.Comment.FrontDisplayComment;
import pl.mateusz.ManageCompany.model.Employees.Employee;
import pl.mateusz.ManageCompany.model.Notification.FrontDisplayNotification;
import pl.mateusz.ManageCompany.model.Notification.Notification;
import pl.mateusz.ManageCompany.model.Notification.NotificationStatus;
import pl.mateusz.ManageCompany.model.Notification.NotificationType;
import pl.mateusz.ManageCompany.model.Project.Project;
import pl.mateusz.ManageCompany.model.Project.ProjectStatus;
import pl.mateusz.ManageCompany.model.Task.Task;
import pl.mateusz.ManageCompany.repository.EmployeeRepository;
import pl.mateusz.ManageCompany.repository.NotificationRepository;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

//@Service
public class NotificationService {

//    @Autowired
//    private NotificationRepository notificationRepository;

//    @Autowired
//    private EmployeeService employeeService;
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    @Autowired
//    private ProjectService projectService;
//
//    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

//    public void saveNotification(long employeeId, long destinationId, long employeeWhoStartEvent, NotificationType notificationType) {
//        Employee employee = employeeService.findEmployeeById(employeeId);
//
//        Notification notification = new Notification();
//        notification.setNotificationType(notificationType);
//        notification.setDate(LocalDateTime.now());
//        notification.setNotificationStatus(NotificationStatus.NEW);
//
//        if(notificationType.equals(NotificationType.ADD_TO_PROJECT)) {
//            notification.setTitle("Dodanie użytkownika do projektu");
//
//            notification.setDescription("Użytkownik " +
//                    employeeService.findEmployeeById(employeeWhoStartEvent).getName() + " " +
//                    employeeService.findEmployeeById(employeeWhoStartEvent).getSurname() +
//                    " dodał Cie to projektu o nazwie " + projectService.findProjectById(destinationId).getProjectTitle());
//        }
//
//        if(notificationType.equals(NotificationType.DELETE_FROM_PROJECT)) {
//            notification.setTitle("Usunięcie użytkownika z projektu");
//
//            notification.setDescription("Użytkownik " +
//                    employeeService.findEmployeeById(employeeWhoStartEvent).getName() + " " +
//                    employeeService.findEmployeeById(employeeWhoStartEvent).getSurname() +
//                    " usunął Cie z projektu o nazwie " + projectService.findProjectById(destinationId).getProjectTitle());
//        }
//
//        notificationRepository.save(notification);
//
//        employee.addNotification(notification);
//        employeeRepository.save(employee);
//    }

//    public Notification findNotificationById(Long id) {
//        Optional<Notification> optionalNotification = notificationRepository.findById(id);
//        Notification notification = null;
//        if(optionalNotification.isPresent()) {
//            notification = optionalNotification.get();
//        } else {
//
//        }
//
//        return notification;
//    }

//    public ArrayList<FrontDisplayNotification> findAllNotifications(long employeeId) {
//        ArrayList<FrontDisplayNotification> frontDisplayNotifications = new ArrayList<>();
//
//        for(Notification n: employeeService.findEmployeeById(employeeId).getNotifications()) {
//            if(n.getNotificationStatus().equals(NotificationStatus.NEW)) {
//                frontDisplayNotifications.add(new FrontDisplayNotification(n.getId(), new DateFormat().formatDate(n.getDate()),
//                        n.getTitle(), n.getDescription()));
//            }
//        }
//
//        frontDisplayNotifications.sort(Comparator.comparing(FrontDisplayNotification::getDate).reversed());
//        if(frontDisplayNotifications.size() > 5) {
//            frontDisplayNotifications.subList(5, frontDisplayNotifications.size()).clear();
//        }
//
//        return frontDisplayNotifications;
//    }

//    public int numberOfEmployeeNotifications(long employeeId) {
//        Set<Notification> notificationSet = employeeService.findEmployeeById(employeeId).getNotifications();
//        int i = 0;
//        for(Notification n: notificationSet) {
//            if(n.getNotificationStatus().equals(NotificationStatus.NEW)) {
//                i++;
//            }
//        }
//
//        return i;
//    }

//    public void changeNotificationStatus(long notificationId) {
//        Notification notification = findNotificationById(notificationId);
//        notification.setNotificationStatus(NotificationStatus.CHECKED);
//
//        notificationRepository.save(notification);
//    }
}
