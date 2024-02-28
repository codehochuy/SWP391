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
public class RoofNFoundation {
    private int id;
    private String name;
    private int areaPercent;
    private ComponentCategory category;

    public RoofNFoundation() {
    }

    public RoofNFoundation(int id, String name, int areaPercent, ComponentCategory category) {
        this.id = id;
        this.name = name;
        this.areaPercent = areaPercent;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAreaPercent() {
        return areaPercent;
    }

    public void setAreaPercent(int areaPercent) {
        this.areaPercent = areaPercent;
    }

    public ComponentCategory getCategory() {
        return category;
    }

    public void setCategory(ComponentCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "RoofNFoundation{" + "id=" + id + ", name=" + name + ", areaPercent=" + areaPercent + ", category=" + category + '}';
    }
    
    
    
}
