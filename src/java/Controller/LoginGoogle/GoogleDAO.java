/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.LoginGoogle;

import DTO.Role;
import DTO.User;
import Utils.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class GoogleDAO {

    private DBContext db;

    public GoogleDAO() {
        db = new DBContext();
    }

    public GoogleDAO(DBContext db) {
        this.db = db;
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    public User detailUser(String googleid, String gmail) {
        try {
            String sql = "SELECT e.* ,r.RoleName FROM Users e JOIN Roles r ON e.RoleId = r.RoleId WHERE UserName = ? and Email = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, googleid);
            stmt.setString(2, gmail);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String dbGoogleId = rs.getString("UserName");
                String dbGmail = rs.getString("Email");

                if (dbGoogleId.equals(googleid) && dbGmail.equals(gmail)) {
                    int userID = rs.getInt("UsersID");
                    String accountName = rs.getString("Name");
                    String userAddress = rs.getString("Address");
                    String password = rs.getString("Password");
                    String userPhone = rs.getString("Phone");
                    int roleID = rs.getInt("RoleID");
                    String roleName = rs.getString("RoleName");
                    boolean userStatus = rs.getBoolean("UserStatus");
                    String avatar = rs.getString("Avatar");
                    
                    Role role = new Role();
                    role.setId(roleID);
                    role.setName(roleName);

                    User user = new User(userID, googleid, password, accountName, avatar, gmail, userAddress, userPhone, userStatus, role);
                    return user;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GoogleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public boolean LoginGoogle(String googleid, String gmail,String avatar,String name) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
//        String avatar = "avatar.jpg";
        String address = "";
        String phone = "";
        try {
            con = getDb().getConn();
            if (con != null) {
                String sql = "INSERT INTO Users (UserName, [Name], Email, RoleID, UserStatus, Avatar, [Address], Phone) VALUES (?, ?, ?, 3, 1, ?, ?, ?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, googleid);
                stm.setString(3, gmail);

                stm.setString(2, name);
                stm.setString(4, avatar);
                stm.setString(5, address);
                stm.setString(6, phone);

                int effectRow = stm.executeUpdate();
                result = effectRow > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public boolean checkAccountGoogleExists(String gmail, String googleid) throws SQLException {
        String query = "SELECT COUNT(*) FROM Users WHERE Email = ? and UserName = ?";
        try (PreparedStatement statement = db.getConn().prepareStatement(query)) {
            statement.setString(1, gmail);
            statement.setString(2, googleid);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws SQLException {
        GoogleDAO aO = new GoogleDAO();
//        aO.LoginGoogle("djfkdf", "fkjskfjs");
    }
}
