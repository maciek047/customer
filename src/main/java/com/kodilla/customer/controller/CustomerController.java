package com.kodilla.customer.controller;

import com.kodilla.customer.controller.response.GetCustomerResponse;
import com.kodilla.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    @Value("${application.allow-get-accounts}")
    private boolean allowGetAccounts;

    private final CustomerService customerService;

    @GetMapping("/{customerId}")
    public GetCustomerResponse fetchAccounts (@PathVariable("customerId") int customerId){
        if(!allowGetAccounts) {
            log.info("Getting accounts is disabled");
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting accounts is disabled");
        }
        return new GetCustomerResponse(customerService.fetchCustomerById(customerId));
    }
}
