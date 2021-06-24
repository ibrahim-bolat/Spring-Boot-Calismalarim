package com.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.model.Customer;
import com.graphql.repo.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomerQueryResolver implements GraphQLQueryResolver {

    private final CustomerRepository customerRepository;

    public List<Customer> getAllLikeCustomers(String name){
     return customerRepository.findByNameLike(name);
    }
    public Optional<Customer> findById(int id){
        return customerRepository.findById(id);
    }
}

