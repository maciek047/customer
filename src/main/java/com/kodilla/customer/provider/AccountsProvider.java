package com.kodilla.customer.provider;

import com.kodilla.customer.connector.AccountsConnector;
import com.kodilla.customer.dto.AccountDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountsProvider {
    private final AccountsConnector accountsConnector;

    @HystrixCommand(fallbackMethod = "fallbackGetAccounts")
    public List<AccountDto> getCustomerAccounts(Long customerId) {
        return accountsConnector.getAccounts(customerId)
                .getAccounts()
                .stream()
                .map(account -> new AccountDto(
                        1L,
                        account.getNrb(),
                        account.getCurrency(),
                        account.getAvailableFunds()))
                .collect(Collectors.toList());
    }

    private List<AccountDto> fallbackGetAccounts(Long customerId) {
        return Collections.emptyList();
    }
}