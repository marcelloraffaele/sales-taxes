package com.rmarcello.salestaxes.beans.goods;

/**
 *
 * @author Raffaele Marcello
 */
public class Good extends AbstractGood{
    
    public Good(String name, float price) {
        super( name, price, 10 );
    }
    
    @Override
    public String toString() {
        return "Good{" + super.toString() + '}';
    }
}
