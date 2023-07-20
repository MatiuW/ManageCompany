package pl.mateusz.ManageCompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.mateusz.ManageCompany.model.Comment.AddCommentToTask;
import pl.mateusz.ManageCompany.model.Notification.FrontDisplayNotification;
import pl.mateusz.ManageCompany.service.NotificationService;



//@Controller
public class NotificationController {

//    @Autowired
//    private NotificationService notificationService;

//    @PostMapping("/notificationChecked")
//    public String notificationChecked(@ModelAttribute(value = "frontDisplayNotification") FrontDisplayNotification frontDisplayNotification) {
//        notificationService.changeNotificationStatus(frontDisplayNotification.getId());
//
//        return "redirect:/index2";
//    }
}
