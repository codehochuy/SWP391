/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author PC
 */
public class CustomerQuotation {
    private int cusQuoId;
    private String cusQuoName;
    private boolean cusQuoStatus;
    private int quotationId;

    public CustomerQuotation() {
    }

    public CustomerQuotation(int cusQuoId, String cusQuoName, boolean cusQuoStatus, int quotationId) {
        this.cusQuoId = cusQuoId;
        this.cusQuoName = cusQuoName;
        this.cusQuoStatus = cusQuoStatus;
        this.quotationId = quotationId;
    }

    public int getCusQuoId() {
        return cusQuoId;
    }

    public void setCusQuoId(int cusQuoId) {
        this.cusQuoId = cusQuoId;
    }

    public String getCusQuoName() {
        return cusQuoName;
    }

    public void setCusQuoName(String cusQuoName) {
        this.cusQuoName = cusQuoName;
    }

    public boolean isCusQuoStatus() {
        return cusQuoStatus;
    }

    public void setCusQuoStatus(boolean cusQuoStatus) {
        this.cusQuoStatus = cusQuoStatus;
    }

    public int getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(int quotationId) {
        this.quotationId = quotationId;
    }
    
    
}
