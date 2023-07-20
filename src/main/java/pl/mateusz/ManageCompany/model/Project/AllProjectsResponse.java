package pl.mateusz.ManageCompany.model.Project;

public class AllProjectsResponse {
    private Long id;
    private String projectTitle;
    private String description;
    private String tags;

    public AllProjectsResponse(Long id, String projectTitle, String description, String tags) {
        this.id = id;
        this.projectTitle = projectTitle;
        this.description = description;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
