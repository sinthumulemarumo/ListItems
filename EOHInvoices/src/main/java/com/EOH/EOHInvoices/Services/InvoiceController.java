/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EOH.EOHInvoices.Services;
import com.EOH.EOHInvoices.Repositories.InoviceRepository;
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
import com.EOH.EOHInvoices.Model.Invoice;
import java.math.BigDecimal;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Fortune
 */

@RestController
public class InvoiceController {
    
    
	@Autowired
	private InoviceRepository invoiceRep;
	
	@PostMapping("/addInvoice")
	public Invoice addInvoice(@RequestBody Invoice invoice){

		invoice.setClient("Fortune");
		invoice.setVatRate((long) 25);
		invoice.setInvoiceDate(new Date());

		return invoiceRep.save(invoice);
	}
	

	@GetMapping("/allInvoices")
	public List<Invoice> viewAllInvoices(){

		return invoiceRep.findAll();
	}
	
	@RequestMapping("/getInvoice/{invoiceId}")
	public Invoice viewInvoice(@PathVariable Long invoiceId){

		return invoiceRep.getOne(invoiceId);

	}
    
}
