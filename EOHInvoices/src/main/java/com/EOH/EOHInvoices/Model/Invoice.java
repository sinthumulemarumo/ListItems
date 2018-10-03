/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EOH.EOHInvoices.Model;

import com.EOH.EOHInvoices.Model.ListItem;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 *
 * @author Fortune
 */

@Entity
@Table(name="Invoice")
public class Invoice implements Serializable  {
 
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Column(name="invoice_id")
private Long id;
 @Column(name="client")
private String client;
 @Column(name="vatRate")
private Long vatRate;
 @Column(name="invoiceDate")
 @Temporal(TemporalType.DATE)
private Date invoiceDate;
 @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
 
 //Invoice exist only if there's an List of Item
private List<ListItem> listItems;
 //Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setVatRate(Long vatRate) {
        this.vatRate = vatRate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
 
    //Getters

    public Long getId() {
        return id;
    }

    public String getClient() {
        return client;
    }

    public Long getVatRate() {
        return vatRate;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }
      public List<ListItem> getLineItems() {
        return listItems;
    }


    public BigDecimal getVat() {

	    BigDecimal itemsTotal = new BigDecimal(0);

            //Count list of itmes in an array
            for (int x = 0; x < this.getLineItems().size(); x++){

           itemsTotal = itemsTotal.add(this.getLineItems().get(x).getLineItemTotal().multiply(BigDecimal.valueOf(this.getVatRate())));
       }

       return itemsTotal.divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getSubTotal() {

        return this.getTotal().subtract(this.getVat());
    }

    public BigDecimal getTotal() {

        return this.getSubTotal().add(this.getVat());
    }
  
}
