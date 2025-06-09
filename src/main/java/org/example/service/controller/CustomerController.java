package org.example.service.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.service.domain.Customer;
import org.example.service.dto.customerDto.CustomerSaveRequest;
import org.example.service.response.ControllerResponse;
import org.example.service.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
//TODO annotation
@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;


    @PostMapping("/new-customer-up")
    public ControllerResponse newCustomer(@Valid @RequestBody CustomerSaveRequest customerSaveRequest) {
        customerService.saveNewCustomer(customerSaveRequest);
        return new ControllerResponse
                ("customer by email: "+customerSaveRequest.getEmail()+"signed up" ,
                        LocalDate.now());


    }


}
