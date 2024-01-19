/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.HouseType;
import DTO.Quotation;
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


    public static void main(String[] args) {
        QuotationDAO dao = new QuotationDAO();
//        System.out.println(dao.getAll());
//        System.out.println(dao.deleteQuotation("12"));
//        System.out.println(dao.getQuotationID("3"));
        System.out.println(dao.updateQuotation("10", "5900000", "6000000", "8"));

    }

}
