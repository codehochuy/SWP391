/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ForgotPassword;

import Utils.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ACER
 */
public class SendMailDAO {

    private DBContext db;

    public SendMailDAO() {
        db = new DBContext();
    }

    public SendMailDAO(DBContext db) {
        this.db = db;
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    public boolean checkGmailExists(String gmail) throws SQLException {
        String query = "SELECT COUNT(*) FROM Users WHERE Email = ?";
        try (PreparedStatement statement = db.getConn().prepareStatement(query)) {
            statement.setString(1, gmail);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        }
        return false;
    }

    public boolean updatePassword(String pass, int id) throws SQLException {
        String query = "UPDATE Users SET Password = ? WHERE UsersID = ?";
        try (PreparedStatement statement = db.getConn().prepareStatement(query)) {
            statement.setString(1, pass);
            statement.setInt(2, id);
            int result = statement.executeUpdate();
            return result > 0;
        }
    }

    public int findUserIdByEmail(String email) throws SQLException {
        String query = "SELECT UsersID FROM Users WHERE Email = ?";
        try (PreparedStatement statement = db.getConn().prepareStatement(query)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("UsersID");
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws SQLException {
        SendMailDAO dao = new SendMailDAO();
        System.out.println(dao.findUserIdByEmail("huypt110402@gmail.com"));
        System.out.println(dao.updatePassword("123", 4));
//        System.out.println(dao.checkGmailExists("huypt110402@gmail.com"));

    }

}
