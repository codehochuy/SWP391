/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.HouseComponent;
import DTO.HouseType;
import DTO.Quotation;
import DTO.RoofNFoundation2;
import DTO.Service;
import DTO.Style;
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
                + "FROM RoofNFoundation2 rf \n"
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
                + "where ht.HouseTypeID = ?";
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

    public static void main(String[] args) {
        System.setProperty("file.encoding", "UTF-8");
        QuotationDAO dao = new QuotationDAO();
        List<RoofNFoundation2> list = dao.getFoundation();
        for (RoofNFoundation2 roofNFoundation : list) {
            System.out.println(roofNFoundation.getRoofNFoundationName() + ": " + roofNFoundation.getAreaPercent());
        }
    }

    public boolean checkFloor(int selectedHouseType) {
        QuotationDAO dao = new QuotationDAO();
        boolean check = false;
        List<HouseComponent> list = dao.getHouseComponent(selectedHouseType);
        for (HouseComponent houseComponent : list) {
            if (houseComponent.getId() == 5){
                check = true;
                break;
            }
        }
        return check;
    }

}
