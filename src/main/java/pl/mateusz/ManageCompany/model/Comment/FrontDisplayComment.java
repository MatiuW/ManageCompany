package pl.mateusz.ManageCompany.model.Comment;

public class FrontDisplayComment {

    private String content;
    private String fullName;
    private String date;

    public FrontDisplayComment(String content, String fullName, String date) {
        this.content = content;
        this.fullName = fullName;
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
