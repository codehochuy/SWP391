/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Component;
import DTO.HouseComponent;
import DTO.HouseComponent2;
import DTO.HouseType;
import Utils.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<HouseComponent2> getHousecomponentbyhousetypeid(int id) throws SQLException {
    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    List<HouseComponent2> houseComponents = new ArrayList<>();
    try {
        con = db.getConn();
        if (con != null) {
            String sql = "SELECT hc.HouseComponentID,ht.HouseTypeID,ht.HouseTypeName, c.ComponentID,c.Component\n"
                    + "FROM HouseComponent hc\n"
                    + "JOIN HouseType ht ON hc.HouseTypeID = ht.HouseTypeID\n"
                    + "JOIN Component c ON hc.ComponentID = c.ComponentID\n"
                    + "WHERE hc.HouseTypeID =?;";
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                HouseComponent2 style = new HouseComponent2(rs.getInt("HouseComponentID"),
                        new HouseType(rs.getInt("HouseTypeID"), rs.getString("HouseTypeName")),
                        new Component(rs.getInt("ComponentID"), rs.getString("Component")));
                houseComponents.add(style);
            }
        }
    } finally {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (con != null) {
            con.close();
        }
    }
    return houseComponents;
}


    public static void main(String[] args) throws SQLException {
        HouseComponentDAO dao = new HouseComponentDAO();
//        System.out.println(dao.createHouseComponent(4, 1));
        System.out.println(dao.getHousecomponentbyhousetypeid(1));
    }

}
