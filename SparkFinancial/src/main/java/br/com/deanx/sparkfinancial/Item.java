/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.deanx.sparkfinancial;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

    private Double calculateTaxesPercentage() {
        Double tax = 0.00;

        if (!isNotTaxed() && !isTaxed()) {
            tax += 0.1;
        }

        if (isImported() && !isTaxed()) {
            tax += 0.05;
        }

        return tax;
    }

     boolean isNotTaxed() {
        return kind.equalsIgnoreCase("book") || kind.equalsIgnoreCase("medical") || kind.equalsIgnoreCase("food");
    }

     BigDecimal getAllTaxes() {
        Double taxes = this.calculateTaxesPercentage();
        BigDecimal itemTax = getPrice().multiply(new BigDecimal(taxes)).multiply(new BigDecimal(getQuantity()));

        Double dblTax = Math.ceil(itemTax.doubleValue() / 0.05) * 0.05;
        BigDecimal roundedItemTax = new BigDecimal(dblTax).setScale(2, RoundingMode.HALF_UP);

        return roundedItemTax;
    }

    public void calculatePrice() {
        if (!isTaxed()) {
            BigDecimal allTaxes = getAllTaxes();
            System.out.println(allTaxes);
            setPrice(getPrice().add(allTaxes).setScale(2, RoundingMode.HALF_UP));
            setTaxes(allTaxes);
            this.taxed = true;
        }
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
