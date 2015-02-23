/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.soa.rest.sparkcommerce;

import com.google.gson.Gson;
import java.math.BigDecimal;

/**
 *
 * @author alex
 */
public class Item {

    private String name;
    private BigDecimal price;
    private Integer quantity;
    private Boolean imported;
    private String kind;
    private boolean taxed = false;
    private BigDecimal taxes;

    public Item() {
        
    }
    
    public Item(String name, BigDecimal price, Integer quantity, Boolean imported, String kind) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imported = imported;
        this.kind = kind;
    }




    public BigDecimal calculateCart() {
        return new BigDecimal(12.45);
    }
    
    public Boolean shippingAvaiability() {
        return Math.random() > 0.5;
    }
    
    public Boolean closeShippingInfo() {
        return true;
    }
    
    public BigDecimal calculateFinalShippingCost() {
        return new BigDecimal(15.50);
    }
    
    public Boolean makeBill() {
        return true;
    }
    
    public Request makeRequest() {
        return new Request("P123", "Pedido de teste", new BigDecimal(15.50));
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @param imported the imported to set
     */
    public void setImported(Boolean imported) {
        this.imported = imported;
    }

    public Boolean isImported() {
        return this.imported;
    }

    public String getKind() {
        return this.kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public boolean isTaxed() {
        return this.taxed;
    }

    public BigDecimal getTaxes() {
        return this.taxes;
    }

    public void setTaxes(BigDecimal taxes) {
        this.taxes = taxes;
    }
}
