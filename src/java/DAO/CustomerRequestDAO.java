/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.CustomerRequest;
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
public class CustomerRequestDAO {

    private DBContext db;

    public CustomerRequestDAO() {
        db = new DBContext();
    }

    public CustomerRequestDAO(DBContext db) {
        this.db = db;
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    public List<CustomerRequest> getAll() {
        List<CustomerRequest> list = new ArrayList<>();
        String sql = "SELECT \n"
                + "    u.[Name] AS UserName,\n"
                + "    cq.CusQuoName,\n"
                + "    u.Phone,\n"
                + "    cv.Price,\n"
                + "    cv.TotalPrice,\n"
                + "    cv.[Date],\n"
                + "	cv.VersionID,\n"
                + "	cv.CusQuoID,\n"
                + "    cq.QuotationID\n"
                + "\n"
                + "FROM \n"
                + "    Users u\n"
                + "JOIN \n"
                + "    CustomerQuotation cq ON u.UsersID = cq.UsersID\n"
                + "JOIN \n"
                + "    CusQuoVersion cv ON cq.CusQuoID = cv.CusQuoID\n"
                + "where CusRequest = 'true'";

        try (Connection conn = db.getConn();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                CustomerRequest p = new CustomerRequest();

                p.setVersionid(rs.getInt("VersionID"));
                p.setCustomer(rs.getString("UserName"));
                p.setPhone(rs.getString("Phone"));
                p.setQuotationname(rs.getString("CusQuoName"));
                p.setPrice(rs.getDouble("Price"));
                p.setTotalPrice(rs.getDouble("TotalPrice"));
                p.setTime(rs.getTimestamp("Date").toLocalDateTime());
                p.setCusQuoId(rs.getInt("CusQuoID"));
                p.setQuotationId(rs.getInt("QuotationID"));

                list.add(p);
            }
        } catch (SQLException e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return list;
    }

    public static void main(String[] args) {
        CustomerRequestDAO dao = new CustomerRequestDAO();
        System.out.println(dao.getAll());
    }

}
