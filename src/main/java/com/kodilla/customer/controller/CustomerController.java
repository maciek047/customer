package com.kodilla.customer.controller;

import com.kodilla.customer.controller.response.GetCustomerProductsResponse;
import com.kodilla.customer.controller.response.GetCustomerResponse;
import com.kodilla.customer.dto.AccountDto;
import com.kodilla.customer.dto.CardDto;
import com.kodilla.customer.service.CustomerService;
import com.kodilla.customer.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    @Value("${application.allow-get-accounts}")
    private boolean allowGetAccounts;

    private final CustomerService customerService;
    private final ProductService productService;

    @GetMapping("/{customerId}")
    public GetCustomerResponse fetchAccounts (@PathVariable("customerId") long customerId){
        if(!allowGetAccounts) {
            log.info("Getting accounts is disabled");
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting accounts is disabled");
        }
        return new GetCustomerResponse(customerService.fetchCustomerById(customerId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST)));
    }

    @GetMapping("/{customerId}/products")
    public GetCustomerProductsResponse getCustomerProducts(@PathVariable Long customerId) {
        var customerDto = customerService.fetchCustomerById(customerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));

        List<AccountDto> customerAccounts = productService.findCustomerAccounts(customerId);
        List<CardDto> customerCards = productService.findCustomerCards(customerId);

        return GetCustomerProductsResponse.builder()
                .customerId(customerDto.getId())
                .fullName(customerDto.getFirstName() + " " + customerDto.getLastName())
                .accounts(customerAccounts)
                .cards(customerCards)
                .build();
    }
}
