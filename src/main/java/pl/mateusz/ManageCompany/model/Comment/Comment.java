package pl.mateusz.ManageCompany.model.Comment;

import jakarta.persistence.*;
import pl.mateusz.ManageCompany.model.Project.Project;
import pl.mateusz.ManageCompany.model.Task.Task;

import java.time.LocalDateTime;
import java.util.Date;

//@Entity
public class Comment {

//    @Id
//    @GeneratedValue(generator = "UUID")
//    private Long id;
//
////    @ManyToOne
////    @JoinColumn(name="task_id", insertable = false, updatable = false)
////    private Task task;
//
//    //employee id
//    private Long ownerId;
//    //content
//    private String content;
//    //date
//    private LocalDateTime date;
//
//    //event - zmiana statusu, jesli zwykly komentarz to jest to nullem
//    @Enumerated(EnumType.STRING)
//    private CommentEvent commentEvent;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
////    public Task getTask() {
////        return task;
////    }
////
////    public void setTask(Task task) {
////        this.task = task;
////    }
//
//    public Long getOwnerId() {
//        return ownerId;
//    }
//
//    public void setOwnerId(Long ownerId) {
//        this.ownerId = ownerId;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
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
//    public CommentEvent getCommentEvent() {
//        return commentEvent;
//    }
//
//    public void setCommentEvent(CommentEvent commentEvent) {
//        this.commentEvent = commentEvent;
//    }
}
