package my.vehiclemarket.service;


import my.vehiclemarket.model.entity.BoatEntity;
import my.vehiclemarket.model.entity.MotorcycleEntity;
import my.vehiclemarket.model.entity.TruckEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import my.vehiclemarket.model.entity.CarEntity;

@Service
public class RestClientService {

    private final RestTemplate restTemplate;

    public RestClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CarEntity getCarFromRemoteService(Long id) {
        String url = "http://remote-service-url/api/cars/" + id;
        return restTemplate.getForObject(url, CarEntity.class);
    }

    public BoatEntity getBoatFromRemoteService(Long id) {
        String url = "http://remote-service-url/api/boats/" + id;
        return restTemplate.getForObject(url, BoatEntity.class);
    }

    public MotorcycleEntity getMotorcycleFromRemoteService(Long id) {
        String url = "http://remote-service-url/api/motorcycles/" + id;
        return restTemplate.getForObject(url, MotorcycleEntity.class);
    }

    public TruckEntity getTruckFromRemoteService(Long id) {
        String url = "http://remote-service-url/api/trucks/" + id;
        return restTemplate.getForObject(url, TruckEntity.class);
    }
}
