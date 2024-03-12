/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 *
 * @author ACER
 */
public class Project_containsImage {
    private int id;
    private String name;
    private String description;
    private Date date;
    private int time;
    private Service service;
    private HouseType houseType;
    private Style style;
    private User user;
    private String imageLink;

    public Project_containsImage() {
    }

    public Project_containsImage(int id, String name, String description, Date date, int time, Service service, HouseType houseType, Style style, User user, String imageLink) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.time = time;
        this.service = service;
        this.houseType = houseType;
        this.style = style;
        this.user = user;
        this.imageLink = imageLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public HouseType getHouseType() {
        return houseType;
    }

    public void setHouseType(HouseType houseType) {
        this.houseType = houseType;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    @Override
    public String toString() {
        return "Project_containsImage{" + "id=" + id + ", name=" + name + ", description=" + description + ", date=" + date + ", time=" + time + ", service=" + service + ", houseType=" + houseType + ", style=" + style + ", user=" + user + ", imageLink=" + imageLink + '}';
    }
    
}
    
