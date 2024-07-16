package my.vehiclemarket.service.impl;

import my.vehiclemarket.model.entity.CarEntity;
import my.vehiclemarket.model.enums.CurrencyEnum;
import my.vehiclemarket.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private ExchangeRateServiceImpl exchangeRateServiceImpl;


    private void convertPricesToCurrency(List<CarEntity> cars, String targetCurrency) {
        cars.forEach(car -> {
            double exchangeRate = exchangeRateServiceImpl.getExchangeRate(targetCurrency);
            double convertedPrice = car.getPrice() * exchangeRate;
            car.setPrice(convertedPrice);
            car.setCurrency(CurrencyEnum.valueOf(targetCurrency));
        });
    }
}
