package com.rmarcello.salestaxes.beans.goods;

/**
 *
 * @author Raffaele Marcello
 */
public class NotTaxedGood extends AbstractGood{
    public NotTaxedGood(String name, float price) {
        super( name, price, 0 );
    }

    @Override
    public String toString() {
        return "NotTaxedGood{" + super.toString() + '}';
    }
    
    
}
