/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.HouseType;
import DTO.Service;
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
public class HouseTypeDAO {

    private DBContext db;

    public HouseTypeDAO() {
        db = new DBContext();
    }

    public HouseTypeDAO(DBContext db) {
        this.db = db;
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    public List<HouseType> getAll() {
        List<HouseType> list = new ArrayList<>();
        String sql = " SELECT * FROM HouseType";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HouseType c = new HouseType(rs.getInt(1), rs.getString(2));
                list.add(c);
            }
            return list;
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HouseTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HouseTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HouseTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    public boolean addHouseStyle(String name) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1. Connect DB
            con = db.getConn();
            if (con != null) {
                String sql = "INSERT INTO [HouseType](HouseTypeName)VALUES (?)";
                //3. Create Statement Object
                stm = con.prepareStatement(sql); //Nạp tham số 1 lần cho Statement
                stm.setString(1, name);
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
        System.out.println(result);
        return result;

    }
    public boolean deleteHouseStyle(int houseStyleID) {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = db.getConn();
            if (con != null) {
                String sql = "DELETE FROM [HouseType] WHERE HouseTypeID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, houseStyleID);
                int effectRow = stm.executeUpdate();
                if (effectRow > 0) {
                    result = true;
                } else {
                    result = false;
                }
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ khi câu lệnh SQL chạy lỗi
            e.printStackTrace(); // hoặc ghi log
            result = false;
        } finally {
            // Đảm bảo đóng các tài nguyên
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    ex.printStackTrace(); // hoặc ghi log
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace(); // hoặc ghi log
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws SQLException {
        HouseTypeDAO dao = new HouseTypeDAO();
//        System.out.println(dao.getAll());
//        dao.addHouseStyle("huy");
dao.deleteHouseStyle(11);
    }

}
