package com.rmarcello.salestaxes;

import com.rmarcello.salestaxes.beans.ReceiptItem;
import com.rmarcello.salestaxes.beans.ReceiptTotalResult;
import com.rmarcello.salestaxes.beans.goods.Good;
import com.rmarcello.salestaxes.beans.goods.ImportedGood;
import com.rmarcello.salestaxes.beans.goods.ImportedNotTaxedGood;
import com.rmarcello.salestaxes.beans.goods.NotTaxedGood;
import com.rmarcello.salestaxes.logics.Nearest5CentRoundStrategy;
import com.rmarcello.salestaxes.logics.RoundStrategy;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ReceiptTest{

    @Test
    public void testReceipt1() {
        RoundStrategy s = new Nearest5CentRoundStrategy();
        Receipt r = new Receipt( s );
        r.addItem( new ReceiptItem( 1, new NotTaxedGood("book", 12.49f) ) );
        r.addItem( new ReceiptItem( 1, new Good("music CD", 14.99f) ) );
        r.addItem( new ReceiptItem( 1, new NotTaxedGood("chocolate bar", 0.85f) ) );
        
        System.out.println( r );
        
        ReceiptTotalResult res = r.getResult();
        assertEquals( 1.50f,res.getSalesTaxes(),  0f);
        assertEquals( 29.83f, res.getTotal(), 0f);
    }
    
    @Test
    public void testReceipt2() {
        RoundStrategy s = new Nearest5CentRoundStrategy();
        Receipt r = new Receipt( s );
        r.addItem( new ReceiptItem( 1, new ImportedNotTaxedGood("imported box of chocolate", 10.00f) ) );
        r.addItem( new ReceiptItem( 1, new ImportedGood("imported bottle of porfume", 47.50f) ) );
        
        System.out.println( r );
        
        ReceiptTotalResult res = r.getResult();
        assertEquals( 7.65f, res.getSalesTaxes(),0f);
        assertEquals( 65.15f,res.getTotal(), 0f);
    }
    
    @Test
    public void testReceipt3() {
        RoundStrategy s = new Nearest5CentRoundStrategy();
        Receipt r = new Receipt( s );
        r.addItem( new ReceiptItem( 1, new ImportedGood("imported bottle of porfume", 27.99f) ) );
        r.addItem( new ReceiptItem( 1, new Good("bottle of porfume", 18.99f) ) );
        r.addItem( new ReceiptItem( 1, new NotTaxedGood("packet of headache pills", 9.75f) ) );
        r.addItem( new ReceiptItem( 1, new ImportedNotTaxedGood("box of imported chocolate", 11.25f) ) );
        
        System.out.println( r );
        
        ReceiptTotalResult res = r.getResult();
        assertEquals( 6.70f, res.getSalesTaxes(), 0f);
        assertEquals( 74.68f, res.getTotal(), 0f); 
        
        
    }

}
