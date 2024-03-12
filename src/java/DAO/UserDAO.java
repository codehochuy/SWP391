/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Role;
import DTO.User;
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
 * @author ACER
 */
public class UserDAO {

    private DBContext db;

    public UserDAO() {
        db = new DBContext();
    }

    public UserDAO(DBContext db) {
        this.db = db;
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    public User detailUser(String username, String password) {
        try {
            String sql = "SELECT e.*, r.RoleName\n"
                    + "FROM Users e\n"
                    + "JOIN Roles r ON e.RoleId = r.RoleID\n"
                    + "WHERE e.UserName = ? AND e.Password = ?";

            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int userID = rs.getInt("UsersID");
                String accountName = rs.getString("Name");
                String email = rs.getString("Email");
                String userAddress = rs.getString("Address");
                String userPhone = rs.getString("Phone");
                int roleID = rs.getInt("RoleID");
                String roleName = rs.getString("RoleName");
                boolean userStatus = rs.getBoolean("UserStatus");
                String avatar = rs.getString("Avatar");

                Role role = new Role();
                role.setId(roleID);
                role.setName(roleName);

                User user = new User(userID, username, password, accountName, avatar, email, userAddress, userPhone, userStatus, role);
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT e.*, r.RoleName\n"
                + "FROM Users e\n"
                + "JOIN Roles r ON e.RoleId = r.RoleID";

        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                User p = new User();

                p.setId(rs.getInt("UsersID"));
                p.setUsername(rs.getString("UserName"));
                p.setPassword(rs.getString("Password"));
                p.setName(rs.getString("Name"));
                p.setEmail(rs.getString("Email"));
                p.setAvatar(rs.getString("Avatar"));
                p.setAddress(rs.getString("Address"));
                p.setPhone(rs.getString("Phone"));
                p.setUserstatus(rs.getBoolean("UserStatus"));

                p.setUserrole(new Role(rs.getInt("RoleID"), rs.getString("RoleName")));

                if (!p.getAvatar().contains("http")) {
                    p.setAvatar("./img/" + p.getAvatar());
                }

                list.add(p);
            }
        } catch (SQLException e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return list;
    }

    public boolean deleteuser(String id) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1. Connect DB
            con = db.getConn();
            if (con != null) {

                //2. Write SQL command
                String sql = "UPDATE Users SET UserStatus = 'false'  WHERE UsersID = ? and UserStatus ='true'";
                //3. Create Statement Object
                stm = con.prepareStatement(sql); //Nạp tham số 1 lần cho Statement
                stm.setString(1, id);

                //4. Execute Statement Object to get result
                int effectRow = stm.executeUpdate();
                //Nạp tham số 1 lần cho Statement
                //5. Process result
                if (effectRow > 0) {
                    result = true;
                } else {
                    result = false;

                }
                System.out.println(result);

            } //end connection has existed
        } catch (SQLException e) {
        } finally {

            if (stm != null) {
                stm.close();  // tạo sau nên đóng trước
            }
            if (con != null) {
                con.close();
            }
        }
        return result;

    }

    public boolean adduser(String id) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1. Connect DB
            con = db.getConn();
            if (con != null) {
                String sql = "UPDATE Users SET UserStatus = 'true'   WHERE UsersID = ? AND UserStatus = 'false'";
                //3. Create Statement Object
                stm = con.prepareStatement(sql); //Nạp tham số 1 lần cho Statement
                stm.setString(1, id);

                //4. Execute Statement Object to get result
                int effectRow = stm.executeUpdate();
                //Nạp tham số 1 lần cho Statement
                //5. Process result
                if (effectRow > 0) {
                    result = true;
                } else {
                    result = false;
                }

            } //end connection has existed
        } catch (SQLException e) {
        } finally {

            if (stm != null) {
                stm.close();  // tạo sau nên đóng trước
            }
            if (con != null) {
                con.close();
            }
        }
        return result;

    }

    public boolean registerUser(String username, String name, String email, String password) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        String avatar = "avatar.jpg";
        String address = "";
        String phone = "";

        try {
            //1. Connect to the database
            con = db.getConn();
            if (con != null) {
                String sql = "INSERT INTO Users (UserName, [Name], Email, [Password], RoleID, UserStatus, Avatar, [Address], Phone) VALUES (?, ?, ?, ?, 3, 1, ?, ?, ?)";
                //3. Create PreparedStatement object
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, name);
                stm.setString(3, email);
                stm.setString(4, password);
                stm.setString(5, avatar);
                stm.setString(6, address);
                stm.setString(7, phone);

                //4. Execute PreparedStatement to get the result
                int effectRow = stm.executeUpdate();

                //5. Process the result
                result = (effectRow > 0);
            }
        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
            throw e; // Rethrow the exception to the caller
        } finally {
            //6. Close the resources properly
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(result);
        return result;
    }

    public boolean isUsernameExists(String username) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet resultSet = null;
        boolean result = false;
        try {
            //1. Connect DB
            con = db.getConn();
            if (con != null) {
                String sql = "SELECT COUNT(*) FROM Users WHERE UserName = ?";
                //3. Create Statement Object
                stm = con.prepareStatement(sql); //Nạp tham số 1 lần cho Statement
                stm.setString(1, username);

                // Execute the query
                resultSet = stm.executeQuery();

                // Check if the username exists
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }

            } //end connection has existed
        } catch (SQLException e) {
        } finally {

            if (stm != null) {
                stm.close();  // tạo sau nên đóng trước
            }
            if (con != null) {
                con.close();
            }
        }

        return false;
    }
    
    public boolean isEmailExists(String mail) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet resultSet = null;
        boolean result = false;
        try {
            //1. Connect DB
            con = db.getConn();
            if (con != null) {
                String sql = "SELECT COUNT(*) FROM Users WHERE Email = ?";
                //3. Create Statement Object
                stm = con.prepareStatement(sql); //Nạp tham số 1 lần cho Statement
                stm.setString(1, mail);

                // Execute the query
                resultSet = stm.executeQuery();

                // Check if the username exists
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }

            } //end connection has existed
        } catch (SQLException e) {
        } finally {

            if (stm != null) {
                stm.close();  // tạo sau nên đóng trước
            }
            if (con != null) {
                con.close();
            }
        }

        return false;
    }

    public static void main(String[] args) throws SQLException {
        UserDAO dao = new UserDAO();
//        System.out.println(dao.getAll());

//        System.out.println(dao.detailUser("Admin", "123"));
//        System.out.println(dao.listShop());
//        dao.deleteuser("2");
        dao.registerUser("huyyy", "Phạm Huy", "hailuatamquan@gmail.com", "123");
//        System.out.println(dao.isUsernameExists("Hieu"));
    }

}
