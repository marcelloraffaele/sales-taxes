package com.rmarcello.salestaxes.beans;

/**
 *
 * @author Raffaele Marcello
 */
public class ReceiptTotalResult {
    float salesTaxes,total;

    public ReceiptTotalResult(float salesTaxes, float total) {
        this.salesTaxes = salesTaxes;
        this.total = total;
    }

    public float getSalesTaxes() {
        return salesTaxes;
    }

    public float getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "ReceiptTotalResult{" + "salesTaxes=" + salesTaxes + ", total=" + total + '}';
    }
    
    
}
