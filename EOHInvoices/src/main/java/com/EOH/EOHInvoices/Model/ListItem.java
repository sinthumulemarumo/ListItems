/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EOH.EOHInvoices.Model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @autho Fortune
 */

@Entity
@Table(name="LineItem")
public class ListItem implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="lineItem_id")
    private Long item_id;
    @Column(name="qty")
    private Long qty;
    @Column(name="description")
    private String description;
    @Column(name="unitPrice")
    private BigDecimal unitPrice; 
    
    //Getters

    public Long getItem_id() {
        return item_id;
    }

    public Long getQty() {
        return qty;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    
    //Setters
    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    //Calcualte Total
  public BigDecimal getLineItemTotal(){

return this.getUnitPrice().multiply(BigDecimal.valueOf(this.getQty()));
	}  
    
}
