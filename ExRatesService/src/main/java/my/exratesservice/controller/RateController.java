package my.exratesservice.controller;


import my.exratesservice.model.entity.RateEntity;
import my.exratesservice.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rates")
public class RateController {

    @Autowired
    private RateService rateService;

    @GetMapping
    public Iterable<RateEntity> getAllRates() {
        return rateService.getAllRates();
    }

    @PostMapping
    public RateEntity saveRate(@RequestBody RateEntity rate) {
        return rateService.saveRate(rate);
    }

    @DeleteMapping("/{id}")
    public void deleteRate(@PathVariable Long id) {
        rateService.deleteRate(id);
    }
}
