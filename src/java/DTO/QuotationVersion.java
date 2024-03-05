/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author PC
 */
public class QuotationVersion {
    private int versionId;
    private Date date;
    private Double price;
    private int roofId;
    private int foundationId;
    private boolean quotationVersionStatus;
    private int cusQuoId;   

    public QuotationVersion() {
    }

    public QuotationVersion(int versionId, Date date, Double price, int roofId, int foundationId, boolean quotationVersionStatus, int cusQuoId) {
        this.versionId = versionId;
        this.date = date;
        this.price = price;
        this.roofId = roofId;
        this.foundationId = foundationId;
        this.quotationVersionStatus = quotationVersionStatus;
        this.cusQuoId = cusQuoId;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getRoofId() {
        return roofId;
    }

    public void setRoofId(int roofId) {
        this.roofId = roofId;
    }

    public int getFoundationId() {
        return foundationId;
    }

    public void setFoundationId(int foundationId) {
        this.foundationId = foundationId;
    }

    public boolean isQuotationVersionStatus() {
        return quotationVersionStatus;
    }

    public void setQuotationVersionStatus(boolean quotationVersionStatus) {
        this.quotationVersionStatus = quotationVersionStatus;
    }

    public int getCusQuoId() {
        return cusQuoId;
    }

    public void setCusQuoId(int cusQuoId) {
        this.cusQuoId = cusQuoId;
    }

    
     
}
