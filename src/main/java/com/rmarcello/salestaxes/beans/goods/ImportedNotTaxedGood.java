package com.rmarcello.salestaxes.beans.goods;

/**
 *
 * @author Raffaele Marcello
 */
public class ImportedNotTaxedGood extends NotTaxedGood{
    public ImportedNotTaxedGood(String name, float price) {
        super(name, price);
        this.taxRate = this.taxRate+5;
    }
}
