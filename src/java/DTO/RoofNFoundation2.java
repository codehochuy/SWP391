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
public class RoofNFoundation2 {
    private int roofNFoundationId;
    private String roofNFoundationName;
    private int areaPercent;
    private int componentCategoryID;
    private String categoryName;

    public RoofNFoundation2() {
    }

    public RoofNFoundation2(int roofNFoundationId, String roofNFoundationName, int areaPercent, int componentCategoryID, String categoryName) {
        this.roofNFoundationId = roofNFoundationId;
        this.roofNFoundationName = roofNFoundationName;
        this.areaPercent = areaPercent;
        this.componentCategoryID = componentCategoryID;
        this.categoryName = categoryName;
    }

    public int getRoofNFoundationId() {
        return roofNFoundationId;
    }

    public void setRoofNFoundationId(int roofNFoundationId) {
        this.roofNFoundationId = roofNFoundationId;
    }

    public String getRoofNFoundationName() {
        return roofNFoundationName;
    }

    public void setRoofNFoundationName(String roofNFoundationName) {
        this.roofNFoundationName = roofNFoundationName;
    }

    public int getAreaPercent() {
        return areaPercent;
    }

    public void setAreaPercent(int areaPercent) {
        this.areaPercent = areaPercent;
    }

    public int getComponentCategoryID() {
        return componentCategoryID;
    }

    public void setComponentCategoryID(int componentCategoryID) {
        this.componentCategoryID = componentCategoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "RoofNFoundation2{" + "roofNFoundationId=" + roofNFoundationId + ", roofNFoundationName=" + roofNFoundationName + ", areaPercent=" + areaPercent + ", componentCategoryID=" + componentCategoryID + ", categoryName=" + categoryName + '}';
    }
    
    

    
}
