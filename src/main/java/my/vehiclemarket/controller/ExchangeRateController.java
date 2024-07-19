package my.vehiclemarket.controller;

import my.vehiclemarket.service.impl.ExchangeRateServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exchange-rates")
public class ExchangeRateController {

    private ExchangeRateServiceImpl exchangeRateServiceImpl;

//    @GetMapping("/latest")
//    public ResponseEntity<Map<String, Double>> getLatestExchangeRates() {
//        Map<String, Double> exchangeRates = exchangeRateServiceImpl.getCurrentExchangeRates();
//        return ResponseEntity.ok(exchangeRates);
//    }
}