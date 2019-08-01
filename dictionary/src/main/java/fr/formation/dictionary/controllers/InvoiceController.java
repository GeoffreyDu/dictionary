package fr.formation.dictionary.controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.dictionary.business.Invoice;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @GetMapping("/{id}")
    public Invoice getOne(@PathVariable("id") Long id) {
	LocalDate date = LocalDate.of(2018, 12, 26);
	Invoice invoice = new Invoice("A01", date, 10.78);
	invoice.setPaid(true);
	invoice.setId(id);
	return invoice;
    }

    @GetMapping("")
    public ArrayList<Invoice> getAll(@RequestParam("size") int size,
	    @RequestParam("page") int page) {
	System.out.println("size= " + size + ", page= " + page);
	ArrayList<Invoice> invoiceList = new ArrayList<>();
	LocalDate date = LocalDate.of(2018, 12, 26);
	Invoice invoice = new Invoice("A01", date, 10.78);
	invoice.setPaid(true);
	LocalDate date2 = LocalDate.of(2019, 01, 16);
	Invoice invoice2 = new Invoice("A02", date2, 1210.78);
	invoiceList.add(invoice);
	invoiceList.add(invoice2);
	return invoiceList;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
	System.out.println("Deleted invoice with id: " + id);
    }

    @PostMapping()
    public void newInvoice(@RequestBody @Valid Invoice invoice) {
	System.out.println(invoice);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id,
	    @RequestBody Invoice invoice) {
	System.out.println(invoice);
    }

    @PatchMapping("/{id}/paid")
    public void paid(@PathVariable("id") Long id) {
	System.out.println("Paid invoice with id: " + id);
    }

    @PatchMapping("/{id}/unpaid")
    public void unpaid(@PathVariable("id") Long id) {
	System.out.println("Unpaid invoice with id: " + id);
    }
}
