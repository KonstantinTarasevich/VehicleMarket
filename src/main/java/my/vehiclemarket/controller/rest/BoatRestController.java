package my.vehiclemarket.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import my.vehiclemarket.model.entity.BoatEntity;
import my.vehiclemarket.service.BoatService;

import java.util.List;

@RestController
@RequestMapping("/api/boats")
public class BoatRestController {

    @Autowired
    private BoatService boatService;

    @GetMapping
    public List<BoatEntity> getAllBoats() {
        return boatService.findAll();
    }

    @GetMapping("/{id}")
    public BoatEntity getBoatById(@PathVariable Long id) {
        return boatService.findById(id);
    }

    @PostMapping
    public BoatEntity createBoat(@RequestBody BoatEntity boat) {
        return boatService.save(boat);
    }

    @PutMapping("/{id}")
    public BoatEntity updateBoat(@PathVariable Long id, @RequestBody BoatEntity boat) {
        boat.setId(id);
        return boatService.save(boat);
    }

    @DeleteMapping("/{id}")
    public void deleteBoat(@PathVariable Long id) {
        boatService.delete(id);
    }
}
