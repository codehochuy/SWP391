/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Admin
 */
public class BlogCategoryDTO {

    private int blogCategoryID;
    private String blogCategoryName;

    public BlogCategoryDTO() {
    }

    public BlogCategoryDTO(int blogCategoryID, String blogCategoryName) {
        this.blogCategoryID = blogCategoryID;
        this.blogCategoryName = blogCategoryName;
    }

    public int getBlogCategoryID() {
        return blogCategoryID;
    }

    public void setBlogCategoryID(int blogCategoryID) {
        this.blogCategoryID = blogCategoryID;
    }

    public String getBlogCategoryName() {
        return blogCategoryName;
    }

    public void setBlogCategoryName(String blogCategoryName) {
        this.blogCategoryName = blogCategoryName;
    }

    @Override
    public String toString() {
        return "BlogCategoryDTO{" + "blogCategoryID=" + blogCategoryID + ", blogCategoryName=" + blogCategoryName + '}';
    }

}
