package com.example.springdemo.controller;

import com.example.springdemo.model.Customer;
import com.example.springdemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class HelloController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/hello")
    public String hello(@RequestParam(required = false,defaultValue = "world") String name)
    {
        return "Hello" + name;
    }

    @GetMapping("/save")
    public Customer saveCustomer(@RequestParam String firstName,@RequestParam String lastName)
    {
        Customer customer = new Customer(firstName,lastName);
        customer = customerRepository.save(customer);
        return customer;
    }

    @GetMapping("/findById")
    public Customer findById(@RequestParam Long id)
    {
        Optional<Customer> customer =  customerRepository.findById(id);
        return customer.get();
    }

    @GetMapping("/findAll")
    public List<Customer> findAll()
    {
        return customerRepository.findAll();
    }

    @GetMapping("/findMany")
    public List<Customer> findManyPage()
    {
        PageRequest pageRequest = new PageRequest(1,2);
        return customerRepository.findAll(pageRequest).getContent();
    }
}
