package com.kodilla.customer.connector;

import com.kodilla.customer.config.RibbonConfiguration;
import com.kodilla.customer.connector.response.GetCardsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Collections;

@RibbonClient(name = "cards", configuration = RibbonConfiguration.class)
@FeignClient(name = "cards", fallback = CardsConnectorFallback.class)
public interface CardsConnector {

    @GetMapping("/v1/cards")
    GetCardsResponse getCards(@RequestParam("customerId") Long customerId);

}

@Slf4j
@Component
class CardsConnectorFallback implements CardsConnector {
    @Override
    public GetCardsResponse getCards(Long customerId) {
        log.warn("Can not get cards for customerId: {}", customerId);
        return GetCardsResponse.of(Collections.emptyList());
    }
}
