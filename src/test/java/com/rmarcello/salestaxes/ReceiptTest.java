package com.rmarcello.salestaxes;

import com.rmarcello.salestaxes.beans.Receipt;
import com.rmarcello.salestaxes.beans.ReceiptItem;
import com.rmarcello.salestaxes.beans.ReceiptTotalResult;
import com.rmarcello.salestaxes.beans.goods.Good;
import com.rmarcello.salestaxes.beans.goods.ImportedGood;
import com.rmarcello.salestaxes.beans.goods.ImportedNotTaxedGood;
import com.rmarcello.salestaxes.beans.goods.NotTaxedGood;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

public class ReceiptTest extends TestCase {


    public void testReceipt1() {
        
        Receipt r = new Receipt();
        r.addItem( new ReceiptItem( 1, new NotTaxedGood("book", 12.49f) ) );
        r.addItem( new ReceiptItem( 1, new Good("music CD", 14.99f) ) );
        r.addItem( new ReceiptItem( 1, new NotTaxedGood("chocolate bar", 0.85f) ) );
        
//        System.out.println("r:"+r);
        
        ReceiptTotalResult res = r.getResult();
        
//        System.out.println("res:"+res);
        
        assertEquals(res.getSalesTaxes(), 1.50f);
        assertEquals(res.getTotal(), 29.83f);
    }
    
    public void testReceipt2() {
        
        Receipt r = new Receipt();
        r.addItem( new ReceiptItem( 1, new ImportedNotTaxedGood("imported box of chocolate", 10.00f) ) );
        r.addItem( new ReceiptItem( 1, new ImportedGood("imported bottle of porfume", 47.50f) ) );
        
        ReceiptTotalResult res = r.getResult();
        assertEquals(res.getSalesTaxes(), 7.65f);
        assertEquals(res.getTotal(), 65.15f);
    }
    
    public void testReceipt3() {
        
        Receipt r = new Receipt();
        r.addItem( new ReceiptItem( 1, new ImportedGood("imported bottle of porfume", 27.99f) ) );
        r.addItem( new ReceiptItem( 1, new Good("bottle of porfume", 18.99f) ) );
        r.addItem( new ReceiptItem( 1, new NotTaxedGood("packet of headache pills", 9.75f) ) );
        r.addItem( new ReceiptItem( 1, new ImportedNotTaxedGood("box of imported chocolate", 11.25f) ) );
        
        ReceiptTotalResult res = r.getResult();
        assertEquals(res.getSalesTaxes(), 7.65f);
        assertEquals(res.getTotal(), 65.15f);
    }
    
}
