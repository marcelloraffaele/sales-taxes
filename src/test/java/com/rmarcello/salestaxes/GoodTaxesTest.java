package com.rmarcello.salestaxes;

import com.rmarcello.salestaxes.beans.goods.Good;
import com.rmarcello.salestaxes.beans.goods.ImportedGood;
import com.rmarcello.salestaxes.beans.goods.ImportedNotTaxedGood;
import com.rmarcello.salestaxes.beans.goods.NotTaxedGood;
import com.rmarcello.salestaxes.logics.Nearest5CentRoundStrategy;
import com.rmarcello.salestaxes.logics.RoundStrategy;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GoodTaxesTest {

    public static final RoundStrategy s = new Nearest5CentRoundStrategy();
    
    @Test
    public void testPriceGoodProduct() {
        Good g1 = new Good("music CD", 14.99f);
        assertEquals( 16.49f, g1.calculatePrice( s ), 0f);
    }
    
    @Test
    public void testPriceNotTaxedGoodProduct() {
        NotTaxedGood g1 = new NotTaxedGood("chocolate bar", 0.85f);
        assertEquals( 0.85f, g1.calculatePrice( s ), 0f);
    }
    
    @Test
    public void testPriceImportedGoodProduct() {
        ImportedGood g1 = new ImportedGood("bottle of parfume", 47.50f);
        assertEquals(54.65f, g1.calculatePrice( s ), 0f);
    }
    
    @Test
    public void testPriceImportedGoodProduct2() {
        ImportedGood g1 = new ImportedGood("bottle of parfume", 27.99f);
        assertEquals( 32.19f, g1.calculatePrice( s ), 0f);
    }
    
    @Test
    public void testPriceImportedNotTaxedGoodProduct() {
        ImportedNotTaxedGood g1 = new ImportedNotTaxedGood("box of chocolate", 10.00f);
        assertEquals( 10.50f, g1.calculatePrice( s ), 0f);
    }
    
    public void testPriceTaxedGoodProduct2() {
        Good g1 = new Good("bottle of porfume", 18.99f );
        assertEquals(20.89f, g1.calculatePrice( s ), 0f);
    }
    
    @Test
    public void testPriceImportedNotTaxedGoodProduct2() {
        ImportedNotTaxedGood g1 = new ImportedNotTaxedGood("box of chocolate", 11.25f);
        assertEquals(11.85f, g1.calculatePrice( s ), 0f);
    }
}
