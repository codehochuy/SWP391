/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author ACER
 */
public class ProjectImage {
    private int id;
    private String link;
    private String caption;
    private int projectid;

    public ProjectImage() {
    }

    public ProjectImage(int id, String link, String caption, int projectid) {
        this.id = id;
        this.link = link;
        this.caption = caption;
        this.projectid = projectid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getProjectid() {
        return projectid;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }

    @Override
    public String toString() {
        return "ProjectImage{" + "id=" + id + ", link=" + link + ", caption=" + caption + ", projectid=" + projectid + '}';
    }

   
    
    
}
