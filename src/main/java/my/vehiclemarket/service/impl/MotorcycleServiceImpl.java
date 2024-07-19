package my.vehiclemarket.service.impl;

import my.vehiclemarket.model.entity.MotorcycleEntity;
import my.vehiclemarket.model.enums.CurrencyEnum;
import my.vehiclemarket.service.MotorcycleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorcycleServiceImpl implements MotorcycleService {

    private ExchangeRateServiceImpl exchangeRateServiceImpl;

//    private void convertPricesToCurrency(List<MotorcycleEntity> cars, String targetCurrency) {
//        cars.forEach(car -> {
//            double exchangeRate = exchangeRateServiceImpl.getExchangeRate(targetCurrency);
//            double convertedPrice = car.getPrice() * exchangeRate;
//            car.setPrice(convertedPrice);
//            car.setCurrency(CurrencyEnum.valueOf(targetCurrency));
//        });
//    }
}
