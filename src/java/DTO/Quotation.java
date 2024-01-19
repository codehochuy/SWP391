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
public class Quotation {
    
    private int id;
    private double price1;
    private double price2;
    private int time;
    private Style style;
    private HouseType houseType;
    private Service service;

    public Quotation() {
    }

    public Quotation(int id, double price1, double price2, int time, Style style, HouseType houseType, Service service) {
        this.id = id;
        this.price1 = price1;
        this.price2 = price2;
        this.time = time;
        this.style = style;
        this.houseType = houseType;
        this.service = service;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice1() {
        return price1;
    }

    public void setPrice1(double price1) {
        this.price1 = price1;
    }

    public double getPrice2() {
        return price2;
    }

    public void setPrice2(double price2) {
        this.price2 = price2;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public HouseType getHouseType() {
        return houseType;
    }

    public void setHouseType(HouseType houseType) {
        this.houseType = houseType;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "Quotation{" + "id=" + id + ", price1=" + price1 + ", price2=" + price2 + ", time=" + time + ", style=" + style + ", houseType=" + houseType + ", service=" + service + '}';
    }
    
    
            
    
}
