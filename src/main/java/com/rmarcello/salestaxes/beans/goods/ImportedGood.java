package com.rmarcello.salestaxes.beans.goods;

/**
 *
 * @author Raffaele Marcello
 */
public class ImportedGood extends Good{
    
    public ImportedGood(String name, float price) {
        super(name, price);
        this.taxRate = this.taxRate+5;
    }
    
}
