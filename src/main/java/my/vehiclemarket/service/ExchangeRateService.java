package my.vehiclemarket.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class ExchangeRateService {

    @Value("${forex.api.key}")
    private String apiKey;

    @Value("${forex.api.url}")
    private String apiUrl;

    @Value("${forex.api.base}")
    private String baseCurrency;

    private Map<String, Double> exchangeRates = Collections.emptyMap();

    @PostConstruct
    public void init() {
        fetchExchangeRates();
    }

    public Double getExchangeRate(String targetCurrency) {
        if (baseCurrency.equals(targetCurrency)) {
            return 1.0;
        }

        String key = baseCurrency + "_" + targetCurrency;
        return exchangeRates.getOrDefault(key, 1.0);
    }

    @Scheduled(fixedRate = 43200000) // 12 hours
    private void fetchExchangeRates() {
        String url = apiUrl.replace("{app_id}", apiKey);
        RestTemplate restTemplate = new RestTemplate();
        ExchangeRateResponse response = restTemplate.getForObject(url, ExchangeRateResponse.class);

        if (response != null && response.getRates() != null) {
            Map<String, Double> newExchangeRates = new HashMap<>();
            for (String currency : response.getRates().keySet()) {
                String key = baseCurrency + "_" + currency;
                newExchangeRates.put(key, response.getRates().get(currency));
            }
            exchangeRates = newExchangeRates;
        }
    }

    public Map<String, Double> getCurrentExchangeRates() {
        return exchangeRates;
    }

    static class ExchangeRateResponse {
        private Map<String, Double> rates;

        public Map<String, Double> getRates() {
            return rates;
        }

        public void setRates(Map<String, Double> rates) {
            this.rates = rates;
        }
    }
}
