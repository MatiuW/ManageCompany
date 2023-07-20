package pl.mateusz.ManageCompany.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.mateusz.ManageCompany.model.Comment.Comment;
import pl.mateusz.ManageCompany.model.Employees.Employee;

import java.util.Optional;

public interface CommentRepository //extends CrudRepository<Comment, Long>
{

}