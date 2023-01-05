package pl.mateusz.ManageCompany.model.Task;

public class AddTaskToProject {

    private Long ownerId;
    private Long projectId;
    private String title;
    private String description;
    private String isImportance;

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsImportance() {
        return isImportance;
    }

    public void setIsImportance(String isImportance) {
        this.isImportance = isImportance;
    }
}
