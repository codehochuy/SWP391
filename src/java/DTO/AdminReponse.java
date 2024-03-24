/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.time.LocalDateTime;

/**
 *
 * @author PC
 */
public class AdminReponse {
    private int versionid;
    private String customer;
    private String quotationname;
    private String phone;
    private double price;
    private double totalPrice;
    private LocalDateTime time;
    private int cusQuoId;
    private int quotationId;
    private boolean adminReponse;
    private boolean confirmStatus;

    public AdminReponse() {
    }

    public AdminReponse(int versionid, String customer, String quotationname, String phone, double price, double totalPrice, LocalDateTime time, int cusQuoId, int quotationId, boolean adminReponse, boolean confirmStatus) {
        this.versionid = versionid;
        this.customer = customer;
        this.quotationname = quotationname;
        this.phone = phone;
        this.price = price;
        this.totalPrice = totalPrice;
        this.time = time;
        this.cusQuoId = cusQuoId;
        this.quotationId = quotationId;
        this.adminReponse = adminReponse;
        this.confirmStatus = confirmStatus;
    }

    public int getVersionid() {
        return versionid;
    }

    public void setVersionid(int versionid) {
        this.versionid = versionid;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getQuotationname() {
        return quotationname;
    }

    public void setQuotationname(String quotationname) {
        this.quotationname = quotationname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getCusQuoId() {
        return cusQuoId;
    }

    public void setCusQuoId(int cusQuoId) {
        this.cusQuoId = cusQuoId;
    }

    public int getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(int quotationId) {
        this.quotationId = quotationId;
    }

    public boolean isAdminReponse() {
        return adminReponse;
    }

    public void setAdminReponse(boolean adminReponse) {
        this.adminReponse = adminReponse;
    }

    public boolean isConfirmStatus() {
        return confirmStatus;
    }

    public void setConfirmStatus(boolean confirmStatus) {
        this.confirmStatus = confirmStatus;
    }
    
}
