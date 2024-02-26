/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Material;
import DTO.MaterialCategory;
import Utils.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class MaterialDAO {

    private DBContext db;

    public MaterialDAO() {
        db = new DBContext();
    }

    public MaterialDAO(DBContext db) {
        this.db = db;
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    public List<Material> getAll() {
        List<Material> list = new ArrayList<>();
        try {
            String sql = "SELECT Material.MaterialID, Material.MaterialName, Material.MaterialPrice, Material.MaterialLink, CategoryMaterial.CategoryMaterialName\n"
                    + "FROM Material\n"
                    + "INNER JOIN CategoryMaterial ON Material.CategoryMaterialID = CategoryMaterial.CategoryMaterialID;";

            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("MaterialID");
                String name = rs.getString("MaterialName");
                String price = rs.getString("MaterialPrice");
                String category = rs.getString("CategoryMaterialName");
                String link = rs.getString("MaterialLink");
                Material mat = new Material(id, name, price, category, link);
                list.add(mat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public Material getByID(String materialID) {
        Material mat = new Material();
        try {
            String sql = "SELECT Material.MaterialID, Material.MaterialName, Material.MaterialPrice, Material.MaterialLink, CategoryMaterial.CategoryMaterialName\n"
                    + "FROM Material\n"
                    + "INNER JOIN CategoryMaterial ON Material.CategoryMaterialID = CategoryMaterial.CategoryMaterialID\n"
                    + "WHERE Material.MaterialID = ?";
            
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, materialID);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("MaterialID");
                String name = rs.getString("MaterialName");
                String price = rs.getString("MaterialPrice");
                String category = rs.getString("CategoryMaterialName");
                String link = rs.getString("MaterialLink");
                mat = new Material(id, name, price, category, link);
                return mat;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<MaterialCategory> getMaterialCategory() {
        List<MaterialCategory> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM CategoryMaterial";

            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("CategoryMaterialID");
                String name = rs.getString("CategoryMaterialName");
                MaterialCategory matc = new MaterialCategory(id, name);
                list.add(matc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean createMaterial(String name, String price, String category) {
        String sql = "INSERT INTO Material (MaterialName, MaterialPrice, CategoryMaterialID) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = db.getConn().prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, price);
            ps.setString(3, category);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getMaterialID() {
        int materialID = 0;
        try {
            String sql = "SELECT MAX(MaterialID) AS MaxMaterialID FROM Material";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                materialID = rs.getInt("MaxMaterialID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return materialID;
    }

    public void addImage(int materialID, String image) {
        String sql = "UPDATE Material SET MaterialLink = ? WHERE MaterialID = ?";

        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, image);
            ps.setInt(2, materialID);

            // Execute the update, but we don't need to check the result
            ps.executeUpdate();
        } catch (SQLException e) {
            // Log or handle the exception as needed
            e.printStackTrace();
        }
    }
}