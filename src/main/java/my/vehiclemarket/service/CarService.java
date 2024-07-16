package my.vehiclemarket.service;

import my.vehiclemarket.model.entity.CarEntity;
import my.vehiclemarket.model.enums.CurrencyEnum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private ExchangeRateService exchangeRateService;


    private void convertPricesToCurrency(List<CarEntity> cars, String targetCurrency) {
        cars.forEach(car -> {
            double exchangeRate = exchangeRateService.getExchangeRate(targetCurrency);
            double convertedPrice = car.getPrice() * exchangeRate;
            car.setPrice(convertedPrice);
            car.setCurrency(CurrencyEnum.valueOf(targetCurrency));
        });
    }
}
