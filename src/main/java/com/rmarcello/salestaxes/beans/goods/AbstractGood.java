package com.rmarcello.salestaxes.beans.goods;

import java.text.DecimalFormat;

/**
 *
 * @author Raffaele Marcello
 */
public abstract class AbstractGood {
    protected int taxRate; //expressed in percentage
    
    private float price;
    private String name;
    
    protected AbstractGood(String name, float price, int taxRate) {
        this.name=name;
        this.price=price;
        this.taxRate=taxRate;
        
    }
    
    
    public float calculatePrice() {
        float tax = 0;
        if(this.taxRate!=0)
            tax = this.price*this.taxRate/100;
        System.out.println("p="+ (tax+this.price));
        return round(this.price+tax);
    }
    
    public float calculateTax() {
        float tax = 0;
        if(this.taxRate!=0)
            tax = this.price*this.taxRate/100;
        return round(tax);
    }

    private float round(float f) {
        float r = (float) Math.round(f * 100) / 100;
        return r;
    }

    @Override
    public String toString() {
        return  "taxRate=" + taxRate + ", price=" + price + ", name=" + name;
    }
    
}
