/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author ACER
 */
public class HouseComponent2 {
    private int id;
    private HouseType houseType;
    private Component component;

    public HouseComponent2() {
    }

    
    public HouseComponent2(int id, HouseType houseType, Component component) {
        this.id = id;
        this.houseType = houseType;
        this.component = component;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HouseType getHouseType() {
        return houseType;
    }

    public void setHouseType(HouseType houseType) {
        this.houseType = houseType;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    public String toString() {
        return "HouseComponent2{" + "id=" + id + ", houseType=" + houseType + ", component=" + component + '}';
    }
    
    
    
    
    
}
