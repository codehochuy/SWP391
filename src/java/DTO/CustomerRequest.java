/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.time.LocalDateTime;

/**
 *
 * @author ACER
 */
public class CustomerRequest {
    private int versionid;
    private String customer;
    private String quotationname;
    private String phone;
    private double price;
    private LocalDateTime time;
    private int cusQuoId;
    private int quotationId;

    public CustomerRequest() {
    }

    public CustomerRequest(int versionid, String customer, String quotationname, String phone, double price, LocalDateTime time, int cusQuoId, int quotationId) {
        this.versionid = versionid;
        this.customer = customer;
        this.quotationname = quotationname;
        this.phone = phone;
        this.price = price;
        this.time = time;
        this.cusQuoId = cusQuoId;
        this.quotationId = quotationId;
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

    @Override
    public String toString() {
        return "CustomerRequest{" + "versionid=" + versionid + ", customer=" + customer + ", quotationname=" + quotationname + ", phone=" + phone + ", price=" + price + ", time=" + time + ", cusQuoId=" + cusQuoId + ", quotationId=" + quotationId + '}';
    }

    

    
    
    
}
