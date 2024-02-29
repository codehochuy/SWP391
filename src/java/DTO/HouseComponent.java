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
public class HouseComponent {
    private int id;
    private HouseType houseType;
    private Component component;
    private RoofNFoundation rnf;

    public HouseComponent() {
    }

    
    public HouseComponent(int id, HouseType houseType, Component component, RoofNFoundation rnf) {
        this.id = id;
        this.houseType = houseType;
        this.component = component;
        this.rnf = rnf;
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

    public RoofNFoundation getRnf() {
        return rnf;
    }

    public void setRnf(RoofNFoundation rnf) {
        this.rnf = rnf;
    }

    @Override
    public String toString() {
        return "HouseComponent{" + "id=" + id + ", houseType=" + houseType + ", component=" + component + ", rnf=" + rnf + '}';
    }
    
    
    
    
    
}
