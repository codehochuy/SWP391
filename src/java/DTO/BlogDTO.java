package DTO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BlogDTO {

    private int blogID;
    private String title;
    private String content;
    private String tags;
    private Date dateCreate;
    private Date dateModified;
    private User user;
    private BlogCategoryDTO blogCategory;

    public BlogDTO() {
    }

    public BlogDTO(int blogID, String title, String content, String tags, Date dateCreate, Date dateModified, User user, BlogCategoryDTO blogCategory) {
        this.blogID = blogID;
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.dateCreate = dateCreate;
        this.dateModified = dateModified;
        this.user = user;
        this.blogCategory = blogCategory;
    }

    public int getBlogID() {
        return blogID;
    }

    public void setBlogID(int blogID) {
        this.blogID = blogID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BlogCategoryDTO getBlogCategory() {
        return blogCategory;
    }

    public void setBlogCategory(BlogCategoryDTO blogCategory) {
        this.blogCategory = blogCategory;
    }

    @Override
    public String toString() {
        return "BlogDTO{" + "blogID=" + blogID + ", title=" + title + ", content=" + content + ", tags=" + tags + ", dateCreate=" + dateCreate + ", dateModified=" + dateModified + ", user=" + user + ", blogCategory=" + blogCategory + '}';
    }
}
