/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class StyleDAO {

    private DBContext db;

    public StyleDAO() {
        db = new DBContext();
    }

    public StyleDAO(DBContext db) {
        this.db = db;
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    public List<Style> getAll() {
        List<Style> list = new ArrayList<>();
        String sql = " SELECT * FROM Style";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Style c = new Style(rs.getInt(1), rs.getString(2));
                list.add(c);
            }
            return list;
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StyleDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StyleDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StyleDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    public boolean addStyle(String name) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1. Connect DB
            con = db.getConn();
            if (con != null) {
                String sql = "INSERT INTO [Style](StyleName)VALUES (?)";
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

    public boolean deleteStyle(int styleID) {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = db.getConn();
            if (con != null) {
                String sql = "DELETE FROM [Style] WHERE StyleID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, styleID);
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

    public Style getStyleById(int styleID) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Style style = null;
        try {
            con = db.getConn();
            if (con != null) {
                String sql = "SELECT * FROM [Style] WHERE StyleID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, styleID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    style = new Style(rs.getInt("StyleID"), rs.getString("StyleName"));
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
        return style;
    }

    public boolean updateStyleName(String styleID, String newName) {
    Connection con = null;
    PreparedStatement stm = null;
    boolean result = false;
    try {
        con = db.getConn();
        if (con != null) {
            String sql = "UPDATE [Style] SET StyleName = ? WHERE StyleID = ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, newName);
            stm.setString(2, styleID);
            int effectRow = stm.executeUpdate();
            if (effectRow > 0) {
                result = true;
            }
        }
    } catch (SQLException e) {
        // Xử lý ngoại lệ SQL ở đây (nếu cần)
        e.printStackTrace(); // Hoặc ghi log, hiển thị thông báo lỗi, vv.
    } finally {
        if (stm != null) {
            try {
                stm.close();
            } catch (SQLException ex) {
                ex.printStackTrace(); // Hoặc ghi log, hiển thị thông báo lỗi, vv.
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace(); // Hoặc ghi log, hiển thị thông báo lỗi, vv.
            }
        }
        // Trả về false nếu có lỗi xảy ra
        if (!result) {
            return false;
        }
    }
    return result;
}

    public static void main(String[] args) throws SQLException {
        StyleDAO dao = new StyleDAO();
//        System.out.println(dao.getAll());
//        dao.addStyle("huy");
//        dao.deleteStyle(2);
//System.out.println(dao.getStyleById(1));
        dao.updateStyleName("2", "Hiện Đại");

    }

}
