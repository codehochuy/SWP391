package DTO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BlogDTO {

    private int blogID;
    private String title;
    private Date date;
    private int usersID;
    private List<BlogDetailDTO> blogDetails;

    public BlogDTO(int blogID, String title, Date date, int usersID, List<BlogDetailDTO> blogDetails) {
        this.blogID = blogID;
        this.title = title;
        this.date = date;
        this.usersID = usersID;
        this.blogDetails = blogDetails;
    }

    public BlogDTO() {
        blogDetails = new ArrayList<>();
    }

    // Getters and Setters
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUsersID() {
        return usersID;
    }

    public void setUsersID(int usersID) {
        this.usersID = usersID;
    }

    public List<BlogDetailDTO> getBlogDetails() {
        return blogDetails;
    }

    public void setBlogDetails(List<BlogDetailDTO> blogDetails) {
        this.blogDetails = blogDetails;
    }

    public void addBlogDetail(BlogDetailDTO blogDetail) {
        this.blogDetails.add(blogDetail);
    }

    @Override
    public String toString() {
        return "BlogDTO{" + "blogID=" + blogID + ", title=" + title + ", date=" + date + ", usersID=" + usersID + ", blogDetails=" + blogDetails + '}';
    }

}
