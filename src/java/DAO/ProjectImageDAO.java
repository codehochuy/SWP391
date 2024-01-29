/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ProjectImage;
import Utils.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class ProjectImageDAO {
    
    private DBContext db;
    
    public ProjectImageDAO() {
        db = new DBContext();
    }
    
    public ProjectImageDAO(DBContext db) {
        this.db = db;
    }
    
    public DBContext getDb() {
        return db;
    }
    
    public void setDb(DBContext db) {
        this.db = db;
    }
    
    public List<ProjectImage> getAll() {
        List<ProjectImage> list = new ArrayList<>();
        String sql = "SELECT * FROM [Image]";
        
        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                ProjectImage service = new ProjectImage(rs.getInt("ImageID"), rs.getString("ImageLink"), rs.getString("ImageCaption"), rs.getInt("ProjectID"));
                list.add(service);
            }
            
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the exception as needed
        }
        
        return list;
    }
    
    public List<ProjectImage> getProjectImagesByProjectID(String projectID) {
        List<ProjectImage> imageList = new ArrayList<>();
        String sql = "SELECT * FROM [Image] WHERE ProjectID = ?";
        
        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, projectID);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ProjectImage image = new ProjectImage();
                    image.setId(rs.getInt("ImageID"));
                    image.setLink(rs.getString("ImageLink"));
                    image.setCaption(rs.getString("ImageCaption"));
                    image.setProjectid(rs.getInt("ProjectID"));                    
                    imageList.add(image);
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception (log it, throw it, etc.)
        }
        return imageList;
    }
    
    public void createProjectImage(String link, String caption, int projectID) {
        String sql = "INSERT INTO Image (ImageLink, ImageCaption, ProjectID) VALUES (?, ?, ?);";
        
        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, link);
            ps.setString(2, caption);
            ps.setInt(3, projectID);

            // Execute the update, but we don't need to check the result
            ps.executeUpdate();
        } catch (SQLException e) {
            // Log or handle the exception as needed
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        ProjectImageDAO dao = new ProjectImageDAO();
//        System.out.println(dao.getProjectImagesByProjectID("1"));
        dao.createProjectImage("admin.jpg", "hhhh", 1);
    }
    
}
