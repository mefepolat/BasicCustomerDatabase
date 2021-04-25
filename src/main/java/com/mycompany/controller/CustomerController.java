/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;


import com.mycompany.Model.Customer;
import com.mycompany.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    
    
    @GetMapping("/list")
    public String listCustomers(Model theModel) {
        
        List<Customer> theCustomers = customerService.getCustomers();
        
        theModel.addAttribute("customers", theCustomers);
        
        return "list-customers";
    }
   
    @GetMapping("/addCustomer")
    public String addCustomers(Model theModel) {
        
        Customer theCustomer = new Customer();
        
        theModel.addAttribute("customer", theCustomer);
        
        return "customer-form";
    }
    
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
        
        customerService.saveCustomer(theCustomer);
        
        
        return "redirect:/customer/list";
    }
    
    @GetMapping("/updateCustomer")
    public String updateCustomer(@RequestParam("customerId") int theId, Model theModel){
        
        Customer theCustomer = customerService.getCustomer(theId);
        
        theModel.addAttribute("customer", theCustomer);
        
        
        return "customer-form";
    }
    
    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId") int theId){
        
         customerService.deleteCustomer(theId);
        
        
        
        return "redirect:/customer/list";
    }
    
    @GetMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName, Model theModel) {
        
        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
        
        theModel.addAttribute("customers", theCustomers);
        
        return "list-customers";
    }
    
}
