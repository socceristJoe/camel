package com.joepoccamel.camelmicroserviceb.bean;

public class HairProductsCore {
    private Long id;
    private String brand;
    private String sku;

    public HairProductsCore() {
    }

    @Override
    public String toString() {
        return "HairProductsCore{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", sku='" + sku + '\'' +
                '}';
    }

    public HairProductsCore(Long id, String brand, String sku) {
        this.id = id;
        this.brand = brand;
        this.sku = sku;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
