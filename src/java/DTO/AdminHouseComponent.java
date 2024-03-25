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
public class AdminHouseComponent {
    private int adminHouseComponentId;
    private double value;
    private int adminQuoVersionId;
    private int componentId;
    private String componentName;

    public AdminHouseComponent() {
    }

    public AdminHouseComponent(int adminHouseComponentId, double value, int adminQuoVersionId, int componentId, String componentName) {
        this.adminHouseComponentId = adminHouseComponentId;
        this.value = value;
        this.adminQuoVersionId = adminQuoVersionId;
        this.componentId = componentId;
        this.componentName = componentName;
    }

    public int getAdminHouseComponentId() {
        return adminHouseComponentId;
    }

    public void setAdminHouseComponentId(int adminHouseComponentId) {
        this.adminHouseComponentId = adminHouseComponentId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getAdminQuoVersionId() {
        return adminQuoVersionId;
    }

    public void setAdminQuoVersionId(int adminQuoVersionId) {
        this.adminQuoVersionId = adminQuoVersionId;
    }

    public int getComponentId() {
        return componentId;
    }

    public void setComponentId(int componentId) {
        this.componentId = componentId;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    
}
