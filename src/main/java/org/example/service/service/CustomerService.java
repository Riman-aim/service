package org.example.service.service;

import org.example.service.convertor.Convertor;
import org.example.service.domain.Customer;
import org.example.service.dto.customerDto.CustomerSaveRequest;
import org.example.service.enumeration.AwaitingStatus;
import org.example.service.exception.EmailDuplicatedException;
import org.example.service.exception.PasswordIsNotCombinedException;
import org.example.service.repository.CustomerRepository;
import org.example.service.utils.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final Convertor convertor;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, Convertor convertor) {
        this.customerRepository = customerRepository;
        this.convertor = convertor;
    }

    public void saveNewCustomer(CustomerSaveRequest customerSaveRequest) {
        if (customerRepository.existsByEmail(customerSaveRequest.getEmail())) {
            throw new EmailDuplicatedException("Email already exists");
        }
        if (!Authentication.isPasswordValid(customerSaveRequest.getPassword())) {
            throw new PasswordIsNotCombinedException("Password isn't combined or the length");
        }
        Customer customer = convertor.customerSaveRequestToCustomer(customerSaveRequest);
        customer.setAwaitingStatus(AwaitingStatus.AWAITING);
        customer.setCreatedDate(LocalDate.now());
        customerRepository.save(customer);

    }
}
