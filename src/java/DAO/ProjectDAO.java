/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.HouseType;
import DTO.Project;
import DTO.Role;
import DTO.Service;
import DTO.Style;
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
public class ProjectDAO {

    private DBContext db;

    public ProjectDAO() {
        db = new DBContext();
    }

    public ProjectDAO(DBContext db) {
        this.db = db;
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    public List<Project> getAll() {
        List<Project> list = new ArrayList<>();

        String sql = "SELECT\n"
                + "    P.ProjectID,P.ProjectName,P.Description,P.Date, P.Time,\n"
                + "    S.ServiceID,S.ServiceName,\n"
                + "    H.HouseTypeID,H.HouseTypeName,\n"
                + "    U.UsersID,U.UserName, U.Name, U.Avatar, U.Email, U.[Password], U.Address, U.Phone, U.UserStatus,   \n"
                + "	R.RoleID,R.RoleName,St.StyleID,St.StyleName\n"
                + "FROM\n"
                + "    Projects P\n"
                + "    INNER JOIN [Service] S ON P.ServiceID = S.ServiceID\n"
                + "    INNER JOIN [HouseType] H ON P.HouseTypeID = H.HouseTypeID\n"
                + "    INNER JOIN Users U ON P.UsersID = U.UsersID\n"
                + "    INNER JOIN Roles R ON U.RoleID = R.RoleID\n"
                + "    INNER JOIN [Style] St ON P.StyleID = St.StyleID;";
        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Project project = extractProjectFromResultSet(rs);
                project.setUser(extractUserFromResultSet(rs));
                list.add(project);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the exception as needed
        }

        return list;
    }

    private Project extractProjectFromResultSet(ResultSet rs) throws SQLException {
        Project project = new Project();
        project.setId(rs.getInt("ProjectID"));
        project.setName(rs.getString("ProjectName"));
        project.setDescription(rs.getString("Description"));
        project.setDate(rs.getDate("Date"));
        project.setTime(rs.getInt("Time"));
        project.setHouseType(new HouseType(rs.getInt("HouseTypeID"), rs.getString("HouseTypeName")));
        project.setService(new Service(rs.getInt("ServiceID"), rs.getString("ServiceName")));
        project.setStyle(new Style(rs.getInt("StyleID"), rs.getString("StyleName")));

        return project;
    }

    private User extractUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("UsersID"));
        user.setUsername(rs.getString("UserName"));
        user.setPassword(rs.getString("Password"));
        user.setName(rs.getString("Name"));
        user.setEmail(rs.getString("Email"));
        user.setAvatar(rs.getString("Avatar"));
        user.setAddress(rs.getString("Address"));
        user.setPhone(rs.getString("Phone"));
        user.setUserstatus(rs.getBoolean("UserStatus"));
        user.setUserrole(new Role(rs.getInt("RoleID"), rs.getString("RoleName")));

        // Adjust avatar path if needed
        if (!user.getAvatar().contains("http")) {
            user.setAvatar("./img/" + user.getAvatar());
        }

        return user;
    }

    public boolean deleteProject(String id) {
        try (Connection con = db.getConn();
                PreparedStatement stm = con.prepareStatement("DELETE FROM Projects WHERE ProjectID = ?")) {

            stm.setString(1, id);
            int effectRow = stm.executeUpdate();

            return effectRow > 0;

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception (log it, throw it, etc.)
            return false;
        }
    }

    public Project getProjectbyID(String id) {
        String sql = "SELECT\n"
                + "    P.ProjectID, P.ProjectName, P.Description, P.Date, P.Time,\n"
                + "    S.ServiceID, S.ServiceName,\n"
                + "    H.HouseTypeID, H.HouseTypeName,\n"
                + "    U.UsersID, U.UserName, U.Name, U.Avatar, U.Email, U.[Password], U.Address, U.Phone, U.UserStatus,\n"
                + "    R.RoleID, R.RoleName,\n"
                + "    St.StyleID, St.StyleName\n"
                + "FROM\n"
                + "    Projects P\n"
                + "INNER JOIN\n"
                + "    [Service] S ON P.ServiceID = S.ServiceID\n"
                + "INNER JOIN\n"
                + "    [HouseType] H ON P.HouseTypeID = H.HouseTypeID\n"
                + "INNER JOIN\n"
                + "    Users U ON P.UsersID = U.UsersID\n"
                + "INNER JOIN\n"
                + "    Roles R ON U.RoleID = R.RoleID\n"
                + "INNER JOIN\n"
                + "    [Style] St ON P.StyleID = St.StyleID\n"
                + "WHERE\n"
                + "    P.ProjectID = ?;";

        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Project project = new Project();
                    project.setId(rs.getInt("ProjectID"));
                    project.setName(rs.getString("ProjectName"));
                    project.setDescription(rs.getString("Description"));
                    project.setDate(rs.getDate("Date"));
                    project.setTime(rs.getInt("Time"));
                    project.setHouseType(new HouseType(rs.getInt("HouseTypeID"), rs.getString("HouseTypeName")));
                    project.setService(new Service(rs.getInt("ServiceID"), rs.getString("ServiceName")));
                    project.setStyle(new Style(rs.getInt("StyleID"), rs.getString("StyleName")));
                    project.setUser(extractUserFromResultSet(rs));
                    return project;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception (log it, throw it, etc.)
        }
        return null;
    }

    public boolean createProject(String name, String description, String date, int time, int serviceID,
            int houseTypeID, int styleID, int userID) {
        String sql = "INSERT INTO Projects (ProjectName, [Description], [Date], [Time], ServiceID, HouseTypeID, UsersID, StyleID)\n"
                + "VALUES (?, ?,?, ?, ?, ?, ?, ?);";

        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setString(3, date);
            ps.setInt(4, time);
            ps.setInt(5, serviceID);
            ps.setInt(6, houseTypeID);
            ps.setInt(7, userID);
            ps.setInt(8, styleID);

            int rowsAffected = ps.executeUpdate();

            // Check if at least one row was affected
            return rowsAffected > 0;
        } catch (SQLException e) {
            // Log or handle the exception as needed
            e.printStackTrace();
            return false;
        }
    }

     public int getProjectId() {
        int projectID = 0;

        try {
            String sql = "SELECT MAX(ProjectID) AS MaxProjectID FROM Projects";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                projectID = rs.getInt("MaxProjectID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return projectID;
    }
    public static void main(String[] args) {
        ProjectDAO dao = new ProjectDAO();
//        System.out.println(dao.createProject("huy", "huy", "2022-01-02", 100, 1, 2, 1, 2));
System.out.println(dao.getProjectId());

    }

}
