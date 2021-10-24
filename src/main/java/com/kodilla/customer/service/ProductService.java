package com.kodilla.customer.service;


import com.kodilla.customer.dto.AccountDto;
import com.kodilla.customer.dto.CardDto;
import com.kodilla.customer.provider.AccountsProvider;
import com.kodilla.customer.provider.CardsProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final AccountsProvider accountProvider;
    private final CardsProvider cardsProvider;

    public List<AccountDto> findCustomerAccounts(Long customerId) {
        return accountProvider.getCustomerAccounts(customerId);
    }

    public List<CardDto> findCustomerCards(Long customerId) {
        return cardsProvider.getCustomerCards(customerId);
    }
}
