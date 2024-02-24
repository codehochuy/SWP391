/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utils.DBContext;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class ProfileDAO {

    private DBContext db;

    public ProfileDAO() {
        db = new DBContext();
    }

    public ProfileDAO(DBContext db) {
        this.db = db;
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    public void updateProfile(String accname, String avatar, String address, String phone, int userId) {
        try {
            String sql = "UPDATE Users\n"
                    + "SET Name = ?, Avatar=?, Address=?, Phone=?\n"
                    + "Where UsersID=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, accname);
            stmt.setString(2, avatar);
            stmt.setString(3, address);
            stmt.setString(4, phone);
            stmt.setInt(5, userId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePassword(String name, String password) {
        try {
            String sql = "UPDATE Users\n"
                    + "SET Password = ?\n"
                    + "Where UserName = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, password);
            stmt.setString(2, name);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ProfileDAO dao = new ProfileDAO();
        dao.updateProfile("Hieu", "User3.jpg", "bình dương", "0123123123", 4);
    }

}
