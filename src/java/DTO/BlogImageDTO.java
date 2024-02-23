package DTO;

public class BlogImageDTO {

    private int blogImageID;
    private String url;
    private String caption;
    private String BlogDetailID;

    public BlogImageDTO() {
    }

    public BlogImageDTO(int blogImageID, String url, String caption, String BlogDetailID) {
        this.blogImageID = blogImageID;
        this.url = url;
        this.caption = caption;
        this.BlogDetailID = BlogDetailID;
    }

    public int getBlogImageID() {
        return blogImageID;
    }

    public void setBlogImageID(int blogImageID) {
        this.blogImageID = blogImageID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getBlogDetailID() {
        return BlogDetailID;
    }

    public void setBlogDetailID(String BlogDetailID) {
        this.BlogDetailID = BlogDetailID;
    }

    @Override
    public String toString() {
        return "BlogImageDTO{" + "blogImageID=" + blogImageID + ", url=" + url + ", caption=" + caption + ", BlogDetailID=" + BlogDetailID + '}';
    }

}
