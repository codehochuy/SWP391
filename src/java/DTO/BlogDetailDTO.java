package DTO;

import java.util.ArrayList;
import java.util.List;

public class BlogDetailDTO {

    private int blogDetailID;
    private String title;
    private String content;
    private String BlogID;
    private List<BlogImageDTO> blogImages;

    public BlogDetailDTO() {
    }

    public BlogDetailDTO(int blogDetailID, String title, String content, String BlogID, List<BlogImageDTO> blogImages) {
        this.blogDetailID = blogDetailID;
        this.title = title;
        this.content = content;
        this.BlogID = BlogID;
        this.blogImages = blogImages;
    }

    public int getBlogDetailID() {
        return blogDetailID;
    }

    public void setBlogDetailID(int blogDetailID) {
        this.blogDetailID = blogDetailID;
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

    public String getBlogID() {
        return BlogID;
    }

    public void setBlogID(String BlogID) {
        this.BlogID = BlogID;
    }

    public List<BlogImageDTO> getBlogImages() {
        return blogImages;
    }

    public void setBlogImages(List<BlogImageDTO> blogImages) {
        this.blogImages = blogImages;
    }

    @Override
    public String toString() {
        return "BlogDetailDTO{" + "blogDetailID=" + blogDetailID + ", title=" + title + ", content=" + content + ", BlogID=" + BlogID + ", blogImages=" + blogImages + '}';
    }

    public void addBlogImage(BlogImageDTO blogImage) {
        if (this.blogImages == null) {
            this.blogImages = new ArrayList<>();
        }
        this.blogImages.add(blogImage);
    }
}
