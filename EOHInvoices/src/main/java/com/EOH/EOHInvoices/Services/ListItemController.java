/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EOH.EOHInvoices.Services;

import com.EOH.EOHInvoices.Repositories.ListItemRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.EOH.EOHInvoices.Model.ListItem;
import java.math.BigDecimal;


/**
 *
 * @author Fortune
 */

@RestController

public class ListItemController {
  
 //Initiate an Object by using Autowired
@Autowired
private ListItemRepository listItemRepository; 

@RequestMapping(value = "/addItem",method = RequestMethod.POST)
    public void addItem(@RequestBody ListItem list){
        list.setDescription("fortune");
	list.setQty((long) 18);
        BigDecimal one = new BigDecimal("2.55555");
	list.setUnitPrice(one);
        listItemRepository.save(list);
    }
    
}
