package my.vehiclemarket.service.impl;

import my.vehiclemarket.model.entity.TruckEntity;
import my.vehiclemarket.model.enums.CurrencyEnum;
import my.vehiclemarket.service.TruckService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TruckServiceImpl implements TruckService {

    private ExchangeRateServiceImpl exchangeRateServiceImpl;


//    private void convertPricesToCurrency(List<TruckEntity> cars, String targetCurrency) {
//        cars.forEach(car -> {
//            double exchangeRate = exchangeRateServiceImpl.getExchangeRate(targetCurrency);
//            double convertedPrice = car.getPrice() * exchangeRate;
//            car.setPrice(convertedPrice);
//            car.setCurrency(CurrencyEnum.valueOf(targetCurrency));
//        });
//    }
}
