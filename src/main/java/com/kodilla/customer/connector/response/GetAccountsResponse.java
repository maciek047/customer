package com.kodilla.customer.connector.response;

import com.kodilla.customer.dto.AccountDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class GetAccountsResponse {

    public List<AccountDto> accounts;

}