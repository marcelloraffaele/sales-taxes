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

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
    
    
    
    
    public float calculatePrice() {
        float tax = 0;
        if(this.taxRate!=0)
            tax = (this.price*this.taxRate)/100;
        
        return this.price + round(tax);
    }
    
    public float calculateTax() {
        float tax = 0;
        if(this.taxRate!=0)
            tax = (this.price*this.taxRate)/100;
        return round(tax);
    }

    private float round(float f) {
//        float r = (float) Math.round(f * 100) / 100;
        //float r = (float) Math.round(f * 20.0f) / 20.0f;
        float r = (float) Math.ceil(f * 20.0f) / 20.0f;
        return r;
    }

    @Override
    public String toString() {
        return  "taxRate=" + taxRate + ", price=" + price + ", name=" + name;
    }
    
}
