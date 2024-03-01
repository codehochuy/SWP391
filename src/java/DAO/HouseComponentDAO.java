/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.HouseComponent;
import Utils.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ACER
 */
public class HouseComponentDAO {

    private DBContext db;

    public HouseComponentDAO() {
        db = new DBContext();
    }

    public HouseComponentDAO(DBContext db) {
        this.db = db;
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    public boolean createHouseComponent(int houseTypeID, int componentID) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = db.getConn();
            String sql = "INSERT INTO HouseComponent (HouseTypeID, ComponentID) VALUES (?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, houseTypeID);
            stmt.setInt(2, componentID);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý ngoại lệ nếu cần
            return false;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace(); // Xử lý ngoại lệ nếu cần
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace(); // Xử lý ngoại lệ nếu cần
                }
            }
        }
    }
    public static void main(String[] args) {
        HouseComponentDAO dao = new HouseComponentDAO();
        System.out.println(dao.createHouseComponent(4, 1));
    }
    
}
