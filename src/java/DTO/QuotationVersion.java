/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 *
 * @author PC
 */
public class QuotationVersion {
    private int versionId;
    private LocalDateTime date;
    private Double price;
    private Double totalPrice;
    private int roofId;
    private int foundationId;
    private boolean quotationVersionStatus;
    private int cusQuoId;
    private boolean cusRequest;
    private String note;

    public QuotationVersion() {
    }

    public QuotationVersion(int versionId, LocalDateTime date, Double price, Double totalPrice, int roofId, int foundationId, boolean quotationVersionStatus, int cusQuoId, boolean cusRequest, String note) {
        this.versionId = versionId;
        this.date = date;
        this.price = price;
        this.totalPrice = totalPrice;
        this.roofId = roofId;
        this.foundationId = foundationId;
        this.quotationVersionStatus = quotationVersionStatus;
        this.cusQuoId = cusQuoId;
        this.cusRequest = cusRequest;
        this.note = note;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
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

    public boolean isCusRequest() {
        return cusRequest;
    }

    public void setCusRequest(boolean cusRequest) {
        this.cusRequest = cusRequest;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    
}
