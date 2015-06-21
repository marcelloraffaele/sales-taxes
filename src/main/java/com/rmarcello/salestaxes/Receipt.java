package com.rmarcello.salestaxes;

import com.rmarcello.salestaxes.beans.ReceiptItem;
import com.rmarcello.salestaxes.beans.ReceiptTotalResult;
import com.rmarcello.salestaxes.logics.RoundStrategy;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Raffaele Marcello
 */
public class Receipt {
    
    List<ReceiptItem> list;
    RoundStrategy roundStrategy;
    
    public Receipt( RoundStrategy s ) {
        this.list = new LinkedList<ReceiptItem>();
        this.roundStrategy = s;
    }
    
    public void addItem( ReceiptItem i ) {
        list.add( i );
    }

    @Override
    public String toString() {
        String s="";
        for( ReceiptItem i: list) {
            s+= i.getQuantity()+" "+ i.getGood().getName() + ": "+ i.getGood().calculatePrice(this.roundStrategy)+"\n";
        }
        ReceiptTotalResult r = this.getResult();
        s+= "Sales Taxes: " + r.getSalesTaxes() +"\n";
        s+= "Total: " + r.getTotal() ;
        return s;
    }

    public ReceiptTotalResult getResult() {
        float salesTaxes=0, total=0;
        for( ReceiptItem i: list) {
            salesTaxes += i.getQuantity()*i.getGood().calculateTax( this.roundStrategy );
            total += i.getQuantity()*i.getGood().calculatePrice( this.roundStrategy );
        }
        ReceiptTotalResult r = new ReceiptTotalResult(salesTaxes, total);
        return r;
    }
    
    
}
