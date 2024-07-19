package my.vehiclemarket.service.impl;

import my.vehiclemarket.model.entity.BoatEntity;
import my.vehiclemarket.model.enums.CurrencyEnum;
import my.vehiclemarket.service.BoatService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoatServiceImpl implements BoatService {

    private ExchangeRateServiceImpl exchangeRateServiceImpl;

//    private void convertPricesToCurrency(List<BoatEntity> cars, String targetCurrency) {
//        cars.forEach(car -> {
//            double exchangeRate = exchangeRateServiceImpl.getExchangeRate(targetCurrency);
//            double convertedPrice = car.getPrice() * exchangeRate;
//            car.setPrice(convertedPrice);
//            car.setCurrency(CurrencyEnum.valueOf(targetCurrency));
//        });
//    }
}
