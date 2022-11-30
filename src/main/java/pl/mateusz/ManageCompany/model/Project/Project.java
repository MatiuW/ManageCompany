package pl.mateusz.ManageCompany.model.Project;

import pl.mateusz.ManageCompany.model.Employees.Employee;

import java.util.Date;

public class Project {

    private Long id;
    private String projectTitle;
    private Employee projectOwner;
    private Date projectStartDate;
    private Date projectEndDate;
}
