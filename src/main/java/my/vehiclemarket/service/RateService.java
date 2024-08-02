package my.vehiclemarket.service;


import my.vehiclemarket.model.entity.RateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class RateService {

    private final String exchangeRateServiceUrl = "http://localhost:8080/rates";

    @Autowired
    private RestTemplate restTemplate;

    public List<RateEntity> getAllRates() {
        RateEntity[] rates = restTemplate.getForObject(exchangeRateServiceUrl, RateEntity[].class);
        return Arrays.asList(rates);
    }

    public RateEntity saveRate(RateEntity rate) {
        return restTemplate.postForObject(exchangeRateServiceUrl, rate, RateEntity.class);
    }

    public void deleteRate(Long id) {
        restTemplate.delete(exchangeRateServiceUrl + "/" + id);
    }
}
