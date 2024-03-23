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
import java.sql.Time;
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
            String sql = "SELECT Material.MaterialID, Material.MaterialName, Material.MaterialPrice, Material.MaterialType, Material.MaterialUnit, Material.MaterialLink, CategoryMaterial.CategoryMaterialName\n"
                    + "FROM Material\n"
                    + "INNER JOIN CategoryMaterial ON Material.CategoryMaterialID = CategoryMaterial.CategoryMaterialID ORDER BY Material.MaterialID DESC";

            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("MaterialID");
                String name = rs.getString("MaterialName");
                String price = rs.getString("MaterialPrice");
                String category = rs.getString("CategoryMaterialName");
                String link = rs.getString("MaterialLink");
                String type = rs.getString("MaterialType");
                String unit = rs.getString("MaterialUnit");
                Material mat = new Material(id, name, price, type, unit, category, link);
                list.add(mat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<Material> getMaterialRaw() {
        List<Material> list = new ArrayList<>();
        try {
            String sql = "SELECT Material.MaterialID, Material.MaterialName, Material.MaterialPrice, Material.MaterialType, Material.MaterialUnit, Material.MaterialLink, CategoryMaterial.CategoryMaterialName\n"
                    + "FROM Material\n"
                    + "INNER JOIN CategoryMaterial ON Material.CategoryMaterialID = CategoryMaterial.CategoryMaterialID WHERE Material.MaterialType = 0 ORDER BY Material.MaterialID DESC";

            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("MaterialID");
                String name = rs.getString("MaterialName");
                String price = rs.getString("MaterialPrice");
                String category = rs.getString("CategoryMaterialName");
                String link = rs.getString("MaterialLink");
                String type = rs.getString("MaterialType");
                String unit = rs.getString("MaterialUnit");
                Material mat = new Material(id, name, price, type, unit, category, link);
                list.add(mat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<Material> getMaterialFull() {
        List<Material> list = new ArrayList<>();
        try {
            String sql = "SELECT Material.MaterialID, Material.MaterialName, Material.MaterialPrice, Material.MaterialType, Material.MaterialUnit, Material.MaterialLink, CategoryMaterial.CategoryMaterialName\n"
                    + "FROM Material\n"
                    + "INNER JOIN CategoryMaterial ON Material.CategoryMaterialID = CategoryMaterial.CategoryMaterialID WHERE Material.MaterialType = 1 ORDER BY Material.MaterialID DESC";

            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("MaterialID");
                String name = rs.getString("MaterialName");
                String price = rs.getString("MaterialPrice");
                String category = rs.getString("CategoryMaterialName");
                String link = rs.getString("MaterialLink");
                String type = rs.getString("MaterialType");
                String unit = rs.getString("MaterialUnit");
                Material mat = new Material(id, name, price, type, unit, category, link);
                list.add(mat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<Material> getMaterialAll() {
        List<Material> list = new ArrayList<>();
        try {
            String sql = "SELECT Material.MaterialID, Material.MaterialName, Material.MaterialPrice, Material.MaterialType, Material.MaterialUnit, Material.MaterialLink, CategoryMaterial.CategoryMaterialName\n"
                    + "FROM Material\n"
                    + "INNER JOIN CategoryMaterial ON Material.CategoryMaterialID = CategoryMaterial.CategoryMaterialID WHERE Material.MaterialType = 0 ORDER BY Material.MaterialID DESC";

            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("MaterialID");
                String name = rs.getString("MaterialName");
                String price = rs.getString("MaterialPrice");
                String category = rs.getString("CategoryMaterialName");
                String link = rs.getString("MaterialLink");
                String type = rs.getString("MaterialType");
                String unit = rs.getString("MaterialUnit");
                Material mat = new Material(id, name, price, type, unit, category, link);
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
            String sql = "SELECT Material.MaterialID, Material.MaterialName, Material.MaterialPrice, Material.MaterialType, Material.MaterialUnit, Material.MaterialLink, CategoryMaterial.CategoryMaterialName\n"
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
                String type = rs.getString("MaterialType");
                String unit = rs.getString("MaterialUnit");
                mat = new Material(id, name, price, type, unit, category, link);
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

    public boolean createMaterial(String name, String price, String unit, String type, String category) {
        String sql = "INSERT INTO Material (MaterialName, MaterialPrice, MaterialUnit, MaterialType, CategoryMaterialID) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = db.getConn().prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, price);
            ps.setString(3, unit);
            ps.setString(4, type);
            ps.setString(5, category);
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
    
    public boolean createCategory(String categoryname) {
        String sql = "INSERT INTO CategoryMaterial (CategoryMaterialName) VALUES (?)";

        try {
            PreparedStatement ps = db.getConn().prepareStatement(sql);
            ps.setString(1, categoryname);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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

    public boolean deleteMaterial(String id) {
        try (Connection con = db.getConn();
                PreparedStatement stm = con.prepareStatement("DELETE FROM Material WHERE MaterialID = ?")) {

            stm.setString(1, id);
            int effectRow = stm.executeUpdate();

            return effectRow > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateMaterial(String name, String price, String unit, String type, String material, String id) {
        // Chuỗi SQL cho truy vấn cập nhật
        String sql = "UPDATE Material SET MaterialName = ?, MaterialPrice = ?, MaterialUnit = ?, MaterialType = ?, CategoryMaterialID = ? WHERE MaterialID = ?";

        try {
            // Chuẩn bị câu lệnh truy vấn
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            // Đặt các tham số cho câu lệnh truy vấn
            stmt.setString(1, name);
            stmt.setString(2, price);
            stmt.setString(3, unit);
            stmt.setString(4, type);
            stmt.setString(5, material);
            stmt.setString(6, id);
            // Đặt giá trị của tham số id, bạn cần thay thế id bằng id thực tế của dự án bạn muốn cập nhật

            // Thực thi câu lệnh truy vấn và kiểm tra số dòng bị ảnh hưởng
            int rowsAffected = stmt.executeUpdate();

            // Trả về true nếu số dòng bị ảnh hưởng lớn hơn 0, tức là cập nhật thành công
            return rowsAffected > 0;
        } catch (SQLException e) {
            // Xử lý ngoại lệ SQL nếu có
            e.printStackTrace();
        }
        // Trả về false nếu có lỗi xảy ra hoặc không có dòng nào bị ảnh hưởng, tức là cập nhật không thành công
        return false;
    }

//    public int SendLeaveApplication(String ID, String leaveShift, String leaveReason, String submitTime, String submitDate) throws SQLException {
//        Connection conn = null;
//        PreparedStatement ptm = null;
//        ResultSet rs = null;
//        int re = 0;
////        try {
////            conn = DBUtils.getConnection();
////            if (conn != null) {
////                ptm = conn.prepareStatement("INSERT INTO Applications (ShiftID, LeaveReason, EmployeeID) VALUES (?, ?, ?)");
//////                ptm = conn.prepareStatement("INSERT INTO Applications (LeaveDate, LeaveReason, ApplicationStatus, EmployeeID)\n"
//////                        + "SELECT ? AS LeaveDate, ? AS LeaveReason, 'false' AS ApplicationStatus, e.EmployeeID\n"
//////                        + "FROM Employee e\n"
//////                        + "WHERE e.EmployeeName = N?");
////                ptm.setString(1, leaveShift);
////                ptm.setString(2, leaveReason);
////                ptm.setString(3, ID);
////                rs = ptm.executeQuery();
////            }
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return 0;
//        try {
//            if (conn != null) {
//                ptm = conn.prepareStatement("INSERT INTO Applications(ShiftID, EmployeeID, LeaveReason)\n"
//                        + "SELECT ?, ?, ?\n"
//                        + "FROM Shifts\n"
//                        + "WHERE ShiftID = ? AND CAST(StartDate AS DATETIME) + CAST(StartTime AS DATETIME) >= DATEADD(HOUR, 12, CAST(? AS DATETIME) + CAST(? AS DATETIME));");
//                ptm.setString(1, leaveShift);
//                ptm.setString(2, ID);
//                ptm.setString(3, leaveReason);
//                ptm.setString(4, leaveShift);
//                ptm.setString(5, submitDate);
//                ptm.setString(6, submitTime);
//                re = ptm.executeUpdate();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return re;
//    }
//
//    public void ShowLeaveApplication() throws SQLException {
//        Connection conn = null;
//        PreparedStatement ptm = null;
//        ResultSet rs = null;
//        try {
//            if (conn != null) {
//                ptm = conn.prepareStatement("SELECT A.ShiftID, A.LeaveReason, A.ApplicationStatus, A.EmployeeID, A.IsApproved, B.EmployeeName\n"
//                        + "FROM Applications A\n"
//                        + "JOIN Employee B ON A.EmployeeID = B.EmployeeID;");
//                rs = ptm.executeQuery();
//            }
//            while (rs.next()) {
//                int leaveShift = rs.getInt("ShiftID");
//                String leaveReason = rs.getString("LeaveReason");
//                boolean applicationStatus = rs.getBoolean("ApplicationStatus");
//                int employeeID = rs.getInt("EmployeeID");
//                String employeeName = rs.getString("EmployeeName");
//                int isApproved = rs.getInt("IsApproved");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (rs != null) {
//                rs.close();
//            };
//            if (ptm != null) {
//                ptm.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }
//    }
//
//    public void ProcessLeaveApplication(String choice, String employeeID, String leaveReason, String leaveShift) {
//        String approve = "UPDATE Applications SET IsApproved = 1, ApplicationStatus = 1 WHERE EmployeeID = ? and LeaveReason = ?\n"
//                + "                UPDATE Shifts SET EmployeeIDSecond = NULL WHERE ShiftID = ? AND EmployeeIDSecond = ?\n"
//                + "                UPDATE Shifts SET EmployeeIDFirst = NULL WHERE ShiftID = ? AND EmployeeIDFirst = ?";
//        String reject = "UPDATE Applications SET IsApproved = 0, ApplicationStatus = 1 WHERE EmployeeID = ? and LeaveReason = ?";
//        Connection conn = null;
//        PreparedStatement ptm = null;
//        ResultSet rs = null;
//        try {
//            if (conn != null) {
//                if (choice.equals("yes")) {
//                    ptm = conn.prepareStatement(approve);
//                    ptm.setString(1, employeeID);
//                    ptm.setString(2, leaveReason);
//                    ptm.setString(3, leaveShift);
//                    ptm.setString(4, employeeID);
//                    ptm.setString(5, leaveShift);
//                    ptm.setString(6, employeeID);
//                }
//                if (choice.equals("no")) {
//                    ptm = conn.prepareStatement(reject);
//                    ptm.setString(1, employeeID);
//                    ptm.setString(2, leaveReason);
//                }
////                ptm = conn.prepareStatement(approve);
//                rs = ptm.executeQuery();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void DeleteLeaveApplication(String leaveShift) throws SQLException {
//        Connection conn = null;
//        PreparedStatement ptm = null;
//        ResultSet rs = null;
//        try {
//            if (conn != null) {
//                ptm = conn.prepareStatement("DELETE FROM Applications WHERE ShiftID = ?");
//                ptm.setString(1, leaveShift);
//                rs = ptm.executeQuery();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void TakeAttendance(String date, String time, String employeeID, String leaveShift, String button) {
//        Connection conn = null;
//        PreparedStatement ptm = null;
//        ResultSet rs = null;
//        try {
//            if (conn != null && button.equals("CHECK IN")) {
//                ptm = conn.prepareStatement("INSERT INTO Attendance(CheckInDate, CheckInTime, EmployeeID, ShiftID) VALUES(?, ?, ?, ?)");
//                ptm.setString(1, date);
//                ptm.setString(2, time);
//                ptm.setString(3, employeeID);
//                ptm.setString(4, leaveShift);
//                rs = ptm.executeQuery();
//            }
//            if (conn != null && button.equals("CHECK OUT")) {
//                ptm = conn.prepareStatement("UPDATE Attendance SET CheckOutDate = ?, CheckOutTime = ? WHERE ShiftID = ?");
//                ptm.setString(1, date);
//                ptm.setString(2, time);
//                ptm.setString(3, leaveShift);
//                rs = ptm.executeQuery();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void TakeAttendancever2(String employeeID, String shiftID) {
//        Connection conn = null;
//        PreparedStatement ptm = null;
//        ResultSet rs = null;
//        try {
//            if (conn != null) {
//                ptm = conn.prepareStatement("INSERT INTO [dbo].[Attendance]\n"
//                        + "           ([CheckInDate]\n"
//                        + "           ,[CheckInTime]\n"
//                        + "           ,[EmployeeID]\n"
//                        + "           ,[ShiftID])\n"
//                        + "     VALUES\n"
//                        + "           (CONVERT(date,GETDATE())\n"
//                        + "           ,CONVERT(time,GETDATE())\n"
//                        + "           ,?\n"
//                        + "           ,?)");
//                ptm.setString(1, employeeID);
//                ptm.setString(2, shiftID);
//                rs = ptm.executeQuery();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void ShowAttendanceReport() throws SQLException {
//        Connection conn = null;
//        PreparedStatement ptm = null;
//        ResultSet rs = null;
//        try {
//            if (conn != null) {
//                ptm = conn.prepareStatement("UPDATE Attendance SET LateTime = DATEDIFF(MINUTE, CONVERT(DATETIME, T2.StartTime), CONVERT(DATETIME, T1.CheckInTime)) FROM Attendance T1\n"
//                        + "JOIN Shifts T2 ON T1.ShiftID = T2.ShiftID UPDATE Attendance SET SoonTime = DATEDIFF(MINUTE, CONVERT(DATETIME, T1.CheckOutTime), CONVERT(DATETIME, T2.EndTime))\n"
//                        + "FROM Attendance T1 JOIN Shifts T2 ON T1.ShiftID = T2.ShiftID");
//                ptm.executeUpdate();
//
//                ptm = conn.prepareStatement("SELECT\n"
//                        + "    a.EmployeeID, e.EmployeeName, a.ShiftID, a.CheckInDate, a.CheckInTime, a.CheckOutDate, a.CheckOutTime, a.LateTime,\n"
//                        + "	CAST(DATEDIFF(second, CAST(a.CheckInDate AS datetime) + CAST(a.CheckInTime AS datetime), CAST(a.CheckOutDate AS datetime) + CAST(a.CheckOutTime AS datetime)) / 3600 AS varchar) + ':' +\n"
//                        + "    RIGHT('0' + CAST((DATEDIFF(second, CAST(a.CheckInDate AS datetime) + CAST(a.CheckInTime AS datetime), CAST(a.CheckOutDate AS datetime) + CAST(a.CheckOutTime AS datetime)) / 60) % 60 AS varchar), 2) + ':' +\n"
//                        + "    RIGHT('0' + CAST(DATEDIFF(second, CAST(a.CheckInDate AS datetime) + CAST(a.CheckInTime AS datetime), CAST(a.CheckOutDate AS datetime) + CAST(a.CheckOutTime AS datetime)) % 60 AS varchar), 2) AS TimeDifference\n"
//                        + "FROM\n"
//                        + "    Attendance a\n"
//                        + "    JOIN Employee e ON a.EmployeeID = e.EmployeeID\n"
//                        + "ORDER BY\n"
//                        + "    a.ShiftID ASC, a.EmployeeID ASC");
//                rs = ptm.executeQuery();
//            }
//            while (rs.next()) {
//                int employeeID = rs.getInt("EmployeeID");
//                String employeeName = rs.getString("EmployeeName");
//                int shiftID = rs.getInt("ShiftID");
//                String checkInDate = rs.getString("CheckInDate");
//                Time checkInTime = rs.getTime("CheckInTime");
//                String checkOutDate = rs.getString("CheckOutDate");
//                Time checkOutTime = rs.getTime("CheckOutTime");
//                String lateTime = rs.getString("LateTime");
//                String timeDifference = rs.getString("TimeDifference");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (rs != null) {
//                rs.close();
//            };
//            if (ptm != null) {
//                ptm.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }
//    }
}