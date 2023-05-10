/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Product {

    private int id;
    private double price;
    private String name;
    private String description;
    private String image;
    private int cateID;
    private int sellID;

    public Product() {
    }

    public Product(int id, double price, String name, String description, String image, int cateID) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.description = description;
        this.image = image;
        this.cateID = cateID;
    }

    
    
    public Product(int id, double price, String name, String description, String image, int cateID, int sellID) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.description = description;
        this.image = image;
        this.cateID = cateID;
        this.sellID = sellID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }

    public int getSellID() {
        return sellID;
    }

    public void setSellID(int sellID) {
        this.sellID = sellID;
    }
    
    
    
}
