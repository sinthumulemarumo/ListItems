/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EOH.EOHInvoices.Repositories;

import com.EOH.EOHInvoices.Model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Fortune
 */
public interface InoviceRepository extends JpaRepository<Invoice, Long> {
    
}
 