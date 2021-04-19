package com.joepoccamel.camelmicroservicea.bean;

public class HairProductsExtension {

    private Long id;
    private String bu;
    private String brand;
    private String sku;
    private Float price;
    private Float discount;
    private String Tier;
    private String Channel;

    public HairProductsExtension(Long id, String bu, String brand, String sku, Float price, Float discount, String tier, String channel) {
        this.id = id;
        this.bu = bu;
        this.brand = brand;
        this.sku = sku;
        this.price = price;
        this.discount = discount;
        Tier = tier;
        Channel = channel;
    }

    public HairProductsExtension() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBu() {
        return bu;
    }

    public void setBu(String bu) {
        this.bu = bu;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public String getTier() {
        return Tier;
    }

    public void setTier(String tier) {
        Tier = tier;
    }

    public String getChannel() {
        return Channel;
    }

    public void setChannel(String channel) {
        Channel = channel;
    }

    @Override
    public String toString() {
        return "HairProductsExtension{" +
                "id=" + id +
                ", bu='" + bu + '\'' +
                ", brand='" + brand + '\'' +
                ", sku='" + sku + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", Tier='" + Tier + '\'' +
                ", Channel='" + Channel + '\'' +
                '}';
    }
}
