/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utils.DBContext;

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
    
}
