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
public class AdminQuoVersion {
    private int adminQuoVersionId;
    private LocalDateTime date;
    private Double price;
    private int roofId;
    private int foundationId;;
    private int versionId;
    private boolean status;
    private String note;

    public AdminQuoVersion() {
    }

    public AdminQuoVersion(int adminQuoVersionId, LocalDateTime date, Double price, int roofId, int foundationId, int versionId, boolean status, String note) {
        this.adminQuoVersionId = adminQuoVersionId;
        this.date = date;
        this.price = price;
        this.roofId = roofId;
        this.foundationId = foundationId;
        this.versionId = versionId;
        this.status = status;
        this.note = note;
    }

    public int getAdminQuoVersionId() {
        return adminQuoVersionId;
    }

    public void setAdminQuoVersionId(int adminQuoVersionId) {
        this.adminQuoVersionId = adminQuoVersionId;
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

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
}
