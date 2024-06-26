/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.AdminHouseComponent;
import DTO.AdminQuoVersion;
import DTO.CustomerHouseComponent;
import DTO.CustomerQuotation;
import DTO.HouseComponent;
import DTO.HouseType;
import DTO.Quotation;
import DTO.QuotationVersion;
import DTO.RoofNFoundation2;
import DTO.Service;
import DTO.Style;
import Utils.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class QuotationDAO {

    private DBContext db;

    public QuotationDAO() {
        db = new DBContext();
    }

    public QuotationDAO(DBContext db) {
        this.db = db;
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    public List<Quotation> getAll() {
        List<Quotation> list = new ArrayList<>();
        String sql = "SELECT\n"
                + "    Q.*,\n"
                + "    HT.HouseTypeName,\n"
                + "    Svc.ServiceName,\n"
                + "	S.StyleName\n"
                + "FROM\n"
                + "    Quotation Q\n"
                + "JOIN\n"
                + "    Style S ON Q.StyleID = S.StyleID\n"
                + "JOIN\n"
                + "    HouseType HT ON Q.HouseTypeID = HT.HouseTypeID\n"
                + "JOIN\n"
                + "    [Service] Svc ON Q.ServiceID = Svc.ServiceID;";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Quotation c = new Quotation();
                c.setId(rs.getInt("QuotationID"));
                c.setPrice1(rs.getDouble("Price1"));
                c.setPrice2(rs.getDouble("Price2"));
                c.setTime(rs.getInt("Time"));
                c.setHouseType(new HouseType(rs.getInt("HouseTypeID"), rs.getString("HouseTypeName")));
                c.setService(new Service(rs.getInt("ServiceID"), rs.getString("ServiceName")));
                c.setStyle(new Style(rs.getInt("StyleID"), rs.getString("StyleName")));

                list.add(c);
            }
            return list;
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    public Quotation getQuotaitonByServiveTypeStyle(int service, int type, int style) {
        Quotation quotation = new Quotation();
        String sql = "SELECT Q.*, HT.HouseTypeName, Svc.ServiceName, S.StyleName\n"
                + "FROM Quotation Q JOIN Style S ON Q.StyleID = S.StyleID\n"
                + "JOIN HouseType HT ON Q.HouseTypeID = HT.HouseTypeID\n"
                + "JOIN [Service] Svc ON Q.ServiceID = Svc.ServiceID\n"
                + "WHERE Q.StyleID = ? and Q.HouseTypeID = ? and Q.ServiceID = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, style);
            ps.setInt(2, type);
            ps.setInt(3, service);
            rs = ps.executeQuery();
            if (rs.next()) {
                Quotation c = new Quotation();
                c.setId(rs.getInt("QuotationID"));
                c.setPrice1(rs.getDouble("Price1"));
                c.setPrice2(rs.getDouble("Price2"));
                c.setTime(rs.getInt("Time"));
                c.setHouseType(new HouseType(rs.getInt("HouseTypeID"), rs.getString("HouseTypeName")));
                c.setService(new Service(rs.getInt("ServiceID"), rs.getString("ServiceName")));
                c.setStyle(new Style(rs.getInt("StyleID"), rs.getString("StyleName")));

                return c;
            }
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    public boolean deleteQuotation(String id) {
        try (Connection con = db.getConn();
                PreparedStatement stm = con.prepareStatement("DELETE FROM Quotation WHERE QuotationID = ?")) {

            stm.setString(1, id);
            int effectRow = stm.executeUpdate();

            return effectRow > 0;

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception (log it, throw it, etc.)
            return false;
        }
    }

    public Quotation getQuotationID(String id) {
        String sql = "SELECT\n"
                + "    Q.*,\n"
                + "    HT.HouseTypeName,\n"
                + "    Svc.ServiceName,\n"
                + "	S.StyleName\n"
                + "FROM\n"
                + "    Quotation Q\n"
                + "JOIN\n"
                + "    Style S ON Q.StyleID = S.StyleID\n"
                + "JOIN\n"
                + "    HouseType HT ON Q.HouseTypeID = HT.HouseTypeID\n"
                + "JOIN\n"
                + "    [Service] Svc ON Q.ServiceID = Svc.ServiceID\n"
                + "WHERE\n"
                + "    QuotationID = ?;";

        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Quotation quotation = new Quotation();
                    quotation.setId(rs.getInt("QuotationID"));
                    quotation.setPrice1(rs.getDouble("Price1"));
                    quotation.setPrice2(rs.getDouble("Price2"));
                    quotation.setTime(rs.getInt("Time"));
                    quotation.setHouseType(new HouseType(rs.getInt("HouseTypeID"), rs.getString("HouseTypeName")));
                    quotation.setService(new Service(rs.getInt("ServiceID"), rs.getString("ServiceName")));
                    quotation.setStyle(new Style(rs.getInt("StyleID"), rs.getString("StyleName")));
                    return quotation;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception (log it, throw it, etc.)
        }
        return null;
    }

    public RoofNFoundation2 getRoofNFoundationByID(int id) {
        String sql = "SELECT rf.RoofNFoundationID, rf.[Name] as RoofNFoundationName, rf.AreaPercent, cc.*\n"
                + "FROM RoofNFoundation rf \n"
                + "JOIN ComponentCategory cc ON rf.ComponentCategoryID = cc.ComponentCategoryID\n"
                + "WHERE rf.RoofNFoundationID = ?;";

        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    RoofNFoundation2 rf = new RoofNFoundation2();
                    rf.setRoofNFoundationId(rs.getInt("RoofNFoundationID"));
                    rf.setRoofNFoundationName(rs.getString("RoofNFoundationName"));
                    rf.setAreaPercent(rs.getInt("AreaPercent"));
                    rf.setComponentCategoryID(rs.getInt("ComponentCategoryID"));
                    rf.setCategoryName(rs.getString("Name"));
                    return rf;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception (log it, throw it, etc.)
        }
        return null;
    }

//    public void updateQuotation(String id, String price1, String price2, String time
//    //           , String styleID, String houseTypeID, String serviceID
//    ) {
////    String sql = "UPDATE Quotation SET Price1 = ?, Price2 = ?, [Time] = ?, StyleID = ?, HouseTypeID = ?, ServiceID = ? WHERE QuotationID = ?";
//        String sql = "UPDATE Quotation SET Price1 = ?, Price2 = ?, [Time] = ? WHERE QuotationID = ?";
//
//        try (Connection conn = db.getConn();
//                PreparedStatement ps = conn.prepareStatement(sql)) {
//
//            ps.setDouble(1, Double.parseDouble(price1));
//            ps.setDouble(2, Double.parseDouble(price2));
//            ps.setInt(3, Integer.parseInt(time));
////        ps.setInt(4, Integer.parseInt(styleID));
////        ps.setInt(5, Integer.parseInt(houseTypeID));
////        ps.setInt(6, Integer.parseInt(serviceID));
//            ps.setInt(4, Integer.parseInt(id));
//            ps.executeUpdate();
//
//        } catch (SQLException | NumberFormatException e) {
//            e.printStackTrace();
//        }
//    }
    public boolean updateQuotation(String id, String price1, String price2, String time) {
        String sql = "UPDATE Quotation SET Price1 = ?, Price2 = ?, [Time] = ? WHERE QuotationID = ?";

        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, Double.parseDouble(price1));
            ps.setDouble(2, Double.parseDouble(price2));
            ps.setInt(3, Integer.parseInt(time));
            ps.setInt(4, Integer.parseInt(id));

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean createQuotation(double price1, double price2, int time, int styleID, int houseTypeID, int serviceID) {
        String sql = "INSERT INTO Quotation (Price1, Price2, [Time], StyleID, HouseTypeID, ServiceID)\n"
                + "VALUES (?, ?, ?, ?, ?, ?);";

        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, price1);
            ps.setDouble(2, price2);
            ps.setInt(3, time);
            ps.setInt(4, styleID);
            ps.setInt(5, houseTypeID);
            ps.setInt(6, serviceID);

            int rowsAffected = ps.executeUpdate();

            // Kiểm tra xem ít nhất một dòng có được ảnh hưởng hay không
            return rowsAffected > 0;
        } catch (SQLException e) {
            // Ghi log hoặc xử lý ngoại lệ theo cách cần thiết
            e.printStackTrace();
            return false;
        }
    }

//    public boolean createQuotation(double price1, double price2, int houseTypeID, int serviceID, int styleID, int time) {
//    Connection conn = null;
//
//    try {
//        conn = db.getConn();
//
//        // Kiểm tra xem dữ liệu đã tồn tại chưa
//        if (!quotationExists(conn, houseTypeID, serviceID, styleID)) {
//            // Nếu chưa tồn tại, thực hiện câu truy vấn INSERT
//            String sql = "INSERT INTO Quotation (Price1, Price2, HouseTypeID, ServiceID, StyleID, Time) " +
//                    "VALUES (?, ?, ?, ?, ?, ?)";
//
//            try (PreparedStatement ps = conn.prepareStatement(sql)) {
//
//                ps.setDouble(1, price1);
//                ps.setDouble(2, price2);
//                ps.setInt(3, houseTypeID);
//                ps.setInt(4, serviceID);
//                ps.setInt(5, styleID);
//                ps.setInt(6, time);
//
//                int rowsAffected = ps.executeUpdate();
//
//                return rowsAffected > 0;
//            }
//        }
//
//        return false;
//    } catch (SQLException e) {
//        e.printStackTrace();
//        return false;
//    } finally {
//        try {
//            if (conn != null && !conn.isClosed()) {
//                conn.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//private boolean quotationExists(Connection conn, int houseTypeID, int serviceID, int styleID) {
//    // Kiểm tra xem dữ liệu đã tồn tại hay không
//    String checkSql = "SELECT 1 FROM Quotation WHERE HouseTypeID = ? AND ServiceID = ? AND StyleID = ?";
//
//    try (PreparedStatement ps = conn.prepareStatement(checkSql)) {
//        ps.setInt(1, houseTypeID);
//        ps.setInt(2, serviceID);
//        ps.setInt(3, styleID);
//
//        try (ResultSet rs = ps.executeQuery()) {
//            return rs.next(); // Nếu có dòng dữ liệu, tức là đã tồn tại
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//        return false;
//    }
//}
    public List<HouseComponent> getHouseComponent(int houseTypeId) {
        List<HouseComponent> list = new ArrayList<>();
        String sql = "Select * from HouseType ht join  HouseComponent hc on ht.HouseTypeID = hc.HouseTypeID\n"
                + "join Component c on c.ComponentID = hc.ComponentID\n"
                + "where ht.HouseTypeID = ? \n"
                + "ORDER BY c.ComponentID ASC";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, houseTypeId);
            rs = ps.executeQuery();
            while (rs.next()) {
                HouseComponent c = new HouseComponent();
                c.setId(rs.getInt("HouseComponentID"));
                c.setComponentId(rs.getInt("ComponentID"));
                c.setHouseTypeId(rs.getInt("HouseTypeID"));
                c.setComponent(rs.getString("Component"));
                c.setHouseType(rs.getString("HouseTypeName"));
                list.add(c);
            }
            return list;
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    public List<RoofNFoundation2> getFoundation() {
        List<RoofNFoundation2> list = new ArrayList<>();
        String sql = "select rf.RoofNFoundationID, rf.Name as RoofNFoundationName, rf.AreaPercent, rf.ComponentCategoryID, cc.Name as CategoryName\n"
                + "  from RoofNFoundation rf join ComponentCategory cc on rf.ComponentCategoryID = cc.ComponentCategoryID\n"
                + "  where rf.ComponentCategoryID = 1";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                RoofNFoundation2 c = new RoofNFoundation2();
                c.setRoofNFoundationId(rs.getInt("RoofNFoundationID"));
                c.setRoofNFoundationName(rs.getString("RoofNFoundationName"));
                c.setAreaPercent(rs.getInt("AreaPercent"));
                c.setComponentCategoryID(rs.getInt("ComponentCategoryID"));
                c.setCategoryName(rs.getString("CategoryName"));
                list.add(c);
            }
            return list;
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    public List<RoofNFoundation2> getRoof() {
        List<RoofNFoundation2> list = new ArrayList<>();
        String sql = "select rf.RoofNFoundationID, rf.Name as RoofNFoundationName, rf.AreaPercent, rf.ComponentCategoryID, cc.Name as CategoryName\n"
                + "  from RoofNFoundation rf join ComponentCategory cc on rf.ComponentCategoryID = cc.ComponentCategoryID\n"
                + "  where rf.ComponentCategoryID = 2";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                RoofNFoundation2 c = new RoofNFoundation2();
                c.setRoofNFoundationId(rs.getInt("RoofNFoundationID"));
                c.setRoofNFoundationName(rs.getString("RoofNFoundationName"));
                c.setAreaPercent(rs.getInt("AreaPercent"));
                c.setComponentCategoryID(rs.getInt("ComponentCategoryID"));
                c.setCategoryName(rs.getString("CategoryName"));
                list.add(c);
            }
            return list;
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    public boolean createCustomerQuotation(String cusQuoName, int quotationId, int userId) {
        String sql = "INSERT INTO CustomerQuotation (CusQuoName, CusQuoStatus, QuotationID, UsersID)\n"
                + "VALUES (?,1,?,?);";

        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cusQuoName);
            ps.setInt(2, quotationId);
            ps.setInt(3, userId);

            int rowsAffected = ps.executeUpdate();

            // Kiểm tra xem ít nhất một dòng có được ảnh hưởng hay không
            return rowsAffected > 0;
        } catch (SQLException e) {
            // Ghi log hoặc xử lý ngoại lệ theo cách cần thiết
            e.printStackTrace();
            return false;
        }
    }

    public boolean createCusQuoVersion(double price, double totalPrice, int foundationId, int roofId, int cusQuoId, String note) {
        String sql = "INSERT INTO CusQuoVersion ([Date], Price, TotalPrice, FoundationID, RoofID, CusQuoVersionStatus, CusQuoID, CusRequest, AdminReponse, Note)\n"
                + "VALUES (GETDATE(),?,?,?,?,1,?,?,?,?);";

        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, price);
            ps.setDouble(2, totalPrice);
            ps.setInt(3, foundationId);
            ps.setInt(4, roofId);
            ps.setInt(5, cusQuoId);
            ps.setInt(6, 0); // Thiết lập giá trị cho AdminReponse
            ps.setInt(7, 0); // Thiết lập giá trị cho CusRequest
            ps.setString(8, note);

            int rowsAffected = ps.executeUpdate();

            // Kiểm tra xem ít nhất một dòng có được ảnh hưởng hay không
            return rowsAffected > 0;
        } catch (SQLException e) {
            // Ghi log hoặc xử lý ngoại lệ theo cách cần thiết
            e.printStackTrace();
            return false;
        }

    }

    public boolean createAdminQuoVersion(double price, double totalPrice, int foundationId, int roofId, int versionID, int userId, String note) {
        String sql = "INSERT INTO AdminQuoVersion ([Date], Price, TotalPrice, FoundationID, RoofID, VersionID, Status, ConfirmStatus, UsersID, Note)\n"
                + "VALUES (GETDATE(),?,?,?,?,?,1,0,?,?);";

        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, price);
            ps.setDouble(2, totalPrice);
            ps.setInt(3, foundationId);
            ps.setInt(4, roofId);
            ps.setInt(5, versionID);
            ps.setInt(6, userId);
            ps.setString(7, note);

            int rowsAffected = ps.executeUpdate();

            // Kiểm tra xem ít nhất một dòng có được ảnh hưởng hay không
            return rowsAffected > 0;
        } catch (SQLException e) {
            // Ghi log hoặc xử lý ngoại lệ theo cách cần thiết
            e.printStackTrace();
            return false;
        }
    }

    public boolean sendCusRequestQuoVersion(double price, double totalPrice, int foundationId, int roofId, int cusQuoId, String note) {
        String sql = "INSERT INTO CusQuoVersion ([Date], Price, TotalPrice, FoundationID, RoofID, CusQuoVersionStatus, CusQuoID, CusRequest,AdminReponse, Note)\n"
                + "VALUES (GETDATE(),?,?,?,?,1,?,1,0,?);";

        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, price);
            ps.setDouble(2, totalPrice);
            ps.setInt(3, foundationId);
            ps.setInt(4, roofId);
            ps.setInt(5, cusQuoId);
            ps.setString(6, note);

            int rowsAffected = ps.executeUpdate();

            // Kiểm tra xem ít nhất một dòng có được ảnh hưởng hay không
            return rowsAffected > 0;
        } catch (SQLException e) {
            // Ghi log hoặc xử lý ngoại lệ theo cách cần thiết
            e.printStackTrace();
            return false;
        }
    }

    public boolean createCustomerHouseComponent(double value, int versionID, int componentID) {
        String sql = "INSERT INTO CustomerHouseComponent ([Value], VersionID, ComponentID)\n"
                + "VALUES (?,?,?);";

        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, value);
            ps.setInt(2, versionID);
            ps.setInt(3, componentID);

            int rowsAffected = ps.executeUpdate();

            // Kiểm tra xem ít nhất một dòng có được ảnh hưởng hay không
            return rowsAffected > 0;
        } catch (SQLException e) {
            // Ghi log hoặc xử lý ngoại lệ theo cách cần thiết
            e.printStackTrace();
            return false;
        }
    }

    public int getCusQuoId() {
        String sql = "SELECT COUNT(*) AS TotalCustomerQuotation\n"
                + "FROM [HouseSystem].[dbo].[CustomerQuotation];";
        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            // Đọc kết quả từ ResultSet
            if (rs.next()) {
                int totalCustomerQuotation = rs.getInt("TotalCustomerQuotation");
                return totalCustomerQuotation;
            } else {
                // Trường hợp không có kết quả
                return 0;
            }
        } catch (SQLException e) {
            // Ghi log hoặc xử lý ngoại lệ theo cách cần thiết
            e.printStackTrace();
            return -1; // Trả về một giá trị không hợp lệ để biểu thị lỗi
        }
    }

    public int getVersionId() {
        String sql = "SELECT COUNT(*) AS TotalQuoVersion\n"
                + "FROM [HouseSystem].[dbo].[CusQuoVersion];";
        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            // Đọc kết quả từ ResultSet
            if (rs.next()) {
                int totalQuoVersion = rs.getInt("TotalQuoVersion");
                return totalQuoVersion;
            } else {
                // Trường hợp không có kết quả
                return 0;
            }
        } catch (SQLException e) {
            // Ghi log hoặc xử lý ngoại lệ theo cách cần thiết
            e.printStackTrace();
            return -1; // Trả về một giá trị không hợp lệ để biểu thị lỗi
        }
    }

    public List<CustomerQuotation> getListCustomerQuotation(int userId) {
        List<CustomerQuotation> list = new ArrayList<>();
        String sql = "select * from CustomerQuotation where UsersID = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                CustomerQuotation c = new CustomerQuotation();
                c.setCusQuoId(rs.getInt("CusQuoID"));
                c.setCusQuoName(rs.getString("CusQuoName"));
                c.setCusQuoStatus(rs.getBoolean("CusQuoStatus"));
                c.setQuotationId(rs.getInt("QuotationID"));
                list.add(c);
            }
            return list;
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    public List<QuotationVersion> getListQuotationVersion(int cusQuoId) {
        List<QuotationVersion> list = new ArrayList<>();
        String sql = "select * from CusQuoVersion where CusQuoID = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cusQuoId);
            rs = ps.executeQuery();
            while (rs.next()) {
                QuotationVersion c = new QuotationVersion();
                c.setVersionId(rs.getInt("VersionID"));
                c.setDate(rs.getTimestamp("Date").toLocalDateTime());
                c.setPrice(rs.getDouble("Price"));
                c.setTotalPrice(rs.getDouble("TotalPrice"));
                c.setRoofId(rs.getInt("RoofID"));
                c.setFoundationId(rs.getInt("FoundationID"));
                c.setQuotationVersionStatus(rs.getBoolean("CusQuoVersionStatus"));
                c.setCusQuoId(rs.getInt("CusQuoID"));
                c.setCusRequest(rs.getBoolean("CusRequest"));
                c.setNote(rs.getString("Note"));
                list.add(c);
            }
            return list;
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    public List<CustomerHouseComponent> getListCustomerHouseComponentByVersionId(int versionId) {
        List<CustomerHouseComponent> list = new ArrayList<>();
        String sql = "Select * from CustomerHouseComponent chc join Component c on chc.ComponentID = c.ComponentID\n"
                + "  where VersionID = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, versionId);
            rs = ps.executeQuery();
            while (rs.next()) {
                CustomerHouseComponent c = new CustomerHouseComponent();
                c.setCustomerHouseComponentID(rs.getInt("CustomerHouseComponentID"));
                c.setValue(rs.getDouble("Value"));
                c.setVersionId(rs.getInt("VersionID"));
                c.setComponentId(rs.getInt("ComponentID"));
                c.setComponentName(rs.getString("Component"));
                list.add(c);
            }
            return list;
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    public QuotationVersion getCusQuoVersionById(int versionId) {
        QuotationVersion quotation = new QuotationVersion();
        String sql = "select * from CusQuoVersion where VersionID = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, versionId);
            rs = ps.executeQuery();
            if (rs.next()) {
                quotation.setVersionId(rs.getInt("VersionID"));
                quotation.setDate(rs.getTimestamp("Date").toLocalDateTime());
                quotation.setPrice(rs.getDouble("Price"));
                quotation.setTotalPrice(rs.getDouble("TotalPrice"));
                quotation.setRoofId(rs.getInt("RoofID"));
                quotation.setFoundationId(rs.getInt("FoundationID"));
                quotation.setQuotationVersionStatus(rs.getBoolean("CusQuoVersionStatus"));
                quotation.setCusQuoId(rs.getInt("CusQuoID"));
                quotation.setCusRequest(rs.getBoolean("CusRequest"));
                quotation.setNote(rs.getString("Note"));
            }
            return quotation;
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    public boolean updateCustomerQuotationStatus(int cusQuoStatus, int cusQuoId) {
        String sql = "UPDATE CustomerQuotation SET CusQuoStatus = ? WHERE CusQuoID = ?";

        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, cusQuoStatus);
            ps.setInt(2, cusQuoId);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean updateCustomerQuotationVersionStatus(int versionStatus, int versionId) {
        String sql = "UPDATE CusQuoVersion SET CusQuoVersionStatus = ? WHERE VersionID = ?";

        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, versionStatus);
            ps.setInt(2, versionId);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean updateCusRequest(int status, int versionId) {
        String sql = "UPDATE CusQuoVersion SET CusRequest = ? WHERE VersionID = ?";

        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, status);
            ps.setInt(2, versionId);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean createAdminHouseComponent(double value, int versionId, int componentID) {
        String sql = "INSERT INTO AdminHouseComponent ([Value], AdminQuoVersionID, ComponentID)\n"
                + "VALUES (?,?,?);";

        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, value);
            ps.setInt(2, versionId);
            ps.setInt(3, componentID);

            int rowsAffected = ps.executeUpdate();

            // Kiểm tra xem ít nhất một dòng có được ảnh hưởng hay không
            return rowsAffected > 0;
        } catch (SQLException e) {
            // Ghi log hoặc xử lý ngoại lệ theo cách cần thiết
            e.printStackTrace();
            return false;
        }
    }

    public List<AdminQuoVersion> getListAdminQuoVersion(int userId) {
        List<AdminQuoVersion> list = new ArrayList<>();
        String sql = "select * from AdminQuoVersion where UsersID = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                AdminQuoVersion c = new AdminQuoVersion();
                c.setAdminQuoVersionId(rs.getInt("AdminQuoVersionID"));
                c.setDate(rs.getTimestamp("Date").toLocalDateTime());
                c.setPrice(rs.getDouble("Price"));
                c.setTotalPrice(rs.getDouble("TotalPrice"));
                c.setRoofId(rs.getInt("RoofID"));
                c.setFoundationId(rs.getInt("FoundationID"));
                c.setVersionId(rs.getInt("VersionID"));
                c.setStatus(rs.getBoolean("Status"));
                c.setConfirmStatus(rs.getBoolean("ConfirmStatus"));
                c.setUserId(rs.getInt("UsersID"));
                c.setNote(rs.getString("Note"));
                list.add(c);
            }
            return list;
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    public int getUserIdByVersionId(int versionId) {
        String sql = "SELECT * FROM CusQuoVersion cqv join CustomerQuotation cq on cq.CusQuoID = cqv.CusQuoID\n"
                + "where cqv.VersionID = ?";
        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, versionId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int userId = rs.getInt("UsersID");
                return userId;
            } else {
                // Trường hợp không có kết quả
                return 0;
            }
        } catch (SQLException e) {
            // Ghi log hoặc xử lý ngoại lệ theo cách cần thiết
            e.printStackTrace();
            return -1;
        }
    }

    public int getQuotationIdByVersionId(int versionId) {
        String sql = "SELECT * FROM CusQuoVersion cqv join CustomerQuotation cq on cq.CusQuoID = cqv.CusQuoID\n"
                + "where cqv.VersionID = ?";
        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, versionId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int quotationId = rs.getInt("QuotationID");
                return quotationId;
            } else {
                // Trường hợp không có kết quả
                return 0;
            }
        } catch (SQLException e) {
            // Ghi log hoặc xử lý ngoại lệ theo cách cần thiết
            e.printStackTrace();
            return -1;
        }
    }

    public double getCusQuoVersionPriceByVersionId(int versionId) {
        String sql = "SELECT * FROM CusQuoVersion cqv join CustomerQuotation cq on cq.CusQuoID = cqv.CusQuoID\n"
                + "where cqv.VersionID = ?";
        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, versionId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int quotationId = rs.getInt("Price");
                return quotationId;
            } else {
                // Trường hợp không có kết quả
                return 0;
            }
        } catch (SQLException e) {
            // Ghi log hoặc xử lý ngoại lệ theo cách cần thiết
            e.printStackTrace();
            return -1;
        }
    }

    public int getCusQuoIdByVersionId(int versionId) {
        String sql = "SELECT * FROM CusQuoVersion where VersionID =?";
        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, versionId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int cusQuoId = rs.getInt("CusQuoID");
                return cusQuoId;
            } else {
                // Trường hợp không có kết quả
                return 0;
            }
        } catch (SQLException e) {
            // Ghi log hoặc xử lý ngoại lệ theo cách cần thiết
            e.printStackTrace();
            return -1;
        }
    }

    public List<AdminHouseComponent> getListAdminHouseComponentByAdminQuoVersionID(int adminQuoVersionId) {
        List<AdminHouseComponent> list = new ArrayList<>();
        String sql = "Select * from AdminHouseComponent a join Component c on a.ComponentID = c.ComponentID\n"
                + "where a.AdminQuoVersionID  = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, adminQuoVersionId);
            rs = ps.executeQuery();
            while (rs.next()) {
                AdminHouseComponent c = new AdminHouseComponent();
                c.setAdminHouseComponentId(rs.getInt("AdminHouseComponentID"));
                c.setValue(rs.getDouble("Value"));
                c.setAdminQuoVersionId(rs.getInt("AdminQuoVersionID"));
                c.setComponentId(rs.getInt("ComponentID"));
                c.setComponentName(rs.getString("Component"));
                list.add(c);
            }
            return list;
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    public AdminQuoVersion getAdminQuoVersionById(int adminQuoVersionId) {
        AdminQuoVersion quotation = new AdminQuoVersion();
        String sql = "select * from AdminQuoVersion where AdminQuoVersionId = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, adminQuoVersionId);
            rs = ps.executeQuery();
            if (rs.next()) {
                quotation.setAdminQuoVersionId(rs.getInt("AdminQuoVersionID"));
                quotation.setDate(rs.getTimestamp("Date").toLocalDateTime());
                quotation.setPrice(rs.getDouble("Price"));
                quotation.setTotalPrice(rs.getDouble("TotalPrice"));
                quotation.setRoofId(rs.getInt("RoofID"));
                quotation.setFoundationId(rs.getInt("FoundationID"));
                quotation.setVersionId(rs.getInt("VersionID"));
                quotation.setStatus(rs.getBoolean("Status"));
                quotation.setConfirmStatus(rs.getBoolean("ConfirmStatus"));
                quotation.setUserId(rs.getInt("UsersID"));
                quotation.setNote(rs.getString("Note"));
            }
            return quotation;
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    public boolean changeConfirmStatusAdminQuoVersion(int status, int adminQuoVersionId) {
        String sql = "UPDATE AdminQuoVersion SET ConfirmStatus = ? WHERE AdminQuoVersionID = ?";

        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, status);
            ps.setInt(2, adminQuoVersionId);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean changeAdminReponseStatus(int status, int versionId) {
        String sql = "UPDATE CusQuoVersion SET AdminReponse = ? WHERE VersionID = ?";

        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, status);
            ps.setInt(2, versionId);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) {
        QuotationDAO dao = new QuotationDAO();
        double price = 100.0;
        double totalPrice = 150.0;
        int foundationId = 1;
        int roofId = 2;
        int cusQuoId = 3;
        String note = "This is a test note 1.";

        // Thực hiện gọi phương thức createCusQuoVersion
        boolean result = dao.createCusQuoVersion(price, totalPrice, foundationId, roofId, cusQuoId, note);

        // Kiểm tra kết quả
        if (result) {
            System.out.println("Customer Quotation Version created successfully.");
        } else {
            System.out.println("Failed to create Customer Quotation Version.");
        }
    }

}
