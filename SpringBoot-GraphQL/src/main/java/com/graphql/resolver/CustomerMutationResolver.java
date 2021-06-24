package com.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.dto.CustomerDto;
import com.graphql.model.Customer;
import com.graphql.repo.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class CustomerMutationResolver implements GraphQLMutationResolver {

    private final CustomerRepository customerRepository;


    public Customer saveCustomer(CustomerDto customerDto){
       return customerRepository.save(convertToCustomer(customerDto));
    }

    private Customer convertToCustomer(CustomerDto customerDto){
        Customer customer =new Customer();
        customer.setName(customerDto.getName());
        customer.setSurName(customerDto.getSurName());
        customer.setMail(customerDto.getMail());
        customer.setAddress(customerDto.getAddress());
        customer.setBirthofDate(LocalDate.of(1987,05,15));
        return customer;
    }
}
