package com.slib.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;

public class Product {
    @Id
    private Long id;
    private String name;
    private double price;
    @JsonProperty("stock_count")
    private int stockCount;

    public Product() {
        super();
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
