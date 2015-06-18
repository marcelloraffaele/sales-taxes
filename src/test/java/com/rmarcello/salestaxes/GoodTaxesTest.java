package com.rmarcello.salestaxes;

import com.rmarcello.salestaxes.beans.goods.Good;
import com.rmarcello.salestaxes.beans.goods.ImportedGood;
import com.rmarcello.salestaxes.beans.goods.ImportedNotTaxedGood;
import com.rmarcello.salestaxes.beans.goods.NotTaxedGood;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

public class GoodTaxesTest extends TestCase {


    public void testPriceGoodProduct() {
        Good g1 = new Good("music CD", 14.99f);
        assertEquals(g1.calculatePrice(), 16.49f);
    }
    
    public void testPriceNotTaxedGoodProduct() {
        NotTaxedGood g1 = new NotTaxedGood("chocolate bar", 0.85f);
        assertEquals(g1.calculatePrice(), 0.85f);
    }
    
    public void testPriceImportedGoodProduct() {
        ImportedGood g1 = new ImportedGood("bottle of parfume", 47.50f);
        assertEquals(g1.calculatePrice(), 54.65f);
    }
    
    public void testPriceImportedNotTaxedGoodProduct() {
        ImportedNotTaxedGood g1 = new ImportedNotTaxedGood("box of chocolate", 10.00f);
        assertEquals(g1.calculatePrice(), 10.50f);
    }
}
