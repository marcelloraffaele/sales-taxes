package com.rmarcello.salestaxes;

import com.rmarcello.salestaxes.beans.ReceiptItem;
import com.rmarcello.salestaxes.beans.ReceiptTotalResult;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Raffaele Marcello
 */
public class Receipt {
    
    List<ReceiptItem> list;
    
    public Receipt() {
        list = new LinkedList<ReceiptItem>();
    }
    
    public void addItem( ReceiptItem i ) {
        list.add( i );
    }

    @Override
    public String toString() {
        String s="";
        for( ReceiptItem i: list) {
            s+= i.getQuantity()+" "+ i.getGood().getName() + ": "+ i.getGood().calculatePrice()+"\n";
        }
        ReceiptTotalResult r = this.getResult();
        s+= "Sales Taxes: " + r.getSalesTaxes() +"\n";
        s+= "Total: " + r.getTotal() ;
        return s;
    }

    public ReceiptTotalResult getResult() {
        float salesTaxes=0, total=0;
        for( ReceiptItem i: list) {
            salesTaxes += i.getQuantity()*i.getGood().calculateTax();
            total += i.getQuantity()*i.getGood().calculatePrice();
        }
        ReceiptTotalResult r = new ReceiptTotalResult(salesTaxes, total);
        return r;
    }
    
    
}
