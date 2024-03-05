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
public class CustomerHouseComponent {
    private int customerHouseComponentID;
    private double value;
    private int versionId;
    private int componentId;
    private String componentName;

    public CustomerHouseComponent() {
    }

    public CustomerHouseComponent(int customerHouseComponentID, double value, int versionId, int componentId, String componentName) {
        this.customerHouseComponentID = customerHouseComponentID;
        this.value = value;
        this.versionId = versionId;
        this.componentId = componentId;
        this.componentName = componentName;
    }

    public int getCustomerHouseComponentID() {
        return customerHouseComponentID;
    }

    public void setCustomerHouseComponentID(int customerHouseComponentID) {
        this.customerHouseComponentID = customerHouseComponentID;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
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
