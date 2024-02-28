package DAO;

import Utils.DBContext;
import DTO.RoofNFoundation;
import DTO.ComponentCategory;
import DTO.Role;
import DTO.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RoofNFoundationDAO {

    private DBContext db;

    public RoofNFoundationDAO() {
        db = new DBContext();
    }

    public RoofNFoundationDAO(DBContext db) {
        this.db = db;
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    public List<RoofNFoundation> getAll() {
        List<RoofNFoundation> list = new ArrayList<>();
        String sql = "SELECT e.*, r.ComponentCategoryName\n"
                + "FROM RoofNFoundation e\n"
                + "JOIN ComponentCategory r ON e.ComponentCategoryID = r.ComponentCategoryID;";

        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                RoofNFoundation p = new RoofNFoundation();

                p.setId(rs.getInt("RoofNFoundationID"));
                p.setCategoryname(rs.getString("Name"));
                p.setAreaPercent(rs.getInt("AreaPercent"));
                p.setCategory(new ComponentCategory(rs.getInt("ComponentCategoryID"), rs.getString("ComponentCategoryName")));

                list.add(p);
            }
        } catch (SQLException e) {
            Logger.getLogger(RoofNFoundationDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return list;
    }
    public boolean deleteComponentCate(int styleID) {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = db.getConn();
            if (con != null) {
                String sql = "DELETE FROM [RoofNFoundation] WHERE RoofNFoundationID = ?";
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
    
    public static void main(String[] args) {
        RoofNFoundationDAO aO = new RoofNFoundationDAO();
        System.out.println(aO.getAll());
    }
}
