package com.rmarcello.salestaxes.beans;

import com.rmarcello.salestaxes.beans.goods.AbstractGood;

/**
 *
 * @author Raffaele Marcello
 */
public class ReceiptItem {
    private int quantity;
    private AbstractGood good;

    public ReceiptItem(int quantity, AbstractGood good) {
        this.quantity = quantity;
        this.good = good;
    }

    @Override
    public String toString() {
        return "ReceiptItem{"+ quantity + ": " + good + '}';
    }

    public AbstractGood getGood() {
        return good;
    }

    public int getQuantity() {
        return quantity;
    }
    
    
        
}
