package com.rmarcello.salestaxes.beans.goods;

import com.rmarcello.salestaxes.logics.RoundStrategy;

/**
 * Abstract class, every Good extends this class.
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
    
    
    
    
    public float calculatePrice( RoundStrategy s ) {
        float tax = 0;
        if(this.taxRate!=0)
            tax = (this.price*this.taxRate)/100;
        
        return this.price + s.round(tax);
    }
    
    public float calculateTax( RoundStrategy s ) {
        float tax = 0;
        if(this.taxRate!=0)
            tax = (this.price*this.taxRate)/100;
        return s.round(tax);
    }

    @Override
    public String toString() {
        return "AbstractGood{" + "taxRate=" + taxRate + ", price=" + price + ", name=" + name + '}';
    }

}
